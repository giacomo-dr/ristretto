package ch.usi.delrig.ristretto.typechecker;

public class TypeVoid extends Type {

	private static final TypeVoid instance = new TypeVoid();
	private TypeVoid(){}
	public static TypeVoid getInstance(){ return instance; }
	
	@Override public String toString(){ return "void"; }
	@Override public boolean equals( Object other ){ return this == other; }
}
