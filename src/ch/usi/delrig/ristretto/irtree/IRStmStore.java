package ch.usi.delrig.ristretto.irtree;

public class IRStmStore extends IRStm{
    
    public final int offset;
    public final IRExp address;
    public final IRExp value;
    
    public IRStmStore( int offset, IRExp address, IRExp value ){
        this.offset = offset;
        this.address = address;
        this.value = value;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmStore( this );
    }
}
