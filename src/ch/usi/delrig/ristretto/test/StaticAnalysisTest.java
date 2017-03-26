package ch.usi.delrig.ristretto.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.usi.delrig.ristretto.Ristr;
import ch.usi.delrig.ristretto.ast.Module;
import ch.usi.delrig.ristretto.typechecker.StaticAnalysisException;
import ch.usi.delrig.ristretto.typechecker.TypeChecker;

public class StaticAnalysisTest {

	public static void main( String[] args ){
		File dir = new File( args[0] );
		File[] testFiles = dir.listFiles();
		int failed = 0;
		for( int i = 0 ; i < testFiles.length ; i++ ){
			System.out.print( "Executing test " + (i+1)
					+ "/" + testFiles.length + " [" + testFiles[i].getName() + "] ..." );
			if( !executeTest( testFiles[i] ) ){
				failed++;
				System.out.println( "**failed**." );
			}else{
				System.out.println( "passed." );
			}
		}
		System.out.println( "Passed " + (testFiles.length - failed) + 
				" out of " + testFiles.length + " tests." );
	}
	
	private static String getTestExpectedResult( File test ) throws IOException{
	    String expectedResult = test.getName().split("\\.")[0];
        expectedResult = expectedResult.substring( expectedResult.lastIndexOf('_') + 1,
                expectedResult.length() );
        
        // Test should pass, no error message to compare
        if( "ok".equals( expectedResult ) )
            return null;
        
        // Test should NOT pass, extract error message to compare
        BufferedReader br = new BufferedReader( new FileReader(test) );
        String firstLine = br.readLine();
        br.close();
        return firstLine.substring( firstLine.indexOf(":") + 1 ).trim();
	}

	private static boolean executeTest( File test ){
	    String expectedResult = null;
		try {
		    expectedResult = getTestExpectedResult( test );
		    //System.out.println( expectedResult );
			Module m = Ristr.parseFile( test.getPath() );
			TypeChecker tc = new TypeChecker();
			List<Module> modules = new ArrayList<Module>();
			modules.add( m );
			tc.check( modules );
		}catch( StaticAnalysisException e ){
		    //System.out.println(e.getMessage());
		    if( expectedResult == null )
		        return false;
		    else 
		        return e.getMessage().startsWith( expectedResult );
		}catch( IOException e ){
		    System.err.println( e );
			return false;
		}
        return expectedResult == null;
	}
}
