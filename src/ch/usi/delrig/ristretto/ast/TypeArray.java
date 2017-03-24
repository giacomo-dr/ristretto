package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class TypeArray extends Type {

	public final Type t;
	public final int dimensions;
	
	public TypeArray( ParserRuleContext ctx, Type t, int dimensions ) {
		super( ctx );
		this.t = t;
		this.dimensions = dimensions;
	}

	@Override public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitTypeArray(this);
	}
}
