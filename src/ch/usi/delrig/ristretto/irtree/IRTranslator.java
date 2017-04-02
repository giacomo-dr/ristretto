package ch.usi.delrig.ristretto.irtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.usi.delrig.ristretto.ast.Definition;
import ch.usi.delrig.ristretto.ast.Expr;
import ch.usi.delrig.ristretto.ast.ExprArray;
import ch.usi.delrig.ristretto.ast.ExprBinary;
import ch.usi.delrig.ristretto.ast.ExprCall;
import ch.usi.delrig.ristretto.ast.ExprIde;
import ch.usi.delrig.ristretto.ast.ExprLength;
import ch.usi.delrig.ristretto.ast.ExprList;
import ch.usi.delrig.ristretto.ast.ExprLiteral;
import ch.usi.delrig.ristretto.ast.ExprNewArray;
import ch.usi.delrig.ristretto.ast.ExprUnary;
import ch.usi.delrig.ristretto.ast.Module;
import ch.usi.delrig.ristretto.ast.Parameter;
import ch.usi.delrig.ristretto.ast.StmAssign;
import ch.usi.delrig.ristretto.ast.StmBlock;
import ch.usi.delrig.ristretto.ast.StmCall;
import ch.usi.delrig.ristretto.ast.StmDeclare;
import ch.usi.delrig.ristretto.ast.StmIfThenElse;
import ch.usi.delrig.ristretto.ast.StmReturn;
import ch.usi.delrig.ristretto.ast.StmWhile;
import ch.usi.delrig.ristretto.irtree.IRExpOperation.Op;
import ch.usi.delrig.ristretto.irtree.SymbolTable.Entry;
import ch.usi.delrig.ristretto.typechecker.StaticAnalysisException;
import ch.usi.delrig.ristretto.typechecker.Type;
import ch.usi.delrig.ristretto.typechecker.TypeFunction;

/**
 * AST to IRTree translator.
 */
public class IRTranslator{
    
    // Map from labels to array contents used to gather array literals
    public final Map<String, String> initializedArrays;
    public final SymbolTable symtable;
    
    private int nextLabel;
    private int nextTemporary;

    public IRTranslator(){
        initializedArrays = new TreeMap<String, String>();
        symtable = new SymbolTable();
        nextLabel = 0;
        nextTemporary = 0;
    }
    
    public List<IRProcedure> translate( List<Module> modules ) throws StaticAnalysisException{
        symtable.pushFrame();
        
        // Bind all function names to a new label
        for( Module m : modules )
            bindTopLevelNamesToNewLabels( m );
        symtable.dump( System.out );
        
        // Translate each module one by one
        List<IRProcedure> res = new ArrayList<IRProcedure>();
        for( Module m : modules )
            res.addAll( translateModule( m ) );
        
        symtable.popFrame();
        if( !symtable.hasNoFrames() )
            throw new RuntimeException( "Invalid status of symbol table at end of IR translation." );
        return res;
    }
    
    // #################### MODULE ####################

    public List<IRProcedure> translateModule( Module m ){
        List<IRProcedure> procs = new ArrayList<IRProcedure>();
        for( Definition d: m.dl )
            procs.add( translateDefinition( d ) );
        return procs;
    }

    
    // #################### DEFINITIONS AND PARAMETERS ####################
    
    public IRProcedure translateDefinition( Definition d ){
        symtable.pushFrame();
        List<String> args = bindArgumentsToNewTemporaries( d.params );
        List<IRStm> stmtLst = translateStmBlock( d.b );
        String funLabel = symtable.lookup( d.name.name ).label;
        StmDeclare decl = (StmDeclare)d.b.stmlist.get( 0 );
        IRProcedure proc = new IRProcedure( funLabel , args, 
                new IRExpBegin( stmtLst, translateExpr( decl.e ) ) );
        symtable.dump( System.out );
        symtable.popFrame();
        return proc;
    }
    
    
    // #################### STATEMENTS AND BLOCKS ####################
    
    public List<IRStm> translateStmIfThenElse( StmIfThenElse s ){
        // TODO Auto-generated method stub
        return null;
    }

    public List<IRStm> translateStmWhile( StmWhile s ){
        // TODO Auto-generated method stub
        return null;
    }

    public List<IRStm> translateStmAssign( StmAssign s ){
        // TODO Auto-generated method stub
        return null;
    }

    public List<IRStm> translateStmReturn( StmReturn s ){
        // TODO Auto-generated method stub
        return null;
    }

    public List<IRStm> translateStmDeclare( StmDeclare s ){
        String tmp = newTemp( s.ide.name );
        symtable.bindToTemp( s.ide.name, tmp );
        IRExp irexp = translateExpr( s.e );
        return newStmList( new IRStmMove( tmp, irexp ) );
    }

    public List<IRStm> translateStmCall( StmCall s ){
        // TODO Auto-generated method stub
        return null;
    }

    public List<IRStm> translateStmBlock( StmBlock s ){
        // TODO Auto-generated method stub
        return newStmList( new IRStmNop() );
    }
    
    
    // #################### EXPRESSIONS ####################

    public IRExp translateExpr( Expr e ){
             if( e instanceof ExprUnary ) return translateExprUnary( (ExprUnary)e );
        else if( e instanceof ExprBinary ) return translateExprBinary( (ExprBinary)e );
        else if( e instanceof ExprArray ) return translateExprArray( (ExprArray)e );
        else if( e instanceof ExprNewArray ) return translateExprNewArray( (ExprNewArray)e );
        else if( e instanceof ExprLength ) return translateExprLength( (ExprLength)e );
        else if( e instanceof ExprList ) return translateExprList( (ExprList)e );
        else if( e instanceof ExprCall ) return translateExprCall( (ExprCall)e );
        else if( e instanceof ExprIde ) return translateExprIde( (ExprIde)e );
        else if( e instanceof ExprLiteral ) return translateExprLiteral( (ExprLiteral)e );
        else throw new IllegalArgumentException( "Unknown expression type " + e );
    }
    
    public IRExp translateExprUnary( ExprUnary e ){
        // TODO Auto-generated method stub
        return null;
    }

    public IRExp translateExprBinary( ExprBinary e ){
        IRExp lexp = translateExpr( e.el );
        IRExp rexp = translateExpr( e.el );
        switch( e.op ){
        case MINUS:
            return new IRExpOperation( lexp, rexp, Op.SUB );
        case PLUS:
            return new IRExpOperation( lexp, rexp, Op.ADD );
        case MULT:
            return new IRExpOperation( lexp, rexp, Op.MUL );
        case AND:
            return null;
        case DIV:
            break;
        case EQ:
            break;
        case GE:
            break;
        case GT:
            break;
        case LE:
            break;
        case LT:
            break;
        case MOD:
            break;
        case NEQ:
            break;
        case OR:
            break;  
        default:
            throw new IllegalArgumentException( "Unknown operator." );
        }
        throw new IllegalArgumentException( "Should not get there." );
    }

    public IRExp translateExprArray( ExprArray e ){
        // TODO Auto-generated method stub
        return null;
    }

    public IRExp translateExprNewArray( ExprNewArray e ){
        // TODO Auto-generated method stub
        return null;
    }

    public IRExp translateExprLength( ExprLength e ){
        // TODO Auto-generated method stub
        return null;
    }

    public IRExp translateExprList( ExprList e ){
        // TODO Auto-generated method stub
        return null;
    }

    public IRExp translateExprCall( ExprCall e ){
        // TODO Auto-generated method stub
        return null;
    }

    public IRExp translateExprIde( ExprIde e ){
        Entry tempOrLabel = symtable.lookup( e.name );
        if( tempOrLabel == null )
            throw new IllegalArgumentException( "Undefined name " + e.name );
        
        if( tempOrLabel.label != null )
            return new IRExpLabel( tempOrLabel.label );
        else
            return new IRExpTemp( tempOrLabel.temp );
    }

    public IRExp translateExprLiteral( ExprLiteral e ){
        switch( e.t ){
        case INT:
            return new IRExpInteger( (Long)e.val );    
        case BOOLEAN:
            boolean b = (Boolean)e.val;
            return new IRExpInteger( b ? 1 : 0 );
        case STRING:
            String s = (String)e.val;
            String lbl = newLabel();
            initializedArrays.put( lbl, s );
            return new IRExpLabel( lbl );
        default:
            throw new UnsupportedOperationException( "Not implemented." );
        }
    }
    
    
    // #################### PRIVATE METHODS ####################
    
    private String newLabel( String suffix ){
        return "$" + (nextLabel++) + (suffix == null ? "" : "-" + suffix);
    }
    private String newLabel(){ return newLabel( null ); }
    
    private String newTemp( String suffix ){
        return "%" + (nextTemporary++) + (suffix == null ? "" : "-" + suffix);
    }
    private String newTemp(){ return newTemp( null ); }
    
    private void bindTopLevelNamesToNewLabels( Module m ) throws StaticAnalysisException{
        for( Definition d: m.dl )
            symtable.bindToLabel( d.name.name, newLabel( d.name.name ) );
    }
    
    private List<String> bindArgumentsToNewTemporaries( List<Parameter> params ){
        List<String> tempLst = new ArrayList<String>();
        for( Parameter p: params ){
            String t = newTemp( p.ide.name );
            tempLst.add( t );
            symtable.bindToTemp( p.ide.name, t );
        }
        return tempLst;
    }
    
    private List<IRStm> newStmList( IRStm s ){
        List<IRStm> lst = new ArrayList<IRStm>();
        lst.add( s );
        return lst;
    }
}
