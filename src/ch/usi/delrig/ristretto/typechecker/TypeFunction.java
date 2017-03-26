package ch.usi.delrig.ristretto.typechecker;

import java.util.List;

public class TypeFunction extends Type {
		
	public final Type returnType;
	public final boolean isextern;
	public final List<Type> parameters;
	
	public TypeFunction( Type returnType, boolean isextern, List<Type> parameters ){
		this.returnType = returnType;
		this.isextern = isextern;
		this.parameters = parameters;
	}

	@Override
	public String toString(){
		return returnType.toString() + toStringParams();
	}
	
	public String toStringParams(){
		String res = "(";
		for( int i = 0 ; i < parameters.size() ; i++ )
			res += parameters.get(i) + (i == parameters.size() - 1 ? "" : ", ");
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
