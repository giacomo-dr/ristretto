package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprCall extends Expr{
	
	public final ExprIde ide;
	public final ExprList args;

	public ExprCall( ParserRuleContext ctx, ExprIde ide, ExprList args ){
		super( ctx );
		this.ide = ide;
		this.args = args;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprCall(this);
	}
}
