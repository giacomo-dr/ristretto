package ch.usi.delrig.ristretto.ast;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

public class Definition extends NodeBase{
	
	public final Type retType;
	public final ExprIde name;
	public final List<Param> params;
	public final StmBlock b;
	
	public Definition( ParserRuleContext ctx, Type retType, ExprIde name, List<Param> params, StmBlock b ){
		super( ctx );
		this.retType = retType;
		this.name = name;
		this.params = params;
		this.b = b;
	}
	
	public <T> T accept( RistrettoASTVisitor<T> v ){
		return v.visitDefinition(this);
	}
}
