package ch.usi.delrig.ristretto.irtree;

public class IRStmLabel extends IRStm{
    
    public final String label;
    
    public IRStmLabel( String label ){
        this.label = label;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmLabel( this );
    }
}
