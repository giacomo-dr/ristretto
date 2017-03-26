package ch.usi.delrig.ristretto.typechecker;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ch.usi.delrig.ristretto.ast.FilePosition;

public class SymbolTable {
	
	public static class Entry{
		public Type type;
		FilePosition position;
		String moduleName;
		
		public Entry( Type t, FilePosition position, String moduleName ){
			this.type = t; this.position = position; this.moduleName = moduleName;
		}
	}

	private final Stack< Map<String, Entry> > table;
	
	public SymbolTable(){
		table = new Stack<Map<String, Entry>>();
	}
	
	public void pushFrame(){
		table.push( new HashMap<String,Entry>() );
	}
	
	public void popFrame(){
		table.pop();
	}
	
	public void addSymbol( String name, Type t, FilePosition position, String moduleName ){
		if( name == null )
			throw new IllegalArgumentException( "SymbolTable.putSymbol(): name can't be null" );
		else if( lookup( name ) != null )
			throw new IllegalArgumentException( "Symbol redefinition!" );
		
		table.peek().put( name, new Entry(t, position, moduleName) );
	}
	
	public Entry lookup( String name ){
		for( int i = table.size() - 1 ; i >= 0 ; i-- ){
			Entry res = table.get(i).get( name );
			if( res != null )
				return res;
		}
		return null;
	}
	
	public boolean hasNoFrames(){
		return table.isEmpty();
	}
	
	public void dump( PrintStream ps ){
		ps.println( "--------------------------------------------------------------------" );
		
		for( int i = table.size() - 1 ; i >= 0 ; i-- ){
			for( Map.Entry<String, Entry> assoc: table.get(i).entrySet() ){
				ps.println( assoc.getKey() + ": " + assoc.getValue().type );
			}
			ps.println( "--------------------------------------------------------------------" );
		}
	}
}
