package ch.usi.delrig.ristretto.ast;


public class NodeBase {
	public final FilePosition position;
	
	public NodeBase( FilePosition pos ){
		this.position = pos;
	}
}
