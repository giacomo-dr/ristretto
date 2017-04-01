package ch.usi.delrig.ristretto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ch.usi.delrig.ristretto.irtree.IRExpInteger;
import ch.usi.delrig.ristretto.irtree.IRExpOperation;
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

    @Override public String visitExpInteger( IRExpInteger e ){
        return writeNode( "" + e.value );
    }

    @Override
    public String visitExpOperation( IRExpOperation e ){
        String nn = writeNode( "" + e.op );
        writeEdge( nn, e.le.accept(this) );
        writeEdge( nn, e.re.accept(this) );
        return nn;
    }
}
