package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprIde extends Expr{
	
	public final String name;

	public ExprIde( ParserRuleContext ctx, String name ){
		super( ctx );
		this.name = name;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprIde(this);
	}
}
