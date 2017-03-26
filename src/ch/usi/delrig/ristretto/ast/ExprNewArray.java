package ch.usi.delrig.ristretto.ast;

import java.util.List;

public class ExprNewArray extends Expr{	
	public final AstType type;
	public final List<Expr> dims;

	public ExprNewArray( FilePosition pos, AstType type, List<Expr> dims ){
		super( pos );
		this.type = type;
		this.dims = dims;
	}

	@Override
	public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitExprNewArray( this );
	}
}
