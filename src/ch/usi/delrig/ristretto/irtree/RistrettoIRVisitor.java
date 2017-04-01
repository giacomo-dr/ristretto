package ch.usi.delrig.ristretto.irtree;

public abstract class RistrettoIRVisitor<T>{
    public abstract T visitIRProcedure( IRProcedure e );
    
    public abstract T visitIRStmNop( IRStmNop e );
    public abstract T visitIRStmError( IRStmError e );
    public abstract T visitIRStmCjump( IRStmCjump e );
    public abstract T visitIRStmJump( IRStmJump e );
    public abstract T visitIRStmStore( IRStmStore e );
    public abstract T visitIRStmMove( IRStmMove e );
    public abstract T visitIRStmLabel( IRStmLabel e );
    
    public abstract T visitIRExpInteger( IRExpInteger e );
    public abstract T visitIRExpOperation( IRExpOperation e );
    public abstract T visitIRExpLabel( IRExpLabel e );
    public abstract T visitIRExpTemp( IRExpTemp e );
    public abstract T visitIRExpLoad( IRExpLoad e );
    public abstract T visitIRExpAlloc( IRExpAlloc e );
    public abstract T visitIRExpCall( IRExpCall e );
    public abstract T visitIRExpBegin( IRExpBegin e );
}

