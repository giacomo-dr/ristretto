package ch.usi.delrig.ristretto.ast;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

import ch.usi.delrig.ristretto.antlrparser.RistrettoBaseVisitor;
import ch.usi.delrig.ristretto.antlrparser.RistrettoParser;
import ch.usi.delrig.ristretto.antlrparser.RistrettoParser.DefContext;
import ch.usi.delrig.ristretto.antlrparser.RistrettoParser.ExpContext;
import ch.usi.delrig.ristretto.antlrparser.RistrettoParser.ParamContext;
import ch.usi.delrig.ristretto.antlrparser.RistrettoParser.StmContext;
import ch.usi.delrig.ristretto.ast.ExprLiteral.LitType;
import ch.usi.delrig.ristretto.ast.ExprUnary.Op;

/***
 * Builds an AST from the ANTLR 4 parse tree.
 * 
 * @author Giacomo Del Rio
 */
public class ASTBuilder extends RistrettoBaseVisitor<Object> {
	
	// #################### PROGRAM ####################
	
	@Override public Object visitProgram( RistrettoParser.ProgramContext ctx ){ 
		List<Definition> dl = new ArrayList<Definition>();
		for( DefContext dctx : ctx.def() )
			dl.add( (Definition)visit( dctx ) );
		return new Program( ctx, dl );
	}
	
	// #################### TYPES ####################
	
	@Override public Object visitTypeArray( RistrettoParser.TypeArrayContext ctx ){ 
		Type t = (Type)visit( ctx.type() );
		if( t instanceof TypeArray ){
			return new TypeArray( ctx, ((TypeArray)t).t, ((TypeArray)t).dimensions + 1 );
		}else{
			return new TypeArray( ctx, t, 1 );
		}
	}
	
	@Override public Object visitTypeInt( RistrettoParser.TypeIntContext ctx ){
		return new TypeInteger( ctx );
	}
	
	@Override public Object visitTypeBoolean( RistrettoParser.TypeBooleanContext ctx ){
		return new TypeBoolean( ctx );
	}

	// #################### EXPRESSIONS ####################
	
	@Override public Object visitExpPrimary( RistrettoParser.ExpPrimaryContext ctx ){
		return visit( ctx.primary() ); 
	}
	
	@Override public Object visitExpUnary( RistrettoParser.ExpUnaryContext ctx ){
		switch( ctx.op.getType() ){
		case RistrettoParser.NOT:
			return new ExprUnary( ctx, (Expr)visit(ctx.exp()), Op.NOT );
			
		case RistrettoParser.MINUS:
			return new ExprUnary( ctx, (Expr)visit(ctx.exp()), Op.MINUS );
		
		default:
			throw new IllegalArgumentException( "Unknown unary operator: " + ctx.op.getText() );
		}	
	}

	@Override public Object visitExpPlusMinus( RistrettoParser.ExpPlusMinusContext ctx ){
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.PLUS:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.PLUS );
		case RistrettoParser.MINUS:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.MINUS );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}
	
	@Override public Object visitExpModDivMul( RistrettoParser.ExpModDivMulContext ctx ){
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.MOD:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.MOD );
		case RistrettoParser.DIV:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.DIV );
		case RistrettoParser.MUL:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.MULT );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpGtLt( RistrettoParser.ExpGtLtContext ctx ){ 
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.GT:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.GT );
		case RistrettoParser.LT:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.LT );
		case RistrettoParser.GE:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.GE );
		case RistrettoParser.LE:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.LE );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpEqNeq( RistrettoParser.ExpEqNeqContext ctx ){ 
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.EQ:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.EQ );
		case RistrettoParser.NEQ:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.NEQ );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpAndOr( RistrettoParser.ExpAndOrContext ctx ){
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.AND:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.AND );
		case RistrettoParser.OR:
			return new ExprBinary( ctx, left, right, ExprBinary.Op.OR );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpIde( RistrettoParser.ExpIdeContext ctx ){ 
		return new ExprIde( ctx, ctx.IDE().getText() );
	}

	@Override public Object visitExpLitInt( RistrettoParser.ExpLitIntContext ctx ){
		String lexeme = ctx.INT().getText();
		if( lexeme.charAt(0) == '0' && lexeme.length() > 1 && 
				(lexeme.charAt(1) == 'X' || lexeme.charAt(1) == 'x') ){
			return new ExprLiteral( ctx, Long.parseLong( lexeme.substring(2), 16 ), LitType.INT );
		}else{
			return new ExprLiteral( ctx, Long.parseLong( lexeme, 10 ), LitType.INT );
		}
	}

	@Override public Object visitExpCall( RistrettoParser.ExpCallContext ctx ){
		return visit( ctx.call() );
	}

	@Override public Object visitExpArray( RistrettoParser.ExpArrayContext ctx ){
		Expr earr = (Expr)visit( ctx.primary() );
		Expr eidx = (Expr)visit( ctx.exp() );
		return new ExprArray( ctx, earr, eidx ); 
	}

	@SuppressWarnings("unchecked")
	@Override public Object visitExpList( RistrettoParser.ExpListContext ctx ){
		return new ExprList( ctx, (List<Expr>)visit( ctx.exps() ) );
	}

	@Override public Object visitExpLitString( RistrettoParser.ExpLitStringContext ctx ){
		String lexeme = ctx.STRING().getText();
		String val = StringEscapeUtils.unescapeJava( lexeme.substring(1, lexeme.length()-1) );
		return new ExprLiteral( ctx, val, LitType.STRING );
	}

	@Override public Object visitExpParen( RistrettoParser.ExpParenContext ctx ){ 
		return visit( ctx.exp() ); 
	}

	@Override public Object visitExpLitBool( RistrettoParser.ExpLitBoolContext ctx ){
		return new ExprLiteral( ctx, "true".equals( ctx.val.getText() ), LitType.BOOLEAN );
	}

	@Override public Object visitExpLength( RistrettoParser.ExpLengthContext ctx ){
		Expr e = (Expr)visit( ctx.primary() );
		return new ExprLength( ctx, e );
	}

	@SuppressWarnings("unchecked")
	@Override public Object visitCall( RistrettoParser.CallContext ctx ){
		ExprIde ide = new ExprIde( ctx, ctx.IDE().getText() );
		List<Expr> el = ctx.exps() != null ? (List<Expr>)visit( ctx.exps() ) : new ArrayList<Expr>();
		return new ExprCall( ctx, ide, new ExprList( ctx, el ) );
	}

	@Override public Object visitExps( RistrettoParser.ExpsContext ctx ){
		List<Expr> el = new ArrayList<Expr>();
		for( ExpContext ectx : ctx.exp() )
			el.add( (Expr)visit(ectx) );
		return el;
	}
	
	// #################### DEFINITIONS AND PARAMETERS ####################
	
	@SuppressWarnings("unchecked")
	@Override public Object visitDef( RistrettoParser.DefContext ctx ){
		Type t = ctx.type() == null ? null : (Type)visit( ctx.type() );
		ExprIde ide = new ExprIde( ctx, ctx.IDE().getText() );
		List<Param> params = ctx.params() == null ? new ArrayList<Param>() : (ArrayList<Param>)visit(ctx.params());
		StmBlock b = (StmBlock)visit( ctx.block() );
		return new Definition( ctx,  t, ide, params, b ); 
	}
	
	@Override public Object visitParams( RistrettoParser.ParamsContext ctx ){ 
		List<Param> params = new ArrayList<Param>();
		for( ParamContext p: ctx.param() )
			params.add( (Param)visit( p ) );
		return params; 
	}

	@Override public Object visitParam( RistrettoParser.ParamContext ctx ){
		Type t = (Type)visit( ctx.type() );
		ExprIde ide = new ExprIde( ctx, ctx.IDE().getText() );
		return new Param( ctx, t, ide );
	}
	
	// #################### STATEMENTS AND BLOCKS ####################
	
	@Override public Object visitBlock( RistrettoParser.BlockContext ctx ){
		List<Stm> stmlist = new ArrayList<Stm>();
		for( StmContext s: ctx.stm() )
			stmlist.add( (Stm)visit(s) );
		if( stmlist.size() == 1 && stmlist.get(0) instanceof StmBlock)
			return stmlist.get(0);
		else
			return new StmBlock( ctx, stmlist );
	}
	
	@Override public Object visitStmIfElse( RistrettoParser.StmIfElseContext ctx ){ 
		Expr guard = (Expr)visit( ctx.exp() );
		Stm stmThen = (Stm)visit( ctx.stm(0) );
		Stm stmElse = (Stm)visit( ctx.stm(1) );
		return new StmIfThenElse( ctx, guard, stmThen, stmElse );
	}
	
	@Override public Object visitStmIf( RistrettoParser.StmIfContext ctx ){ 
		Expr guard = (Expr)visit( ctx.exp() );
		Stm stmThen = (Stm)visit( ctx.stm() );
		return new StmIfThenElse( ctx, guard, stmThen, null );
	}
	
	@Override public Object visitStmWhile( RistrettoParser.StmWhileContext ctx ){
		Expr guard = (Expr)visit( ctx.exp() );
		Stm body = (Stm)visit( ctx.stm() );
		return new StmWhile( ctx, guard, body );
	}
	
	@Override public Object visitStmAssign( RistrettoParser.StmAssignContext ctx ){
		ExprIde ide = new ExprIde( ctx, ctx.IDE().getText() );
		Expr rval = (Expr)visit( ctx.exp() );
		return new StmAssign( ctx, ide, rval );
	}
	
	@Override public Object visitStmAssignArr( RistrettoParser.StmAssignArrContext ctx ){
		Expr lval = (Expr)visit( ctx.primary() );
		Expr idx = (Expr)visit( ctx.exp(0) );
		Expr rval = (Expr)visit( ctx.exp(1) );
		return new StmAssign( ctx, new ExprArray( ctx, lval, idx ), rval );
	}
	
	@Override public Object visitStmReturn( RistrettoParser.StmReturnContext ctx ){
		return new StmReturn( ctx, ctx.exp() == null ? null : (Expr)visit(ctx.exp()) );
	}
	
	@Override public Object visitStmDeclare( RistrettoParser.StmDeclareContext ctx ){
		Type t = (Type)visit( ctx.type() );
		ExprIde ide = new ExprIde( ctx, ctx.IDE().getText() );
		Expr e = (Expr)visit( ctx.exp() );
		return new StmDeclare( ctx, t, ide, e ); 
	}
	
	@Override public Object visitStmCall( RistrettoParser.StmCallContext ctx ){
		ExprCall e = (ExprCall)visit( ctx.call() );
		return new StmCall( ctx, e );
	}
	
	@Override public Object visitStmBlock( RistrettoParser.StmBlockContext ctx ){
		return (StmBlock)visit( ctx.block() );
	}
}
