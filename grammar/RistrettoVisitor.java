// Generated from ./grammar/Ristretto.g4 by ANTLR 4.6

	package ch.usi.delrig.ristretto.antlrparser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RistrettoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RistrettoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(RistrettoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(RistrettoParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(RistrettoParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(RistrettoParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(RistrettoParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmIfElse}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmIfElse(RistrettoParser.StmIfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmIf}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmIf(RistrettoParser.StmIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmWhile}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmWhile(RistrettoParser.StmWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmAssign}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmAssign(RistrettoParser.StmAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmAssignArr}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmAssignArr(RistrettoParser.StmAssignArrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmReturn}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmReturn(RistrettoParser.StmReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmDeclare}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmDeclare(RistrettoParser.StmDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmCall}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmCall(RistrettoParser.StmCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmBlock}
	 * labeled alternative in {@link RistrettoParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmBlock(RistrettoParser.StmBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeArray}
	 * labeled alternative in {@link RistrettoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArray(RistrettoParser.TypeArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link RistrettoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBoolean(RistrettoParser.TypeBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link RistrettoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(RistrettoParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpPlusMinus}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPlusMinus(RistrettoParser.ExpPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpPrimary}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPrimary(RistrettoParser.ExpPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpModDivMul}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpModDivMul(RistrettoParser.ExpModDivMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpGtLt}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpGtLt(RistrettoParser.ExpGtLtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpEqNeq}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpEqNeq(RistrettoParser.ExpEqNeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpUnary}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpUnary(RistrettoParser.ExpUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAndOr}
	 * labeled alternative in {@link RistrettoParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAndOr(RistrettoParser.ExpAndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpIde}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIde(RistrettoParser.ExpIdeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpLitInt}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLitInt(RistrettoParser.ExpLitIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpCall}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCall(RistrettoParser.ExpCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpArray}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpArray(RistrettoParser.ExpArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpList}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpList(RistrettoParser.ExpListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpLitString}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLitString(RistrettoParser.ExpLitStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpParen}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParen(RistrettoParser.ExpParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpLitBool}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLitBool(RistrettoParser.ExpLitBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpLength}
	 * labeled alternative in {@link RistrettoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLength(RistrettoParser.ExpLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(RistrettoParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link RistrettoParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(RistrettoParser.ExpsContext ctx);
}