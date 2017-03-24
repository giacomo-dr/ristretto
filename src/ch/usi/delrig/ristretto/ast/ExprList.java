package ch.usi.delrig.ristretto.ast;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprList extends Expr{
	
	public final List<Expr> el;

	public ExprList( ParserRuleContext ctx, List<Expr> el ){
		super( ctx );
		this.el = el;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprList(this);
	}
}
