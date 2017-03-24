package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class NodeBase {
	public final int startLine;
	public final int startCol;
	public final int endLine;
	public final int endCol;
	
	public NodeBase( ParserRuleContext ctx ){
		startLine = ctx.getStart().getLine();
		startCol = ctx.getStart().getCharPositionInLine();
		endLine = ctx.getStop().getLine();
		endCol = ctx.getStop().getCharPositionInLine();
	}
}
