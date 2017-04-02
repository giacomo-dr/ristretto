package ch.usi.delrig.ristretto.irtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.usi.delrig.ristretto.ast.AstTypeArray;
import ch.usi.delrig.ristretto.ast.AstTypeBoolean;
import ch.usi.delrig.ristretto.ast.AstTypeInteger;
import ch.usi.delrig.ristretto.ast.Definition;
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
import ch.usi.delrig.ristretto.ast.RistrettoASTVisitor;
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

/**
 * AST to IRTree translator.
 */
public class IRTranslator extends RistrettoASTVisitor<IRTreeNodeBase>{
    
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
    
    public List<IRTreeNodeBase> translate( List<Module> modules ) throws StaticAnalysisException{
        symtable.pushFrame();
        
        // Bind all function names to a new label
        for( Module m : modules )
            bindTopLevelNamesToNewLabels( m );
        symtable.dump( System.out );
        
        // Translate each module one by one
        // TODO Return some value!!!
        List<IRTreeNodeBase> res = new ArrayList<IRTreeNodeBase>();
        res.add( modules.get(0).accept( this ) );
        //for( Module m : modules )
        //    m.accept( this );
        
        symtable.popFrame();
        if( !symtable.hasNoFrames() )
            throw new RuntimeException( "Invalid status of symbol table at end of IR translation." );
        return res;
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
        for( Definition d: m.dl ){
            Entry prev = symtable.lookup( d.name.name );
            if( prev != null )
                throw new IllegalArgumentException( "Function name already bound." );
            
            symtable.bindToLabel( d.name.name, newLabel( d.name.name ) );
        }
    }
    
    // #################### MODULE ####################

    @Override public IRTreeNodeBase visitModule( Module m ){
        List<IRProcedure> procs = new ArrayList<IRProcedure>();
        for( Definition d: m.dl )
            procs.add( (IRProcedure)d.accept( this ) );
        return procs.get( 0 );
        
//        symtable.pushFrame();
//        StmDeclare decl = (StmDeclare)m.dl.get( 0 ).b.stmlist.get( 0 );
//        IRTreeNodeBase res = decl.accept( this );
//        symtable.popFrame();
//        return res;
    }

    
    // #################### DEFINITIONS AND PARAMETERS ####################
    
    @Override
    public IRTreeNodeBase visitDefinition( Definition d ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitParam( Parameter p ){
        // TODO Auto-generated method stub
        return null;
    }

    
    // #################### STATEMENTS AND BLOCKS ####################
    
    @Override
    public IRTreeNodeBase visitStmIfThenElse( StmIfThenElse b ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitStmWhile( StmWhile b ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitStmAssign( StmAssign b ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitStmReturn( StmReturn b ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override public IRTreeNodeBase visitStmDeclare( StmDeclare b ){
        String tmp = newTemp( b.ide.name );
        symtable.bindToTemp( b.ide.name, tmp );
        IRExp irexp = (IRExp)b.e.accept( this );
        return new IRStmMove( tmp, irexp );
    }

    @Override
    public IRTreeNodeBase visitStmCall( StmCall b ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitStmBlock( StmBlock b ){
        // TODO Auto-generated method stub
        return null;
    }
    
    
    // #################### EXPRESSIONS ####################

    @Override
    public IRTreeNodeBase visitExprUnary( ExprUnary e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override public IRTreeNodeBase visitExprBinary( ExprBinary e ){
        IRExp lexp = (IRExp)e.el.accept(this);
        IRExp rexp = (IRExp)e.el.accept(this);
        switch( e.op ){
        case MINUS:
            return new IRExpOperation( lexp, rexp, Op.SUB );
        case PLUS:
            return new IRExpOperation( lexp, rexp, Op.ADD );
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
        case MULT:
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

    @Override
    public IRTreeNodeBase visitExprArray( ExprArray e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitExprNewArray( ExprNewArray e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitExprLength( ExprLength e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitExprList( ExprList e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override public IRTreeNodeBase visitExprCall( ExprCall e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override public IRTreeNodeBase visitExprIde( ExprIde e ){
        Entry tempOrLabel = symtable.lookup( e.name );
        if( tempOrLabel == null )
            throw new IllegalArgumentException( "Undefined name " + e.name );
        
        if( tempOrLabel.label != null )
            return new IRExpLabel( tempOrLabel.label );
        else
            return new IRExpTemp( tempOrLabel.temp );
    }

    @Override public IRTreeNodeBase visitExprLiteral( ExprLiteral e ){
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
    
    
    // #################### TYPES ####################

    @Override
    public IRTreeNodeBase visitAstTypeArray( AstTypeArray t ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitAstTypeBoolean( AstTypeBoolean t ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitAstTypeInteger( AstTypeInteger t ){
        // TODO Auto-generated method stub
        return null;
    }
}
