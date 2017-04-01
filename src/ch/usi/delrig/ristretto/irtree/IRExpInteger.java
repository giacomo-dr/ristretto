package ch.usi.delrig.ristretto.irtree;

public class IRExpInteger extends IRExp{
    
    public final long value;

    public IRExpInteger( long value ){
        this.value = value;
    }
    
    @Override public String toString(){
        return "" + value;
    }
    
    @Override public boolean equals( Object o ){
        if( o == null ) return false;
        if( !(o instanceof IRExpInteger) ) return false;
        IRExpInteger other = (IRExpInteger)o;
        return value == other.value;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpInteger( this );
    }
}
