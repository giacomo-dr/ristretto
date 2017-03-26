package ch.usi.delrig.ristretto.test;

import java.io.File;
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
				System.out.println( "failed." );
			}else{
				System.out.println( "passed." );
			}
		}
		System.out.println( "Passed " + (testFiles.length - failed) + 
				" out of " + testFiles.length + " tests." );
	}

	private static boolean executeTest( File test ){
		String expectedResult = test.getName().split("\\.")[0];
		expectedResult = expectedResult.substring( expectedResult.lastIndexOf('_') + 1,
				expectedResult.length() );
		
		try {
			Module m = Ristr.parseFile( test.getPath() );
			TypeChecker tc = new TypeChecker();
			List<Module> modules = new ArrayList<Module>();
			modules.add( m );
			tc.check( modules );
		}catch( StaticAnalysisException e ){
			return "ko".equals( expectedResult );
		}catch( IOException e ){
			return false;
		}
		return "ok".equals( expectedResult );
	}
}
