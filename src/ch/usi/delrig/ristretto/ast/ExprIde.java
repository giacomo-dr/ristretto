package ch.usi.delrig.ristretto.ast;

public class ExprIde extends Expr{
	
	public final String name;

	public ExprIde( FilePosition pos, String name ){
		super( pos );
		this.name = name;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprIde(this);
	}
}
