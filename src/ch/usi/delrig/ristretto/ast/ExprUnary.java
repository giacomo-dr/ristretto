package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprUnary extends Expr{
	public enum Op{ NOT, MINUS }
	
	public final Expr e;
	public final Op op;

	public ExprUnary( ParserRuleContext ctx, Expr e, Op o ){
		super( ctx );
		this.e = e;
		this.op = o;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprUnary(this);
	}
}
