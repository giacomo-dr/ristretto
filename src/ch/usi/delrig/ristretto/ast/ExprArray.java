package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprArray extends Expr{	
	public final Expr earr;
	public final Expr eidx;

	public ExprArray( ParserRuleContext ctx, Expr earr, Expr eidx ){
		super( ctx );
		this.earr = earr;
		this.eidx = eidx;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprArray(this);
	}
}
