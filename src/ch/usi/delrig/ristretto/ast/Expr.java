package ch.usi.delrig.ristretto.ast;

public abstract class Expr extends NodeBase {
	
	public Expr( FilePosition pos ){ super(pos); }
	
	public abstract <T> T accept( RistrettoASTVisitor<T> v );
}

