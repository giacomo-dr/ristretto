package ch.usi.delrig.ristretto.ast;

public class AstTypeBoolean extends AstType {
	public AstTypeBoolean( FilePosition pos ){
		super( pos );
	}
	
	@Override public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitAstTypeBoolean(this);
	}
}
