package ch.usi.delrig.ristretto.ast;

import java.util.List;

public class Definition extends NodeBase{
	
	public final AstType retType;
	public final ExprIde name;
	public final List<Parameter> params;
	public final StmBlock b;
	
	public Definition( FilePosition pos, AstType retType, ExprIde name, List<Parameter> params, StmBlock b ){
		super( pos );
		this.retType = retType;
		this.name = name;
		this.params = params;
		this.b = b;
	}
	
	public <T> T accept( RistrettoASTVisitor<T> v ){
		return v.visitDefinition(this);
	}
}
