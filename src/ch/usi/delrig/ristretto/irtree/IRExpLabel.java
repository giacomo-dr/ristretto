package ch.usi.delrig.ristretto.irtree;

public class IRExpLabel extends IRExp{
    
    public final String label;

    public IRExpLabel( String label ){
        this.label = label;
    }
    
    @Override public String toString(){
        return "$" + label;
    }
    
    @Override public boolean equals( Object o ){
        if( o == null ) return false;
        if( !(o instanceof IRExpLabel) ) return false;
        IRExpLabel other = (IRExpLabel)o;
        return label.equals( other.label );
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpLabel( this );
    }
}
