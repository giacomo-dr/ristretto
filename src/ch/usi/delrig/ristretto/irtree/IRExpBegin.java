package ch.usi.delrig.ristretto.irtree;

import java.util.List;

public class IRExpBegin extends IRExp{

    public final List<IRStm> statements;
    public final IRExp result;

    public IRExpBegin( List<IRStm> statements, IRExp result ){
        this.statements = statements;
        this.result = result;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpBegin( this );
    }
}