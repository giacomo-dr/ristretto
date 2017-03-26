package ch.usi.delrig.ristretto.typechecker;

import java.util.Collections;

public class TypeArray extends Type {
	public final Type t;
	public final int dimensions;
	
	public TypeArray( Type t, int dimensions ) {
		this.t = t;
		this.dimensions = dimensions;
	}
	
	public Type stripDimension(){
		if( dimensions == 1 )
			return t;
		else 
			return new TypeArray( t, dimensions-1 );
	}
	
	@Override
	public String toString(){
		String dims = String.join("", Collections.nCopies(dimensions, "[]"));
		return t.toString() + dims;
	}
	
	@Override 
	public boolean equals( Object other ){
		if( other == null ) 
			return false;
	    if( !(other instanceof TypeArray) )
	    	return false;
	    TypeArray otherTypeArray = (TypeArray)other;
		return t.equals(otherTypeArray.t) && dimensions == otherTypeArray.dimensions; 
	}
}
