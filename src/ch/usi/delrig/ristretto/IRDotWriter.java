package ch.usi.delrig.ristretto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ch.usi.delrig.ristretto.irtree.IRExp;
import ch.usi.delrig.ristretto.irtree.IRExpAlloc;
import ch.usi.delrig.ristretto.irtree.IRExpBegin;
import ch.usi.delrig.ristretto.irtree.IRExpCall;
import ch.usi.delrig.ristretto.irtree.IRExpInteger;
import ch.usi.delrig.ristretto.irtree.IRExpLabel;
import ch.usi.delrig.ristretto.irtree.IRExpLoad;
import ch.usi.delrig.ristretto.irtree.IRExpOperation;
import ch.usi.delrig.ristretto.irtree.IRExpTemp;
import ch.usi.delrig.ristretto.irtree.IRProcedure;
import ch.usi.delrig.ristretto.irtree.IRStm;
import ch.usi.delrig.ristretto.irtree.IRStmCjump;
import ch.usi.delrig.ristretto.irtree.IRStmError;
import ch.usi.delrig.ristretto.irtree.IRStmJump;
import ch.usi.delrig.ristretto.irtree.IRStmLabel;
import ch.usi.delrig.ristretto.irtree.IRStmMove;
import ch.usi.delrig.ristretto.irtree.IRStmNop;
import ch.usi.delrig.ristretto.irtree.IRStmStore;
import ch.usi.delrig.ristretto.irtree.IRTreeNodeBase;
import ch.usi.delrig.ristretto.irtree.RistrettoIRVisitor;

public class IRDotWriter extends RistrettoIRVisitor<String> {
	
	private BufferedWriter out;
	private int nextName = 0;
	
	public IRDotWriter( String filename ) throws IOException{
		FileWriter fstream = new FileWriter( filename, false );
		out = new BufferedWriter(fstream);
	}
	
	public void generate( IRTreeNodeBase p ) throws IOException{
		printPrologue();
		p.accept( this );
		printEpilogue();
		out.close();
	}

	private void printPrologue(){
		safeWrite( "digraph ristrettoIR {\n" );
	}
	
	private void printEpilogue(){
		safeWrite( "}\n" );
	}
	
	private String getNextName(){
		return "n" + nextName++;
	}
	
	private void safeWrite( String s ){
		try {
			out.write( s );
		} catch (IOException e) {
			e.printStackTrace();
			System.exit( 1 );
		}
	}
	
	private String writeNode( String label, String format ){
	    String nn = getNextName();
		safeWrite( "\t" + nn + " [label=\"" + label + "\" " + format + "]\n" );
		return nn;
	}
	
	private String writeNode( String label ){
		return writeNode( label, "" );
	}
	
	private void writeEdge( String n1, String n2 ){
		safeWrite( "\t" + n1 + " -> " + n2 + "\n" );
	}

    @Override public String visitIRExpInteger( IRExpInteger e ){
        return writeNode( "" + e.value );
    }

    @Override
    public String visitIRExpOperation( IRExpOperation e ){
        String nn = writeNode( "" + e.op );
        writeEdge( nn, e.le.accept(this) );
        writeEdge( nn, e.re.accept(this) );
        return nn;
    }

    @Override public String visitIRExpLabel( IRExpLabel e ){
        return writeNode( e.toString() );
    }
    
    @Override public String visitIRExpTemp( IRExpTemp e ){
        return writeNode( e.toString() );
    }

    @Override public String visitIRExpLoad( IRExpLoad e ){
        String nn = writeNode( "load " + e.offset );
        writeEdge( nn, e.address.accept(this) );
        return nn;
    }
    
    @Override public String visitIRExpAlloc( IRExpAlloc e ){
        String nn = writeNode( "alloc" );
        writeEdge( nn, e.size.accept(this) );
        return nn;
    }
    
    @Override public String visitIRExpCall( IRExpCall e ){
        String nn = writeNode( "call" );
        writeEdge( nn, e.fun.accept(this) );
        for( IRExp arg: e.args )
            writeEdge( nn, arg.accept(this) );
        return nn;
    }
    
    @Override public String visitIRExpBegin( IRExpBegin e ){
        String nn = writeNode( "begin" );
        for( IRStm arg: e.statements )
            writeEdge( nn, arg.accept(this) );
        writeEdge( nn, e.result.accept(this) );
        return nn;
    }
    
    @Override public String visitIRStmNop( IRStmNop s ){
        return writeNode( "nop" );
    }
    
    @Override public String visitIRStmError( IRStmError s ){
        return writeNode( "error" );
    }
    
    @Override public String visitIRStmCjump( IRStmCjump s ){
        String nn = writeNode( "cjump -> " + s.label );
        writeEdge( nn, s.condition.accept(this) );
        return nn;
    }
    
    @Override public String visitIRStmJump( IRStmJump s ){
        return writeNode( "jump -> " + s.label );
    }
    
    @Override public String visitIRStmStore( IRStmStore s ){
        String nn = writeNode( "store " + s.offset );
        writeEdge( nn, s.address.accept(this) );
        writeEdge( nn, s.value.accept(this) );
        return nn;
    }
    
    @Override public String visitIRStmMove( IRStmMove s ){
        String nn = writeNode( "move " + s.temp + " = " );
        writeEdge( nn, s.value.accept(this) );
        return nn;
    }
    
    @Override public String visitIRStmLabel( IRStmLabel s ){
        return writeNode( "label: " + s.label );
    }
    
    @Override public String visitIRProcedure( IRProcedure s ){
        String name = s.label + "( " + String.join( ", ", s.argNames ) + " )";
        String nn = writeNode( name );
        writeEdge( nn, s.body.accept(this) );
        return nn;
    }
}
