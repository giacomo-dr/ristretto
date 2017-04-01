package ch.usi.delrig.ristretto.irtree;

public class IRStmError extends IRStm{
    
    @Override public boolean equals( Object o ){
        if( o == null ) return false;
        return o instanceof IRStmError;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmError( this );
    }
}
