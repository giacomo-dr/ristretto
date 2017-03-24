package ch.usi.delrig.ristretto;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ch.usi.delrig.ristretto.antlrparser.RistrettoParser;
import ch.usi.delrig.ristretto.ast.ASTBuilder;
import ch.usi.delrig.ristretto.ast.Program;

/***
 * Ristretto main class
 * 
 * @author Giacomo Del Rio
 */
public class Ristr {
	
	private static boolean verbose = false;
	private static boolean makeDot = false;
	private static String dotFilename = null;
	private static String inputFile = null;
	
	private static void parseCommandLineParameters( String[] args ){
		try {
		    for( int i = 0; i < args.length; ++i ){
				if( args[i].equals("-v") ) 
					verbose = true;
				else if( args[i].equals("-dot") ){
					makeDot = true;
					if( args.length < i+2 )
						throw new Exception( "missing dot filename with -dot option" );
					dotFilename = args[++i];
				}else if( args[i].startsWith("-") )
					throw new Exception("unknown option: " + args[i]);
				else
					inputFile = args[i];
		    }
		}catch( Exception ex ){
		    System.err.println(ex);
		    System.err.println( "usage: Ristr [-v] [-dot outfile] filename" );
		    System.exit(1);
		}
	}
	
	private static void info( String s ){
		if( verbose )
			System.out.println( s );
	}

	public static void main( String[] args ) throws IOException, InterruptedException{
		
		parseCommandLineParameters( args );
		
		// Parse the input file
		info( "Start parsing..." );
		ANTLRFileStream input = new ANTLRFileStream( inputFile );
		BailRistrettoLexer lexer = new BailRistrettoLexer( input );
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		RistrettoParser parser = new RistrettoParser( tokens );
		parser.removeErrorListeners();
		parser.addErrorListener( new BailErrorListener() );
		ParseTree tree = parser.program();
		info( "Parsing done." );
		
		// Create the AST from the parse tree
		info( "AST creation..." );
		ASTBuilder astBuilder = new ASTBuilder();
		Program p = (Program)astBuilder.visit( tree );
		info( "AST created." );
		
		// Write a DOT representation of the AST
		if( makeDot ){
			info( "Create dot file." );
			DotWriter dw = new DotWriter( dotFilename );
			dw.generate( p );
			
//			Process tr = Runtime.getRuntime().exec( 
//					new String[]{ "/usr/local/bin/dot", "-Tpdf", "-o", dotFilename + ".pdf", dotFilename } );
//			tr.waitFor();
		}
	}
}
