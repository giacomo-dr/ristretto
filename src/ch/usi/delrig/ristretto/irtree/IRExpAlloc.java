package ch.usi.delrig.ristretto.irtree;

public class IRExpAlloc extends IRExp{
    
    public final IRExp size;

    public IRExpAlloc( IRExp size ){
        this.size = size;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpAlloc( this );
    }
}