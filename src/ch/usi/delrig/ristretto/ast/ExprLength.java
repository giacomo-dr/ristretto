package ch.usi.delrig.ristretto.ast;

public class ExprLength extends Expr{

	public final Expr e;

	public ExprLength( FilePosition pos, Expr e ){
		super( pos );
		this.e = e;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprLength(this);
	}
}
