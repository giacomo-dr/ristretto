package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprLength extends Expr{

	public final Expr e;

	public ExprLength( ParserRuleContext ctx, Expr e ){
		super( ctx );
		this.e = e;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprLength(this);
	}
}
