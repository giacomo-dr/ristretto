package ch.usi.delrig.ristretto.irtree;

public class IRStmNop extends IRStm{
    
    @Override public boolean equals( Object o ){
        if( o == null ) return false;
        return o instanceof IRStmNop;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRStmNop( this );
    }
}
