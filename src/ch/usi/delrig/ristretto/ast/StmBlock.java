package ch.usi.delrig.ristretto.ast;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmBlock extends Stm {
	
	public final List<Stm> stmlist;
	
	public StmBlock( ParserRuleContext ctx, List<Stm> stmlist ) {
		super( ctx );
		this.stmlist = stmlist;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmBlock(this);
	}
}
