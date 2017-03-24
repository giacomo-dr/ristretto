package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmWhile extends Stm {
	public final Expr guard;
	public final Stm body;
	
	public StmWhile( ParserRuleContext ctx, Expr guard, Stm body ) {
		super( ctx );
		this.guard = guard;
		this.body = body;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmWhile(this);
	}
}
