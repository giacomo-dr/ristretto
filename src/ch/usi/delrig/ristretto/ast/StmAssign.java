package ch.usi.delrig.ristretto.ast;

public class StmAssign extends Stm {
	public final Expr lvalue;
	public final Expr rvalue;
	
	public StmAssign( FilePosition pos, Expr lvalue, Expr rvalue ) {
		super(pos);
		this.lvalue = lvalue;
		this.rvalue = rvalue;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmAssign(this);
	}
}
