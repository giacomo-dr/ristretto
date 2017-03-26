package ch.usi.delrig.ristretto.ast;

public class StmReturn extends Stm {
	public final Expr retvalue;
	
	public StmReturn( FilePosition pos, Expr retvalue ) {
		super( pos );
		this.retvalue = retvalue;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmReturn(this);
	}
}
