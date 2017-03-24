package ch.usi.delrig.ristretto;

public class ParsingException extends RuntimeException {
	
	private static final long serialVersionUID = 643794966689941734L;

	public ParsingException( Exception reason ){
		super( reason );
	}

}
