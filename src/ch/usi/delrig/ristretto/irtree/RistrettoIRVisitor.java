package ch.usi.delrig.ristretto.irtree;

public abstract class RistrettoIRVisitor<T>{
    public abstract T visitExpInteger( IRExpInteger e );
    public abstract T visitExpOperation( IRExpOperation e );
}
