package ch.usi.delrig.ristretto.irtree;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	
	public static class Entry{
		public String label;
		public String temp;
		
		public Entry( String label, String temp ){
			this.label = label; this.temp = temp;
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
	
	public void bindToLabel( String name, String label ){
	    if( name == null )
            throw new IllegalArgumentException( "Name can't be null." );
        else if( label == null )
            throw new IllegalArgumentException( "Label can't be null." );
        else if( lookup( name ) != null )
            throw new IllegalArgumentException( "Symbol redefinition!" );
        
        table.peek().put( name, new Entry(label, null) );
	}
	
	public void bindToTemp( String name, String temp ){
        if( name == null )
            throw new IllegalArgumentException( "Name can't be null." );
        else if( temp == null )
            throw new IllegalArgumentException( "Temp can't be null." );
        else if( lookup( name ) != null )
            throw new IllegalArgumentException( "Symbol redefinition!" );
        
        table.peek().put( name, new Entry(null, temp) );
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
			for( Map.Entry<String, Entry> assoc: table.get(i).entrySet() )
				ps.println( assoc.getKey() + ": " + (assoc.getValue().label == null ? 
				        assoc.getValue().temp : assoc.getValue().label) );
			ps.println( "--------------------------------------------------------------------" );
		}
	}
}
