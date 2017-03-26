package ch.usi.delrig.ristretto.typechecker;

public class TypeBoolean extends Type {

	private static final TypeBoolean instance = new TypeBoolean();
	private TypeBoolean(){}
	public static TypeBoolean getInstance(){ return instance; }
	
	@Override public String toString(){ return "boolean"; }
	@Override public boolean equals( Object other ){ return this == other; }
}
