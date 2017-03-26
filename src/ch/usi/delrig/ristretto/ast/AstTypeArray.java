package ch.usi.delrig.ristretto.ast;

public class AstTypeArray extends AstType {

	public final AstType t;
	public final int dimensions;
	
	public AstTypeArray( FilePosition pos, AstType t, int dimensions ) {
		super( pos );
		this.t = t;
		this.dimensions = dimensions;
	}

	@Override public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitAstTypeArray(this);
	}
}
