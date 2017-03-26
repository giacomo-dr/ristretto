package ch.usi.delrig.ristretto.ast;

public class ExprArray extends Expr{	
	public final Expr earr;
	public final Expr eidx;

	public ExprArray( FilePosition pos, Expr earr, Expr eidx ){
		super( pos );
		this.earr = earr;
		this.eidx = eidx;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprArray(this);
	}
}
