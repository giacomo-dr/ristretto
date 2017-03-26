package ch.usi.delrig.ristretto.typechecker;

import java.util.List;

public class TypeFunction extends Type {
	
	public static class Param{
		public final String name;
		public final Type type;
		
		public Param( String name, Type type ){
			this.name = name; this.type = type;
		}
		
		@Override public String toString(){
			return type + " " + name;
		}
		
		@Override 
		public boolean equals( Object other ){
			if( other == null ) return false;
		    if( !(other instanceof Param) ) return false;
		    Param otherParam = (Param)other;
		    return name.equals(otherParam.name) && type.equals(otherParam.type);
		}
	}
	
	public final Type returnType;
	public final boolean isextern;
	public final List<Param> parameters;
	
	public TypeFunction( Type returnType, boolean isextern, List<Param> parameters ){
		this.returnType = returnType;
		this.isextern = isextern;
		this.parameters = parameters;
	}

	@Override
	public String toString(){
		String res = isextern ? "extern " : "";
		return res + returnType.toString() + toStringParams();
	}
	
	public String toStringParams(){
		String res = "(";
		for( int i = 0 ; i < parameters.size() ; i++ )
			res += parameters.get(i).type + (i == parameters.size() - 1 ? "" : ", ");
		return res + ")";
	}
	
	@Override 
	public boolean equals( Object other ){
		if( other == null ) 
			return false;
	    if( !(other instanceof TypeFunction) )
	    	return false;
	    TypeFunction otherTypeFunction = (TypeFunction)other;
	    if( parameters.size() != otherTypeFunction.parameters.size() )
	    	return false;
    	for( int i = 0 ; i < parameters.size() ; i++ )
    		if( !parameters.get(i).equals(otherTypeFunction.parameters.get(i)) )
    			return false;
		return returnType.equals(otherTypeFunction.returnType);
	}
}
