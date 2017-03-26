package ch.usi.delrig.ristretto.ast;

public class Parameter extends NodeBase{

	public final AstType t;
	public final ExprIde ide;
	
	public Parameter( FilePosition pos, AstType t, ExprIde ide ){
		super( pos );
		this.t = t;
		this.ide = ide;
	}
	
	public <T> T accept( RistrettoASTVisitor<T> v ){
		return v.visitParam(this);
	}
}
