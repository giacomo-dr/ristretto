package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmAssign extends Stm {
	public final Expr lvalue;
	public final Expr rvalue;
	
	public StmAssign( ParserRuleContext ctx, Expr lvalue, Expr rvalue ) {
		super(ctx);
		this.lvalue = lvalue;
		this.rvalue = rvalue;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmAssign(this);
	}
}
