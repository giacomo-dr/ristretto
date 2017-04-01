package ch.usi.delrig.ristretto.irtree;

public class IRExpLoad extends IRExp{
    
    public final int offset;
    public final IRExp address;

    public IRExpLoad( int offset, IRExp address ){
        this.offset = offset;
        this.address = address;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpLoad( this );
    }
}