package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class TypeInteger extends Type {
	public TypeInteger( ParserRuleContext ctx ) {
		super( ctx );
	}
	
	@Override public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitTypeInteger(this);
	}
}
