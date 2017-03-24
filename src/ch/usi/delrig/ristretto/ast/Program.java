package ch.usi.delrig.ristretto.ast;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

public class Program extends NodeBase {

	public final List<Definition> dl;
	
	public Program( ParserRuleContext ctx, List<Definition> dl ){
		super( ctx );
		this.dl = dl;
	}
	
	<T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitProgram( this );
	}
}
