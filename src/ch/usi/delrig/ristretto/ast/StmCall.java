package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmCall extends Stm{
	public final ExprCall e;

	public StmCall( ParserRuleContext ctx, ExprCall e ) {
		super( ctx );
		this.e = e;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmCall(this);
	}
}
