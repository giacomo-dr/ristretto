package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Type extends NodeBase {

	public Type( ParserRuleContext ctx ){
		super( ctx );
	}
	
	public abstract <T> T accept( RistrettoASTVisitor<T> v );
}
