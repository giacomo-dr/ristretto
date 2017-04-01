package ch.usi.delrig.ristretto.irtree;

import java.util.List;

public class IRExpCall extends IRExp{
    
    public final IRExp fun;
    public final List<IRExp> args;

    public IRExpCall( IRExp fun, List<IRExp> args ){
        this.fun = fun;
        this.args = args;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpCall( this );
    }
}