package ch.usi.delrig.ristretto.ast;

public abstract class AstType extends NodeBase {

	public AstType( FilePosition pos ){
		super( pos );
	}
	
	public abstract <T> T accept( RistrettoASTVisitor<T> v );
}
