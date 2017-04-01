package ch.usi.delrig.ristretto.irtree;

public class IRStmCjump extends IRStm{
    
    public final IRExp condition;
    public final String label;
    
    public IRStmCjump( IRExp condition, String label ){
        this.condition = condition;
        this.label = label;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmCjump( this );
    }
}
