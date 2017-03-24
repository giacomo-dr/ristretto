package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExprBinary extends Expr{
	public enum Op{ MOD, DIV, MULT, MINUS, PLUS,
		            GE, GT, LE, LT, NEQ, EQ,
		            AND, OR }
	
	public final Expr el, er;
	public final Op op;
	
	public ExprBinary( ParserRuleContext ctx, Expr el, Expr er, Op o ){
		super( ctx );
		this.el = el;
		this.er = er;
		this.op = o;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitExprBinary(this);
	}
}
