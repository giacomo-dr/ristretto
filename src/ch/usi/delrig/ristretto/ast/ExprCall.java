package ch.usi.delrig.ristretto.ast;

public class ExprCall extends Expr{
	
	public final ExprIde ide;
	public final ExprList args;

	public ExprCall( FilePosition pos, ExprIde ide, ExprList args ){
		super( pos );
		this.ide = ide;
		this.args = args;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprCall(this);
	}
}
