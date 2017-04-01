package ch.usi.delrig.ristretto.irtree;

import java.util.List;

public class IRProcedure extends IRTreeNodeBase{
    
    public final String label;
    public final List<String> argNames;
    public final IRExp body;
    
    public IRProcedure( String label, List<String> argNames, IRExp body ){
       this.label = label;
       this.argNames = argNames;
       this.body = body;
    }

    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRProcedure( this );
    }
}
