package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprLiteral extends Expr{
	public enum LitType{ INT, BOOLEAN, STRING }
	
	public final Object val;
	public final LitType t;

	public ExprLiteral( ParserRuleContext ctx, Object val, LitType t ){
		super( ctx );
		this.val = val;
		this.t = t;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprLiteral(this);
	}
}
