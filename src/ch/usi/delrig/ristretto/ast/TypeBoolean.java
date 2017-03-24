package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class TypeBoolean extends Type {
	public TypeBoolean( ParserRuleContext ctx ){
		super( ctx );
	}
	
	@Override public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitTypeBoolean(this);
	}
}
