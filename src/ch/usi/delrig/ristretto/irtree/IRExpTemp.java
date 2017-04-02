package ch.usi.delrig.ristretto.irtree;

public class IRExpTemp extends IRExp{
    
    public final String temp;

    public IRExpTemp( String temp ){
        this.temp = temp;
    }
    
    @Override public String toString(){
        return temp;
    }
    
    @Override public boolean equals( Object o ){
        if( o == null ) return false;
        if( !(o instanceof IRExpTemp) ) return false;
        IRExpTemp other = (IRExpTemp)o;
        return temp.equals( other.temp );
    }
    
    @Override public <T> T accept( RistrettoIRVisitor<T> e ){
        return e.visitIRExpTemp( this );
    }
}