package ch.usi.delrig.ristretto.ast;

public class StmCall extends Stm{
	public final ExprCall e;

	public StmCall( FilePosition pos, ExprCall e ) {
		super( pos );
		this.e = e;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmCall(this);
	}
}
