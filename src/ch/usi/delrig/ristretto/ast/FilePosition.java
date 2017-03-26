package ch.usi.delrig.ristretto.ast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

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
		endCol = startCol + tn.getText().length() -1;
		this.filename = filename;
	}
	
	public FilePosition( ParserRuleContext ctx, String filename ){
		startLine = ctx.getStart().getLine();
		startCol = ctx.getStart().getCharPositionInLine();
		endLine = ctx.getStop().getLine();
		endCol = ctx.getStop().getCharPositionInLine() + ctx.getStop().getText().length() -1;
		this.filename = filename;
	}
	
	@Override public String toString(){
		return "'" + filename + "' Line " + startLine + " Col " + (startCol + 1);
	}
	
	public String getHilightedFilePortion(){
	    try{
	        BufferedReader br = new BufferedReader( new FileReader(filename) );
	        String fileLine = null;
	        for( int i = 0 ; i < startLine ; i++ )
	            fileLine = br.readLine();
	        br.close();
	        int markerEnd = endLine > startLine ? fileLine.length() : endCol;
	        String space = fileLine.substring( 0, startCol ).replaceAll("[^\\t]", " ");
	        String marker = StringUtils.repeat( "~", markerEnd - startCol + 1 );
	        return fileLine + "\n" + space + marker;
	    }catch( IOException e ){
	        System.err.println( e );
	        System.exit(0);
	        return null;
	    }
	}
}
