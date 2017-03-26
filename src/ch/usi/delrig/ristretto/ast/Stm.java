package ch.usi.delrig.ristretto.ast;

public abstract class Stm extends NodeBase {
	
	public Stm( FilePosition pos ){ super(pos); }
	
	public abstract <T> T accept( RistrettoASTVisitor<T> v );
}