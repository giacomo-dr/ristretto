package ch.usi.delrig.ristretto.irtree;

public class IRExpInteger extends IRExp{
    
    public final long value;

    public IRExpInteger( long value ){
        this.value = value;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitExpInteger( this );
    }
}
