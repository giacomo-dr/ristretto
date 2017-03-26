package ch.usi.delrig.ristretto.ast;

public class StmIfThenElse extends Stm {
	
	public final Expr guard;
	public final Stm thens;
	public final Stm elses;
	
	public StmIfThenElse( FilePosition pos, Expr guard, Stm thens, Stm elses ) {
		super( pos );
		this.guard = guard;
		this.thens = thens;
		this.elses = elses;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmIfThenElse(this);
	}
}
