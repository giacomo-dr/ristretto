package ch.usi.delrig.ristretto.irtree;


public class IRExpOperation extends IRExp{
    public enum Op{ LT, GT, LE, GE, EQ, NE, 
        ADD, SUB, MUL, DIV, MOD }
    
    public final IRExp le, re;
    public final Op op;

    public IRExpOperation( IRExp le, IRExp re, Op op ){
        this.le = le;
        this.re = re;
        this.op = op;
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpOperation( this );
    }
}
