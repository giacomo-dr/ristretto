package ch.usi.delrig.ristretto.ast;

import java.util.List;

public class StmBlock extends Stm {
	
	public final List<Stm> stmlist;
	
	public StmBlock( FilePosition pos, List<Stm> stmlist ) {
		super( pos );
		this.stmlist = stmlist;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmBlock(this);
	}
}
