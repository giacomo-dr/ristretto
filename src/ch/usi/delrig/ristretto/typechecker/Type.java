package ch.usi.delrig.ristretto.typechecker;

/**
 * Abstract Type class for type checking in Ristretto
 * 
 * @author Giacomo Del Rio
 */
public abstract class Type {
	
	public static boolean isVoid( Type t ){ return t instanceof TypeVoid; }
	public static boolean isInt( Type t ){ return t instanceof TypeInt; }
	public static boolean isBoolean( Type t ){ return t instanceof TypeBoolean; }
	public static boolean isFunction( Type t ){ return t instanceof TypeFunction; }
	public static boolean isArray( Type t ){ return t instanceof TypeArray; }
}
