package ch.usi.delrig.ristretto.ast;

public class AstTypeInteger extends AstType {
	public AstTypeInteger( FilePosition pos ) {
		super( pos );
	}
	
	@Override public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitAstTypeInteger(this);
	}
}
