package ch.usi.delrig.ristretto.ast;

import java.util.List;

public class ExprList extends Expr{
	
	public final List<Expr> el;

	public ExprList( FilePosition pos, List<Expr> el ){
		super( pos );
		this.el = el;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprList(this);
	}
}
