package ch.usi.delrig.ristretto.typechecker;

public class TypeInt extends Type {

	private static final TypeInt instance = new TypeInt();
	private TypeInt(){}
	public static TypeInt getInstance(){ return instance; }
	
	@Override public String toString(){ return "int"; }
	@Override public boolean equals( Object other ){ return this == other; }
}
