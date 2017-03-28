package ch.usi.delrig.ristretto;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds all the parameters for an invocation of the main class Ristr.
 */
public class RistrParameters{
    
    public enum MainCommand{ PARSE, TYPECHECK };
    
    public MainCommand mainCommand = MainCommand.PARSE;
    public boolean verbose = false;
    public boolean makeDot = false;
    public String dotFilename = null;
    public List<String> inputFiles = new ArrayList<String>();
    
    public void parseCommandLineParameters( String[] args ){
        try {
            if( args.length < 2 )
                throw new IllegalArgumentException( "please specify a command and a filename" );
            if( !args[0].startsWith("-") || args[0].length() != 2 ) 
                throw new IllegalArgumentException( "please specify an unique command" );
            switch( args[0].charAt(1) ){
            case 'p': mainCommand = MainCommand.PARSE; break;
            case 't': mainCommand = MainCommand.TYPECHECK; break;
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
            showUsage();
            System.exit(1);
        }
    }
    
    public static void showUsage(){
        System.out.println( "usage: Ristr command [options] filename" );
        System.out.println( "\tcommand must be one of the following:" );
        System.out.println( "\t-p\t parse filename" );
        System.out.println( "\t-t\t parse and typecheck filename" );
        System.out.println( "\toptions can be:" );
        System.out.println( "\t-v\t\t verbose" );
        System.out.println( "\t-dot outfile\t write a dot representation of the intermediate\n"
                + "\t\t\t language produced by the command into outfile" );
        
    }
}
