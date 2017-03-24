package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmReturn extends Stm {
	public final Expr retvalue;
	
	public StmReturn( ParserRuleContext ctx, Expr retvalue ) {
		super( ctx );
		this.retvalue = retvalue;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmReturn(this);
	}
}
