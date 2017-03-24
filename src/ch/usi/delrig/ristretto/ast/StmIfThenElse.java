package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmIfThenElse extends Stm {
	
	public final Expr guard;
	public final Stm thens;
	public final Stm elses;
	
	public StmIfThenElse( ParserRuleContext ctx, Expr guard, Stm thens, Stm elses ) {
		super( ctx );
		this.guard = guard;
		this.thens = thens;
		this.elses = elses;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmIfThenElse(this);
	}
}
