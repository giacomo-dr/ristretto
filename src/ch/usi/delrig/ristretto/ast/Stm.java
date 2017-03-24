package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Stm extends NodeBase {
	
	public Stm( ParserRuleContext ctx ){ super(ctx); }
	
	public abstract <T> T accept( RistrettoASTVisitor<T> v );
}