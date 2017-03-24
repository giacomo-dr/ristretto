package ch.usi.delrig.ristretto;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;

import ch.usi.delrig.ristretto.antlrparser.RistrettoLexer;

public class BailRistrettoLexer extends RistrettoLexer {
	public BailRistrettoLexer( CharStream input ){ 
		super(input); 
	}
	
	public void recover( LexerNoViableAltException e ){
		System.err.println( e );
		System.exit( 1 );
	}
}
