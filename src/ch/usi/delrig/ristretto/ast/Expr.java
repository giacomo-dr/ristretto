package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Expr extends NodeBase {
	
	public Expr( ParserRuleContext ctx ){ super(ctx); }
	
	public abstract <T> T accept( RistrettoASTVisitor<T> v );
}

