package ch.usi.delrig.ristretto.ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
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
	
	private final String currentModule;
	
	public ASTBuilder( String module ){
		currentModule = module;
	}
	
	// #################### MODULE ####################
	
	@Override public Object visitModule( RistrettoParser.ModuleContext ctx ){
		List<Definition> dl = new ArrayList<Definition>();
		for( DefContext dctx : ctx.def() )
			dl.add( (Definition)visit( dctx ) );
		return new Module( makePos(ctx), currentModule, dl );
	}
	
	// #################### TYPES ####################
	
	@Override public Object visitTypeArray( RistrettoParser.TypeArrayContext ctx ){ 
		AstType t = (AstType)visit( ctx.type() );
		if( t instanceof AstTypeArray ){
			return new AstTypeArray( makePos(ctx), ((AstTypeArray)t).t, ((AstTypeArray)t).dimensions + 1 );
		}else{
			return new AstTypeArray( makePos(ctx), t, 1 );
		}
	}
	
	@Override public Object visitTypeInt( RistrettoParser.TypeIntContext ctx ){
		return new AstTypeInteger( makePos(ctx) );
	}
	
	@Override public Object visitTypeBoolean( RistrettoParser.TypeBooleanContext ctx ){
		return new AstTypeBoolean( makePos(ctx) );
	}

	// #################### EXPRESSIONS ####################
	
	@Override public Object visitExpPrimary( RistrettoParser.ExpPrimaryContext ctx ){
		return visit( ctx.primary() ); 
	}
	
	@Override public Object visitExpUnary( RistrettoParser.ExpUnaryContext ctx ){
		switch( ctx.op.getType() ){
		case RistrettoParser.NOT:
			return new ExprUnary( makePos(ctx), (Expr)visit(ctx.exp()), Op.NOT );
			
		case RistrettoParser.MINUS:
			return new ExprUnary( makePos(ctx), (Expr)visit(ctx.exp()), Op.MINUS );
		
		default:
			throw new IllegalArgumentException( "Unknown unary operator: " + ctx.op.getText() );
		}	
	}

	@Override public Object visitExpPlusMinus( RistrettoParser.ExpPlusMinusContext ctx ){
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.PLUS:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.PLUS );
		case RistrettoParser.MINUS:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.MINUS );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}
	
	@Override public Object visitExpModDivMul( RistrettoParser.ExpModDivMulContext ctx ){
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.MOD:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.MOD );
		case RistrettoParser.DIV:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.DIV );
		case RistrettoParser.MUL:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.MULT );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpGtLt( RistrettoParser.ExpGtLtContext ctx ){ 
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.GT:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.GT );
		case RistrettoParser.LT:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.LT );
		case RistrettoParser.GE:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.GE );
		case RistrettoParser.LE:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.LE );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpEqNeq( RistrettoParser.ExpEqNeqContext ctx ){ 
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.EQ:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.EQ );
		case RistrettoParser.NEQ:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.NEQ );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpAndOr( RistrettoParser.ExpAndOrContext ctx ){
		Expr left = (Expr)visit( ctx.exp(0) );
		Expr right = (Expr)visit( ctx.exp(1) );
		switch( ctx.op.getType() ){
		case RistrettoParser.AND:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.AND );
		case RistrettoParser.OR:
			return new ExprBinary( makePos(ctx), left, right, ExprBinary.Op.OR );
		default:
			throw new IllegalArgumentException( "Unknown binary operator: " + ctx.op.getType() );
		}
	}

	@Override public Object visitExpIde( RistrettoParser.ExpIdeContext ctx ){ 
		return new ExprIde( makePos(ctx), ctx.IDE().getText() );
	}

	@Override public Object visitExpLitInt( RistrettoParser.ExpLitIntContext ctx ){
		String lexeme = ctx.INT().getText();
		if( lexeme.charAt(0) == '0' && lexeme.length() > 1 && 
				(lexeme.charAt(1) == 'X' || lexeme.charAt(1) == 'x') ){
			return new ExprLiteral( makePos(ctx), Long.parseLong( lexeme.substring(2), 16 ), LitType.INT );
		}else{
			return new ExprLiteral( makePos(ctx), Long.parseLong( lexeme, 10 ), LitType.INT );
		}
	}

	@Override public Object visitExpCall( RistrettoParser.ExpCallContext ctx ){
		return visit( ctx.call() );
	}

	@Override public Object visitExpArray( RistrettoParser.ExpArrayContext ctx ){
		Expr earr = (Expr)visit( ctx.primary() );
		Expr eidx = (Expr)visit( ctx.exp() );
		return new ExprArray( makePos(ctx), earr, eidx ); 
	}
	
	@Override public Object visitExpNewArray( RistrettoParser.ExpNewArrayContext ctx ){
		AstType t = (AstType)visit( ctx.type() );
		List<Expr> dims = new ArrayList<Expr>();
		for( ExpContext exprCtx: ctx.exp() )
			dims.add( (Expr)visit( exprCtx ) );
		return new ExprNewArray( makePos(ctx), t, dims ); 
	}

	@SuppressWarnings("unchecked")
	@Override public Object visitExpList( RistrettoParser.ExpListContext ctx ){
		return new ExprList( makePos(ctx), (List<Expr>)visit( ctx.exps() ) );
	}

	@Override public Object visitExpLitString( RistrettoParser.ExpLitStringContext ctx ){
		String lexeme = ctx.STRING().getText();
		String val = StringEscapeUtils.unescapeJava( lexeme.substring(1, lexeme.length()-1) );
		return new ExprLiteral( makePos(ctx), val, LitType.STRING );
	}

	@Override public Object visitExpParen( RistrettoParser.ExpParenContext ctx ){ 
		return visit( ctx.exp() ); 
	}

	@Override public Object visitExpLitBool( RistrettoParser.ExpLitBoolContext ctx ){
		return new ExprLiteral( makePos(ctx), "true".equals( ctx.val.getText() ), LitType.BOOLEAN );
	}

	@Override public Object visitExpLength( RistrettoParser.ExpLengthContext ctx ){
		Expr e = (Expr)visit( ctx.primary() );
		return new ExprLength( makePos(ctx), e );
	}

	@SuppressWarnings("unchecked")
	@Override public Object visitCall( RistrettoParser.CallContext ctx ){
		ExprIde ide = new ExprIde( makePos(ctx.IDE()), ctx.IDE().getText() );
		List<Expr> el = ctx.exps() != null ? (List<Expr>)visit( ctx.exps() ) : new ArrayList<Expr>();
		return new ExprCall( makePos(ctx), ide, new ExprList( makePos(ctx), el ) );
	}

	@Override public Object visitExps( RistrettoParser.ExpsContext ctx ){
		List<Expr> el = new ArrayList<Expr>();
		for( ExpContext ectx : ctx.exp() )
			el.add( (Expr)visit(ectx) );
		return el;
	}
	
	// #################### DEFINITIONS AND PARAMETERS ####################
	
	@Override public Object visitDefBlock( RistrettoParser.DefBlockContext ctx ){
		Definition d = (Definition)visit( ctx.funHeader() );
		StmBlock b = (StmBlock)visit( ctx.block() );
		return new Definition( makePos(ctx), d.retType, d.name, d.params, b ); 
	}
	
	@Override public Object visitDefExtern( RistrettoParser.DefExternContext ctx ){
		return (Definition)visit( ctx.funHeader() );
	}
	
	@SuppressWarnings("unchecked")
	@Override public Object visitFunHeader (RistrettoParser.FunHeaderContext ctx ){
		AstType t = ctx.type() == null ? null : (AstType)visit( ctx.type() );
		ExprIde ide = new ExprIde( makePos(ctx.IDE()), ctx.IDE().getText() );
		List<Parameter> params = ctx.params() == null ? new ArrayList<Parameter>() : (ArrayList<Parameter>)visit(ctx.params());
		return new Definition( makePos(ctx),  t, ide, params, null );
	}
	
	@Override public Object visitParams( RistrettoParser.ParamsContext ctx ){ 
		List<Parameter> params = new ArrayList<Parameter>();
		for( ParamContext p: ctx.param() )
			params.add( (Parameter)visit( p ) );
		return params; 
	}

	@Override public Object visitParam( RistrettoParser.ParamContext ctx ){
		AstType t = (AstType)visit( ctx.type() );
		ExprIde ide = new ExprIde( makePos(ctx.IDE()), ctx.IDE().getText() );
		return new Parameter( makePos(ctx), t, ide );
	}
	
	// #################### STATEMENTS AND BLOCKS ####################
	
	@Override public Object visitBlock( RistrettoParser.BlockContext ctx ){
		List<Stm> stmlist = new ArrayList<Stm>();
		for( StmContext s: ctx.stm() )
			stmlist.add( (Stm)visit(s) );
		if( stmlist.size() == 1 && stmlist.get(0) instanceof StmBlock)
			return stmlist.get(0);
		else
			return new StmBlock( makePos(ctx), stmlist );
	}
	
	@Override public Object visitStmIfElse( RistrettoParser.StmIfElseContext ctx ){ 
		Expr guard = (Expr)visit( ctx.exp() );
		Stm stmThen = (Stm)visit( ctx.stm(0) );
		Stm stmElse = (Stm)visit( ctx.stm(1) );
		return new StmIfThenElse( makePos(ctx), guard, stmThen, stmElse );
	}
	
	@Override public Object visitStmIf( RistrettoParser.StmIfContext ctx ){ 
		Expr guard = (Expr)visit( ctx.exp() );
		Stm stmThen = (Stm)visit( ctx.stm() );
		return new StmIfThenElse( makePos(ctx), guard, stmThen, null );
	}
	
	@Override public Object visitStmWhile( RistrettoParser.StmWhileContext ctx ){
		Expr guard = (Expr)visit( ctx.exp() );
		Stm body = (Stm)visit( ctx.stm() );
		return new StmWhile( makePos(ctx), guard, body );
	}
	
	@Override public Object visitStmAssign( RistrettoParser.StmAssignContext ctx ){
		ExprIde ide = new ExprIde( makePos(ctx.IDE()), ctx.IDE().getText() );
		Expr rval = (Expr)visit( ctx.exp() );
		return new StmAssign( makePos(ctx), ide, rval );
	}
	
	@Override public Object visitStmAssignArr( RistrettoParser.StmAssignArrContext ctx ){
		Expr lval = (Expr)visit( ctx.primary() );
		Expr idx = (Expr)visit( ctx.exp(0) );
		Expr rval = (Expr)visit( ctx.exp(1) );
		return new StmAssign( makePos(ctx), new ExprArray( makePos(ctx), lval, idx ), rval );
	}
	
	@Override public Object visitStmReturn( RistrettoParser.StmReturnContext ctx ){
		return new StmReturn( makePos(ctx), ctx.exp() == null ? null : (Expr)visit(ctx.exp()) );
	}
	
	@Override public Object visitStmDeclare( RistrettoParser.StmDeclareContext ctx ){
		AstType t = (AstType)visit( ctx.type() );
		ExprIde ide = new ExprIde( makePos(ctx.IDE()), ctx.IDE().getText() );
		Expr e = (Expr)visit( ctx.exp() );
		return new StmDeclare( makePos(ctx), t, ide, e ); 
	}
	
	@Override public Object visitStmCall( RistrettoParser.StmCallContext ctx ){
		ExprCall e = (ExprCall)visit( ctx.call() );
		return new StmCall( makePos(ctx), e );
	}
	
	@Override public Object visitStmBlock( RistrettoParser.StmBlockContext ctx ){
		return (StmBlock)visit( ctx.block() );
	}
	
	// #################### Private methods ####################
	private FilePosition makePos( ParserRuleContext ctx ){
		return new FilePosition( ctx, currentModule );
	}
	
	private FilePosition makePos( TerminalNode tn ){
		return new FilePosition( tn, currentModule );
	}
}
