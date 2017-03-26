package ch.usi.delrig.ristretto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ch.usi.delrig.ristretto.antlrparser.RistrettoParser;
import ch.usi.delrig.ristretto.ast.ASTBuilder;
import ch.usi.delrig.ristretto.ast.Module;
import ch.usi.delrig.ristretto.typechecker.StaticAnalysisException;
import ch.usi.delrig.ristretto.typechecker.TypeChecker;

/***
 * Ristretto main class
 * 
 * @author Giacomo Del Rio
 */
public class Ristr {
	
	private static char command = '.';
	private static boolean verbose = false;
	private static boolean makeDot = false;
	private static String dotFilename = null;
	private static List<String> inputFiles = new ArrayList<String>();
	
	private static void parseCommandLineParameters( String[] args ){
		try {
			if( !args[0].startsWith("-") || args[0].length() != 2 ) 
				throw new IllegalArgumentException( "please specify an unique command" );
			switch( args[0].charAt(1) ){
			case 'p': command = 'p'; break;
			case 't': command = 't'; break;
			default:
				throw new IllegalArgumentException( "unknown command '" + args[0].charAt(1) + "'" );
			}
			
		    for( int i = 1; i < args.length; ++i ){
				if( args[i].equals("-v") ) 
					verbose = true;
				else if( args[i].equals("-dot") ){
					makeDot = true;
					if( args.length < i+2 )
						throw new IllegalArgumentException( "missing dot filename with -dot option." );
					dotFilename = args[++i];
				}else if( args[i].startsWith("-") )
					throw new IllegalArgumentException("unknown option: " + args[i]);
				else
					inputFiles.add( args[i] );
		    }
		    
		    if( inputFiles.isEmpty() )
		    	throw new IllegalArgumentException( "please specify an input file" );
		}catch( IllegalArgumentException ex ){
		    System.err.println( "Error: " + ex.getMessage() );
		    System.err.println( "usage: Ristr command [-v] [-dot outfile] filename" );
		    System.err.println( "\tcommand must be one of the following:" );
		    System.err.println( "\t-p\t parse filename" );
		    System.err.println( "\t-t\t parse and typecheck filename" );
		    System.exit(1);
		}
	}
	
	private static void info( String s ){
		if( verbose )
			System.out.println( s );
	}
	
	public static Module parseFile( String filename ) throws IOException{
		// Parse the input file
		info( "Start parsing..." );
		ANTLRFileStream input = new ANTLRFileStream( filename );
		BailRistrettoLexer lexer = new BailRistrettoLexer( input );
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		RistrettoParser parser = new RistrettoParser( tokens );
		parser.removeErrorListeners();
		parser.addErrorListener( new BailErrorListener() );
		ParseTree tree = parser.module();
		info( "Parsing done." );
		
		// Create the AST from the parse tree
		info( "AST creation..." );
		ASTBuilder astBuilder = new ASTBuilder( filename );
		Module m = (Module)astBuilder.visit( tree );
		m.name = filename;
		info( "AST created." );
		
		return m;
	}
	
	public static void typeCheck( List<Module> modules ){
		try{
			info( "Begin static analysis..." );
			TypeChecker tc = new TypeChecker();
			tc.check( modules );
			info( "Static analysis completed." );
		}catch( StaticAnalysisException e ){
			System.err.println( e );
			System.exit( 1 );
		}
	}
	
	private static void makeDotFile( Module m ) throws IOException, InterruptedException{
		// Write a DOT representation of the AST
		info( "Create dot file." );
		DotWriter dw = new DotWriter( dotFilename );
		dw.generate( m );
		
		Process tr = Runtime.getRuntime().exec( 
				new String[]{ "/usr/local/bin/dot", "-Tpdf", "-o", dotFilename + ".pdf", dotFilename } );
		tr.waitFor();
	}

	public static void main( String[] args ) throws IOException, InterruptedException{
		
		parseCommandLineParameters( args );
		
		Module m = null;
		switch( command ){
		case 'p':	// Parse only
			m = parseFile( inputFiles.get( 0 ) );
			break;
			
		case 't':	// Parse and typecheck
			m = parseFile( inputFiles.get( 0 ) );
			List<Module> modules = new ArrayList<Module>();
			modules.add( m );
			typeCheck( modules );
			break;
		}
		
		if( makeDot )
			makeDotFile( m );
	}
}
