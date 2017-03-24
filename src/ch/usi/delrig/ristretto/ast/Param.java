package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class Param extends NodeBase{

	public final Type t;
	public final ExprIde ide;
	
	public Param( ParserRuleContext ctx, Type t, ExprIde ide ){
		super( ctx );
		this.t = t;
		this.ide = ide;
	}
	
	public <T> T accept( RistrettoASTVisitor<T> v ){
		return v.visitParam(this);
	}
}
