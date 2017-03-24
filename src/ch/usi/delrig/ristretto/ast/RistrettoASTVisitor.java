package ch.usi.delrig.ristretto.ast;

public abstract class RistrettoASTVisitor<T> {
	public abstract T visitProgram( Program p );
	
	public abstract T visitDefinition( Definition d );
	
	public abstract T visitParam( Param p );
	
	public abstract T visitStmIfThenElse( StmIfThenElse b );
	public abstract T visitStmWhile( StmWhile b );
	public abstract T visitStmAssign( StmAssign b );
	public abstract T visitStmReturn( StmReturn b );
	public abstract T visitStmDeclare( StmDeclare b );
	public abstract T visitStmCall( StmCall b );
	public abstract T visitStmBlock( StmBlock b );
	
	public abstract T visitExprUnary( ExprUnary e );
	public abstract T visitExprBinary( ExprBinary e );
	public abstract T visitExprArray( ExprArray e );
	public abstract T visitExprLength( ExprLength e );
	public abstract T visitExprList( ExprList e );
	public abstract T visitExprCall( ExprCall e );
	public abstract T visitExprIde( ExprIde e );
	public abstract T visitExprLiteral( ExprLiteral e );
	
	public abstract T visitTypeArray( TypeArray t );
	public abstract T visitTypeBoolean( TypeBoolean t );
	public abstract T visitTypeInteger( TypeInteger t );
}
