package ch.usi.delrig.ristretto.irtree;

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

/**
 * AST to IRTree translator.
 */
public class IRTranslator extends RistrettoASTVisitor<IRTreeNodeBase>{

    public IRTranslator(){}
    
    
    // #################### MODULE ####################
    
    public IRTreeNodeBase translate( Module m ){
        StmDeclare decl = (StmDeclare)m.dl.get( 0 ).b.stmlist.get( 0 );
        return decl.e.accept( this );
    }

    @Override
    public IRTreeNodeBase visitModule( Module p ){
        // TODO Auto-generated method stub
        return null;
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

    @Override
    public IRTreeNodeBase visitStmDeclare( StmDeclare b ){
        // TODO Auto-generated method stub
        return null;
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

    @Override
    public IRTreeNodeBase visitExprCall( ExprCall e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IRTreeNodeBase visitExprIde( ExprIde e ){
        // TODO Auto-generated method stub
        return null;
    }

    @Override public IRTreeNodeBase visitExprLiteral( ExprLiteral e ){
        switch( e.t ){
        case INT:
            return new IRExpInteger( (Long)e.val );    
        case BOOLEAN:
            boolean b = (Boolean)e.val;
            return new IRExpInteger( b ? 1 : 0 );      
        case STRING:
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
