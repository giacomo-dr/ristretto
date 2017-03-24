package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class StmDeclare extends Stm{
	public final Type t;
	public final ExprIde ide;
	public final Expr e;
	
	public StmDeclare( ParserRuleContext ctx, Type t, ExprIde ide, Expr e ){
		super( ctx );
		this.t = t;
		this.ide = ide;
		this.e = e;
	}

	@Override
	public <T> T accept(RistrettoASTVisitor<T> v) {
		return v.visitStmDeclare(this);
	}
}
