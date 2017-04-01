package ch.usi.delrig.ristretto.irtree;

public class IRStmMove extends IRStm{
    
    public final String temp;
    public final IRExp value;
    
    public IRStmMove( String temp, IRExp value ){
        this.temp = temp;
        this.value = value;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmMove( this );
    }
}
