package ch.usi.delrig.ristretto.ast;

import java.util.List;

public class Module extends NodeBase {

	public String name;
	public final List<Definition> dl;
	
	public Module( FilePosition pos, String name, List<Definition> dl ){
		super( pos );
		this.name = name;
		this.dl = dl;
	}
	
	public <T> T accept( RistrettoASTVisitor<T> v ) {
		return v.visitModule( this );
	}
}
