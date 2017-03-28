package ch.usi.delrig.ristretto;

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
 * Ristretto main class. Create an instance of this class to execute parsing,
 * type checking, translation etc, etc.
 * 
 * @author Giacomo Del Rio
 */
public class Ristr {
	
    public final RistrParameters params;
    
    public Ristr( RistrParameters params ){
        this.params = params;
    }
	
	public void info( String s ){
		if( params.verbose )
			System.out.println( s );
	}
	
	public Module parseFile( String filename ){
		try{
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
        }catch( Exception e ){
            System.err.println( e );
            System.exit( 1 );
            return null;
        }
	}
	
	public void typeCheck( List<Module> modules ){
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
	
	private void makeDotFile( Module m ){
		try{
		    // Write a DOT representation of the AST
	        info( "Create dot file." );
	        DotWriter dw = new DotWriter( params.dotFilename );
	        dw.generate( m );
	        
    		Process tr = Runtime.getRuntime().exec( 
    				new String[]{ "/usr/local/bin/dot", "-Tpdf", "-o", 
    				        params.dotFilename + ".pdf", params.dotFilename } );
    		tr.waitFor();
		}catch( Exception e ){
		    System.err.println( e );
		    System.exit( 0 );
		}
	}
	
	/**
	 * Executes the main command specified in parameters.
	 */
	public void executeMainCommand(){
	    Module m = null;
        switch( params.mainCommand ){
        case PARSE: // Parse only
            m = parseFile( params.inputFiles.get( 0 ) );
            break;
            
        case TYPECHECK: // Parse and typecheck
            m = parseFile( params.inputFiles.get( 0 ) );
            List<Module> modules = new ArrayList<Module>();
            modules.add( m );
            typeCheck( modules );
            break;
        }
        
        if( params.makeDot )
            makeDotFile( m );
    }

	/**
	 * Ristretto main entry point.
	 * 
	 * @param args Command line parameters. See RistrParameters class for usage.
	 */
	public static void main( String[] args ){
	    RistrParameters params = new RistrParameters();
	    params.parseCommandLineParameters( args );
		Ristr instance = new Ristr( params );
		instance.executeMainCommand();
	}
}
