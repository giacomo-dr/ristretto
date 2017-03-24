package ch.usi.delrig.ristretto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.StringEscapeUtils;

import ch.usi.delrig.ristretto.ast.Definition;
import ch.usi.delrig.ristretto.ast.Expr;
import ch.usi.delrig.ristretto.ast.ExprArray;
import ch.usi.delrig.ristretto.ast.ExprBinary;
import ch.usi.delrig.ristretto.ast.ExprCall;
import ch.usi.delrig.ristretto.ast.ExprIde;
import ch.usi.delrig.ristretto.ast.ExprLength;
import ch.usi.delrig.ristretto.ast.ExprList;
import ch.usi.delrig.ristretto.ast.ExprLiteral;
import ch.usi.delrig.ristretto.ast.ExprUnary;
import ch.usi.delrig.ristretto.ast.Param;
import ch.usi.delrig.ristretto.ast.Program;
import ch.usi.delrig.ristretto.ast.RistrettoASTVisitor;
import ch.usi.delrig.ristretto.ast.Stm;
import ch.usi.delrig.ristretto.ast.StmAssign;
import ch.usi.delrig.ristretto.ast.StmBlock;
import ch.usi.delrig.ristretto.ast.StmCall;
import ch.usi.delrig.ristretto.ast.StmDeclare;
import ch.usi.delrig.ristretto.ast.StmIfThenElse;
import ch.usi.delrig.ristretto.ast.StmReturn;
import ch.usi.delrig.ristretto.ast.StmWhile;
import ch.usi.delrig.ristretto.ast.TypeArray;
import ch.usi.delrig.ristretto.ast.TypeBoolean;
import ch.usi.delrig.ristretto.ast.TypeInteger;

public class DotWriter extends RistrettoASTVisitor<String> {
	
	private BufferedWriter out;
	private int nextName = 0;
	
	public DotWriter( String filename ) throws IOException{
		FileWriter fstream = new FileWriter( filename, false );
		out = new BufferedWriter(fstream);
	}
	
	public void generate( Program p ) throws IOException{
		printPrologue();
		visitProgram( p );
		printEpilogue();
		out.close();
	}

	private void printPrologue(){
		safeWrite( "digraph ristretto {\n" );
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
	
	private void writeNode( String name, String label, String format ){
		safeWrite( "\t" + name + " [label=\"" + label + "\" " + format + "]\n" );
	}
	
	private void writeNode( String name, String label){
		writeNode( name, label, "" );
	}
	
	private void writeEdge( String n1, String n2 ){
		safeWrite( "\t" + n1 + " -> " + n2 + "\n" );
	}
	
	@Override
	public String visitProgram( Program p ){
		String nn = getNextName();
		writeNode( nn, "program", "shape=rect" );
		for( Definition d : p.dl ){
			String in = d.accept( this );
			writeEdge( nn, in );
		}
		return nn;
	}
	
	@Override
	public String visitTypeArray( TypeArray t ){
		String nn = getNextName();
		writeNode( nn, "Array(" + t.dimensions + ")", "shape=underline" );
		String tn = t.t.accept( this );
		writeEdge( nn, tn );
		return nn;
	}

	@Override
	public String visitTypeBoolean(TypeBoolean t) {
		String nn = getNextName();
		writeNode( nn, "Boolean", "shape=underline"  );
		return nn;
	}

	@Override
	public String visitTypeInteger(TypeInteger t) {
		String nn = getNextName();
		writeNode( nn, "Integer", "shape=underline"  );
		return nn;
	}

	@Override
	public String visitExprUnary( ExprUnary e ){
		String nn = getNextName();
		switch( e.op ){
		case MINUS: writeNode( nn, "-" ); break;
		case NOT: writeNode( nn, "!" ); break;
		}
		String ar = e.e.accept( this );
		writeEdge( nn, ar );
		return nn;
	}

	@Override
	public String visitExprBinary( ExprBinary e ) {
		String nn = getNextName();
		switch( e.op ){
		case AND: writeNode( nn, "&&" ); break;
		case DIV: writeNode( nn, "/" ); break;
		case EQ: writeNode( nn, "==" ); break;
		case GE: writeNode( nn, ">=" ); break;
		case GT: writeNode( nn, ">" ); break;
		case LE: writeNode( nn, "<=" ); break;
		case LT: writeNode( nn, "<" ); break;
		case MINUS: writeNode( nn, "-" ); break;
		case MOD: writeNode( nn, "%" ); break;
		case MULT: writeNode( nn, "*" ); break;
		case NEQ: writeNode( nn, "!=" ); break;
		case OR: writeNode( nn, "||" ); break;
		case PLUS: writeNode( nn, "+" ); break;
		}
		String nl = e.el.accept( this );
		String nr = e.er.accept( this );
		writeEdge( nn, nl );
		writeEdge( nn, nr );
		return nn;
	}

	@Override
	public String visitExprArray(ExprArray e) {
		String nn = getNextName();
		writeNode( nn, "array[]" );
		String narr = e.earr.accept( this );
		String nidx = e.eidx.accept( this );
		writeEdge( nn, narr );
		writeEdge( nn, nidx );
		return nn;
	}

	@Override
	public String visitExprLength( ExprLength e ) {
		String nn = getNextName();
		writeNode( nn, "length" );
		String al = e.e.accept( this );
		writeEdge( nn, al );
		return nn;
	}

	@Override
	public String visitExprList(ExprList e) {
		String nn = getNextName();
		writeNode( nn, "ExprList" );
		for( Expr i : e.el ){
			String in = i.accept( this );
			writeEdge( nn, in );
		}
		return nn;
	}

	@Override
	public String visitExprCall(ExprCall e) {
		String nn = getNextName();
		writeNode( nn, "Call: " + e.ide.name );
		String al = e.args.accept( this );
		writeEdge( nn, al );
		return nn;
	}

	@Override
	public String visitExprIde(ExprIde e) {
		String nn = getNextName();
		writeNode( nn, e.name, "shape=plaintext, fontname=Courier" );
		return nn;
	}

	@Override
	public String visitExprLiteral( ExprLiteral e ) {
		String nn = getNextName();
		switch( e.t ){
		case BOOLEAN:
			writeNode( nn, e.val.toString(), "shape=plaintext"  );
			break;
		case INT:
			writeNode( nn, e.val.toString(), "shape=plaintext" );
			break;
		case STRING:
			String rep = StringEscapeUtils.escapeJava((String) e.val);
			writeNode( nn, "\\\"" + rep +"\\\"", "shape=plaintext" );
			break;
		}
		return nn;
	}

	@Override
	public String visitDefinition( Definition d ) {
		String nn = getNextName();
		writeNode( nn, "def: " + d.name.name + "()", "shape=rect" );
		String tn;
		if( d.retType == null){
			tn = getNextName();
			writeNode( tn, "void", "shape=underline"  );
		}else
			tn = d.retType.accept( this );
		writeEdge( nn, tn );
		for( Param p : d.params ){
			String pn = p.accept( this );
			writeEdge( nn, pn );
		}
		String bn = d.b.accept( this );
		writeEdge( nn, bn );
		return nn;
	}

	@Override
	public String visitParam( Param p ) {
		String nn = getNextName();
		writeNode( nn, "par: " + p.ide.name );
		String tn = p.t.accept( this );
		writeEdge( nn, tn );
		return nn;
	}

	@Override
	public String visitStmIfThenElse( StmIfThenElse s ){
		String nn = getNextName();
		writeNode( nn, s.elses == null ? "if-then" : "if-then-else", "shape=trapezium" );
		String ng = s.guard.accept( this );
		writeEdge( nn, ng );
		String nt = s.thens.accept( this );
		writeEdge( nn, nt );
		if( s.elses != null ){
			String ne = s.elses.accept( this );
			writeEdge( nn, ne );
		}
		return nn;
	}

	@Override
	public String visitStmWhile( StmWhile s ) {
		String nn = getNextName();
		writeNode( nn, "while", "shape=trapezium" );
		String ng = s.guard.accept( this );
		writeEdge( nn, ng );
		String nb = s.body.accept( this );
		writeEdge( nn, nb );
		return nn;
	}

	@Override
	public String visitStmAssign( StmAssign b ) {
		String nn = getNextName();
		writeNode( nn, "assign", "shape=trapezium" );
		String sl = b.lvalue.accept( this );
		writeEdge( nn, sl );
		String sr = b.rvalue.accept( this );
		writeEdge( nn, sr );
		return nn;
	}

	@Override
	public String visitStmReturn( StmReturn s ){
		String nn = getNextName();
		writeNode( nn, "return", "shape=trapezium" );
		if( s.retvalue != null ){
			String ne = s.retvalue.accept( this );
			writeEdge( nn, ne );
		}
		return nn;
	}

	@Override
	public String visitStmDeclare(StmDeclare b) {
		String nn = getNextName();
		writeNode( nn, "decl: " + b.ide.name, "shape=trapezium" );
		String nt = b.t.accept( this );
		writeEdge( nn, nt );
		String ne = b.e.accept( this );
		writeEdge( nn, ne );
		return nn;
	}

	@Override
	public String visitStmCall( StmCall b ){
		return b.e.accept( this );
	}

	@Override
	public String visitStmBlock(StmBlock b) {
		String nn = getNextName();
		writeNode( nn, "{...}", "shape=trapezium" );
		for( Stm s : b.stmlist ){
			String sn = s.accept( this );
			writeEdge( nn, sn );
		}
		return nn;
	}

}
