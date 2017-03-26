package ch.usi.delrig.ristretto.typechecker;

import ch.usi.delrig.ristretto.ast.FilePosition;

public class StaticAnalysisException extends RuntimeException {

	private static final long serialVersionUID = -7355898017748800918L;
	public final FilePosition pos;

	public StaticAnalysisException( String message, FilePosition pos ){
		super( message );
		this.pos = pos;
	}
	
	@Override public String toString(){
		String msg = "Module " + pos + ":\n > " + getMessage();
		return msg;
	}
}
