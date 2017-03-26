package ch.usi.delrig.ristretto.ast;

public class ExprUnary extends Expr{
	public enum Op{ NOT, MINUS }
	
	public final Expr e;
	public final Op op;

	public ExprUnary( FilePosition pos, Expr e, Op o ){
		super( pos );
		this.e = e;
		this.op = o;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprUnary(this);
	}
}
