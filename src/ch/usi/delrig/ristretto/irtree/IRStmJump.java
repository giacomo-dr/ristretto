package ch.usi.delrig.ristretto.irtree;

public class IRStmJump extends IRStm{
    
    public final String label;
    
    public IRStmJump( String label ){
        this.label = label;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmJump( this );
    }
}
