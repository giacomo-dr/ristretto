package ch.usi.delrig.ristretto.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FilePosition {
	public final int startLine;
	public final int startCol;
	public final int endLine;
	public final int endCol;
	public final String filename;
	
	public FilePosition( int startLine, int startCol, int endLine, int endCol, String filename ){
		this.startLine = startLine;
		this.startCol = startCol;
		this.endLine = endLine;
		this.endCol = endCol;
		this.filename = filename;
	}
	
	public FilePosition( TerminalNode tn, String filename ){
		startLine = tn.getSymbol().getLine();
		startCol = tn.getSymbol().getCharPositionInLine();
		endLine = startLine;
		endCol = startCol + tn.getText().length();
		this.filename = filename;
	}
	
	public FilePosition( ParserRuleContext ctx, String filename ){
		startLine = ctx.getStart().getLine();
		startCol = ctx.getStart().getCharPositionInLine();
		endLine = ctx.getStop().getLine();
		endCol = ctx.getStop().getCharPositionInLine();
		this.filename = filename;
	}
	
	@Override public String toString(){
		return "'" + filename + "' Line " + startLine + " Col " + (startCol + 1);
	}
}
