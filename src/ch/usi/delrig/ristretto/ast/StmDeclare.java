package ch.usi.delrig.ristretto.ast;

public class StmDeclare extends Stm{
	public final AstType t;
	public final ExprIde ide;
	public final Expr e;
	
	public StmDeclare( FilePosition pos, AstType t, ExprIde ide, Expr e ){
		super( pos );
		this.t = t;
		this.ide = ide;
		this.e = e;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmDeclare(this);
	}
}
