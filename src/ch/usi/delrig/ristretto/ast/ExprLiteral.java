package ch.usi.delrig.ristretto.ast;

public class ExprLiteral extends Expr{
	public enum LitType{ INT, BOOLEAN, STRING }
	
	public final Object val;
	public final LitType t;

	public ExprLiteral( FilePosition pos, Object val, LitType t ){
		super( pos );
		this.val = val;
		this.t = t;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprLiteral(this);
	}
}
