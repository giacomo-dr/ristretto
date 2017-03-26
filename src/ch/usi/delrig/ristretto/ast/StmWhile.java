package ch.usi.delrig.ristretto.ast;

public class StmWhile extends Stm {
	public final Expr guard;
	public final Stm body;
	
	public StmWhile( FilePosition pos, Expr guard, Stm body ) {
		super( pos );
		this.guard = guard;
		this.body = body;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmWhile(this);
	}
}
