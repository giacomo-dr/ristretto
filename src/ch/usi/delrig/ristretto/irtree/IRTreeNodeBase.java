package ch.usi.delrig.ristretto.irtree;

/**
 * Base superclass for all IR Tree intermediate representation nodes.
 */
public abstract class IRTreeNodeBase{
    public abstract <T> T accept( RistrettoIRVisitor<T> v );
}
