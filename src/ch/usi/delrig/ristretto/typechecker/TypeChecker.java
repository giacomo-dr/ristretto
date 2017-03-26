package ch.usi.delrig.ristretto.typechecker;

import static ch.usi.delrig.ristretto.typechecker.Type.isArray;
import static ch.usi.delrig.ristretto.typechecker.Type.isBoolean;
import static ch.usi.delrig.ristretto.typechecker.Type.isFunction;
import static ch.usi.delrig.ristretto.typechecker.Type.isInt;
import static ch.usi.delrig.ristretto.typechecker.Type.isVoid;

import java.util.ArrayList;
import java.util.List;

import ch.usi.delrig.ristretto.ast.AstTypeArray;
import ch.usi.delrig.ristretto.ast.AstTypeBoolean;
import ch.usi.delrig.ristretto.ast.AstTypeInteger;
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
import ch.usi.delrig.ristretto.ast.RistrettoASTVisitor;
import ch.usi.delrig.ristretto.ast.Stm;
import ch.usi.delrig.ristretto.ast.StmAssign;
import ch.usi.delrig.ristretto.ast.StmBlock;
import ch.usi.delrig.ristretto.ast.StmCall;
import ch.usi.delrig.ristretto.ast.StmDeclare;
import ch.usi.delrig.ristretto.ast.StmIfThenElse;
import ch.usi.delrig.ristretto.ast.StmReturn;
import ch.usi.delrig.ristretto.ast.StmWhile;
import ch.usi.delrig.ristretto.typechecker.SymbolTable.Entry;
import ch.usi.delrig.ristretto.typechecker.TypeFunction.Param;

public class TypeChecker extends RistrettoASTVisitor<Type> {
	
	private final SymbolTable symtbl = new SymbolTable();
	private String currentModule = null;
	
	public TypeChecker(){
	}
	
	public void check( List<Module> modules ) throws StaticAnalysisException{
		symtbl.pushFrame();
		
		// Add all function names to global scope
		for( Module m : modules ){
			currentModule = m.name;
			addTopLevelNamesToSymbolTable( m );
		}
		//symtbl.dump( System.out );
		
		// Check each module one by one
		for( Module m : modules )
			m.accept( this );
		
		symtbl.popFrame();
		if( !symtbl.hasNoFrames() )
			throw new RuntimeException( "Invalid status of symbol table at end of checking." );
	}

	
	// #################### MODULE ####################
	
	@Override public Type visitModule( Module m ){
	    currentModule = m.name;
		for( Definition d: m.dl )
			d.accept( this );
		return null;
	}

	
	// #################### DEFINITIONS AND PARAMETERS ####################
	
	/**
	 * We assume that definition names are already in symbol table
	 */
	@Override public Type visitDefinition( Definition d ){
		Type retType = ((TypeFunction)symtbl.lookup( d.name.name ).type).returnType;
		if( d.b == null )
			return retType; // Extern definition, nothing to do
		
		symtbl.pushFrame();
		bindParameters( d.params );
		typecheckStmBlock( d.b, retType, false );
		symtbl.popFrame();
		
		return null;
	}

	@Override public Type visitParam( Parameter p ){
		throw new UnsupportedOperationException( "This shouldn't happen!" );
	}

	
	// #################### STATEMENTS AND BLOCKS ####################
	// Statements are not implemented using AST visitor, since
	// we know in advance what should be the expected type. Expected types
	// are propagated downward in the three, rather than synthesized from leaves.
	// This allows a more accurate error reporting.
	
	@Override public Type visitStmBlock( StmBlock s ){ throw new UnsupportedOperationException(); }
	@Override public Type visitStmReturn( StmReturn s ){ throw new UnsupportedOperationException(); }
	@Override public Type visitStmDeclare( StmDeclare s ){ throw new UnsupportedOperationException(); }
	@Override public Type visitStmAssign( StmAssign s ){ throw new UnsupportedOperationException(); }
	@Override public Type visitStmIfThenElse( StmIfThenElse s ){ throw new UnsupportedOperationException(); }
	@Override public Type visitStmWhile( StmWhile s ){ throw new UnsupportedOperationException(); }
	@Override public Type visitStmCall( StmCall s ){ throw new UnsupportedOperationException(); }

	public void typecheckStatement( Stm s, Type expectedReturnType ){
		     if( s instanceof StmBlock ) typecheckStmBlock( (StmBlock)s, expectedReturnType );
		else if( s instanceof StmAssign ) typecheckStmAssign( (StmAssign)s, expectedReturnType );
		else if( s instanceof StmDeclare ) typecheckStmDeclare( (StmDeclare)s, expectedReturnType );
		else if( s instanceof StmCall ) typecheckStmCall( (StmCall)s, expectedReturnType );
		else if( s instanceof StmReturn ) typecheckStmReturn( (StmReturn)s, expectedReturnType );
		else if( s instanceof StmIfThenElse ) typecheckStmIfThenElse( (StmIfThenElse)s, expectedReturnType );
		else if( s instanceof StmWhile ) typecheckStmWhile( (StmWhile)s, expectedReturnType );
		else throw new IllegalArgumentException( "Unknown statement type " + s );
	}
	
	/**
	 * When expectedReturnType == null the block can't contains return statements anywhere;
	 * When expectedReturnType == Void the block may contain (void) return statements;
	 * When expectedReturnType == T the block must definitely returns with type T;
	 */
	public void typecheckStmBlock( StmBlock blk, Type expectedReturnType ){ 
	    typecheckStmBlock( blk, expectedReturnType, true ); 
	}
	public void typecheckStmBlock( StmBlock blk, Type expectedReturnType, boolean pushNewFrame ){
		int bodyLen = blk.stmlist.size();
		
		// Special case of empty blocks
		if( bodyLen == 0 && expectedReturnType != null && !isVoid(expectedReturnType) )
			throw new StaticAnalysisException( "The function must return a value.", blk.position );
		
		// Non empty blocks
		if( pushNewFrame ) symtbl.pushFrame();
		for( int i = 0 ; i < bodyLen ; i++ ){
			Stm s = blk.stmlist.get(i);
			typecheckStatement( s, i != (bodyLen-1) ? null : expectedReturnType );
			
			// Last statement can not be a variable declaration
			if( i == (bodyLen-1) && s instanceof StmDeclare )
				throw new StaticAnalysisException( "A block can't end"
						+ " with a variable declaration.", s.position );
		}
		if( pushNewFrame ) symtbl.popFrame();
	}
	
	public void typecheckStmIfThenElse( StmIfThenElse ite, Type expectedReturnType ){
	    Type guardType = ite.guard.accept( this );
	    if( !isBoolean(guardType) )
	        throw new StaticAnalysisException( "If statement guard must evaluate to"
	                + " boolean, " + guardType + " found.", ite.guard.position );
	    if(  ite.thens instanceof StmDeclare )
            throw new StaticAnalysisException( "Variable declarations are allowed"
                    + " only in blocks.", ite.thens.position );
	    typecheckStatement( ite.thens, expectedReturnType );
	    if( ite.elses != null){
	        if(  ite.elses instanceof StmDeclare )
	            throw new StaticAnalysisException( "Variable declarations are allowed"
	                    + " only in blocks.", ite.elses.position );
	        typecheckStatement( ite.elses, expectedReturnType );
	    }
	}
	
	public void typecheckStmWhile( StmWhile whi, Type expectedReturnType ){
	    Type guardType = whi.guard.accept( this );
        if( !isBoolean(guardType) )
            throw new StaticAnalysisException( "While statement guard must evaluate to"
                    + " boolean, " + guardType + " found.", whi.guard.position );
        if(  whi.body instanceof StmDeclare )
            throw new StaticAnalysisException( "Variable declarations are allowed"
                    + " only in blocks.", whi.body.position );
        typecheckStatement( whi.body, null );
	}
	
	public void typecheckStmAssign( StmAssign asg, Type expectedReturnType ){
		Type lType = asg.lvalue.accept( this );
		if( isBoolean( lType ) || isInt( lType ) ){
			if( !(asg.lvalue instanceof ExprIde || asg.lvalue instanceof ExprArray) ){
				throw new StaticAnalysisException( "Can assign a value only to a variable.",
						asg.lvalue.position );
			}else{
				Type rType = asg.rvalue.accept( this );
				if( !lType.equals( rType) )
					throw new StaticAnalysisException( lType + " value expected, found " + rType + ".",
							asg.rvalue.position );
			}
		}else if( isArray(lType) ){
			Type rType = asg.rvalue.accept( this );
			if( !lType.equals( rType) )
				throw new StaticAnalysisException( lType + " value expected, found " + rType + ".",
						asg.rvalue.position );
		}else
			throw new StaticAnalysisException( "Can't assign a value to a " + lType + " expression.",
					asg.lvalue.position );
	
		if( expectedReturnType != null && !isVoid(expectedReturnType) )
			throw new StaticAnalysisException( "Function must return a value. Return expected.", asg.position );
	}

	public void typecheckStmReturn( StmReturn ret, Type expectedReturnType ){
		if( expectedReturnType == null )
			throw new StaticAnalysisException( "A 'return' statement can only"
					+ " appear at the end of a function.", ret.position );
		else if( isVoid(expectedReturnType) ){
			if( ret.retvalue != null )
				throw new StaticAnalysisException( "A void function can not"
						+ " return a value.", ret.retvalue.position );
		}else{
			Type t = ret.retvalue.accept( this );
			if( !t.equals(expectedReturnType) )
				throw new StaticAnalysisException( "The function should return "
						+ expectedReturnType + " not " + t + ".", ret.retvalue.position );
		}
	}
	
	public void typecheckStmDeclare( StmDeclare decl, Type expectedReturnType ){
		Entry prevDecl = symtbl.lookup( decl.ide.name );
		if( prevDecl != null )
			throw new StaticAnalysisException( "Variable redeclaration. The name '"
					+ decl.ide.name + "' was already declared in " + prevDecl.position + ".", decl.ide.position );
		
		Type declType = decl.t.accept( this );
		if( isVoid(declType) )
			throw new StaticAnalysisException( "Can't declare a void variable.", decl.t.position );
		
		Type initType = decl.e.accept( this );
		if( !declType.equals( initType ) )
			throw new StaticAnalysisException( "Expression of type " + declType +
					" expected.", decl.e.position );
		
		if( expectedReturnType != null && !isVoid(expectedReturnType) )
			throw new StaticAnalysisException( "Function must return a value. Return expected.", decl.position );
		
		symtbl.addSymbol( decl.ide.name, declType, decl.ide.position, currentModule );	
	}
	
	public void typecheckStmCall( StmCall call, Type expectedReturnType ){
	    Type retType = call.e.accept( this );
	    
	    if( expectedReturnType != null && !isVoid(expectedReturnType) )
            throw new StaticAnalysisException( "Function must return a value. Return expected.", call.position );
	    
	    if( !isVoid(retType) )
	        throw new StaticAnalysisException( "Only void functions can be called, "
	                + retType + " found.", call.position );
	}

	
	// #################### EXPRESSIONS ####################
	
	@Override public Type visitExprUnary( ExprUnary e ){
		Type t = e.e.accept( this );
		switch( e.op ){
		case MINUS:
			if( !isInt(t) )
				throw new StaticAnalysisException( "int value expected.", e.e.position );
			break;
			
		case NOT:
			if( !isBoolean(t) )
				throw new StaticAnalysisException( "boolean value expected.", e.e.position );
			break;
		}
		
		return t;
	}

	@Override public Type visitExprBinary( ExprBinary e ){
		Type lt = e.el.accept( this );
		Type rt = e.er.accept( this );
		switch( e.op ){
		case MINUS:
		case PLUS:
		case MULT:
		case MOD:
		case DIV:
			if( !isInt(lt) )
				throw new StaticAnalysisException( "int value expected.", e.el.position );
			if( !isInt(rt) )
				throw new StaticAnalysisException( "int value expected.", e.er.position );
			return TypeInt.getInstance();
			
		case AND:
		case OR:
			if( !isBoolean(lt) )
				throw new StaticAnalysisException( "boolean value expected.", e.el.position );
			if( !isBoolean(rt) )
				throw new StaticAnalysisException( "boolean value expected.", e.er.position );
			return TypeBoolean.getInstance();
			
		case GE:
		case GT:
		case LE:
		case LT:
			if( !isInt(lt) )
				throw new StaticAnalysisException( "int value expected.", e.el.position );
			if( !isInt(rt) )
				throw new StaticAnalysisException( "int value expected.", e.er.position );
			return TypeBoolean.getInstance();
			
		case EQ:
		case NEQ:
			if( isFunction(lt) || isVoid(lt) )
				throw new StaticAnalysisException( "Can't compare " + lt + " values.", e.el.position );
			if( isFunction(rt) || isVoid(rt) )
				throw new StaticAnalysisException( "Can't compare " + rt + " values.", e.er.position );
			if( !lt.equals(rt) )
				throw new StaticAnalysisException( "Comparison operands must have the same "
						+ "type. " + lt + " vs " + rt + " found.", e.position );
			return TypeBoolean.getInstance();
			
		default:
			throw new IllegalArgumentException( "Unknown operator" );
		}	
	}

	@Override public Type visitExprArray( ExprArray e ){
		Type arrType = e.earr.accept( this );
		if( !isArray(arrType) )
			throw new StaticAnalysisException( "Array expected, found " + arrType + ".", e.earr.position );
		
		Type idxType = e.eidx.accept( this );
		if( !isInt(idxType) )
			throw new StaticAnalysisException( "Array indices must be integers.", e.eidx.position );
		
		return ((TypeArray)arrType).stripDimension();
	}

	@Override public Type visitExprNewArray( ExprNewArray e ){
		Type arrType = e.type.accept( this );
		if( !(isInt(arrType) || isBoolean(arrType)) )
			throw new StaticAnalysisException( "Can create array only of type "
					+ "int or boolean, " + arrType + " found.", e.type.position );
		
		for( Expr dim: e.dims ){
			Type t = dim.accept( this );
			if( !isInt(t) )
				throw new StaticAnalysisException( "Array dimensions must be integers.", dim.position );
		}
		
		return new TypeArray( arrType, e.dims.size() );
	}

	@Override public Type visitExprLength( ExprLength e ){
		Type arrType = e.e.accept( this );
		if( !isArray(arrType) )
			throw new StaticAnalysisException( "Lenght can be applied only to arrays, "
					+ arrType + " found.", e.e.position );
		return TypeInt.getInstance();
	}

	@Override public Type visitExprList( ExprList e ){
		Type elementType = e.el.get(0).accept( this );
		for( int i = 1 ; i < e.el.size() ; i++ ){
			Type t = e.el.get(i).accept( this );
			if( !elementType.equals(t) )
				throw new StaticAnalysisException( "Array literal elements must have"
						+ " the same type. First element is " + elementType + " but here"
								+ " we found " + t + ".", e.el.get(i).position );
		}
		return new TypeArray( elementType, 1 );
	}

	@Override public Type visitExprCall( ExprCall e ){
		Type t = e.ide.accept( this );
		if( !isFunction(t) )
			throw new StaticAnalysisException( "Only functions can be called, " +
					t + " found.", e.ide.position );
		TypeFunction funType = (TypeFunction)t;
		
		TypeFunction parametersType = new 
				TypeFunction( TypeVoid.getInstance(), false, new ArrayList<Param>() );
		boolean badArguments = false;
		for( int i = 0 ; i < e.args.el.size() ; i++ ){
			Type paramType = e.args.el.get(i).accept( this );
			parametersType.parameters.add( new Param(null, paramType) );
			if( i >= funType.parameters.size() )
				continue;
			if( !funType.parameters.get(i).type.equals(paramType) )
				badArguments = true;
		}
		if( e.args.el.size() != funType.parameters.size() )
			badArguments = true;
		
		if( badArguments )
			throw new StaticAnalysisException( "Function " + funType
				 + " is not applicable to " + parametersType.toStringParams() + ".", e.ide.position );
		
		return funType.returnType;
	}

	@Override public Type visitExprIde( ExprIde e ){
		Entry eInfo = symtbl.lookup( e.name );
		if( eInfo == null )
			throw new StaticAnalysisException( "Undeclared variable '" + e.name + "'.",
					e.position );
		return eInfo.type;
	}

	@Override public Type visitExprLiteral( ExprLiteral e ){
		switch( e.t ){
		case BOOLEAN: return TypeBoolean.getInstance();
		case INT: return TypeInt.getInstance();
		case STRING: return new TypeArray( TypeInt.getInstance(), 1 );
		default:
			throw new IllegalStateException( "Can't reach this" );
		}
	}
	
	// #################### TYPES ####################

	@Override public Type visitAstTypeArray( AstTypeArray t ){
		Type arrayType = t.t.accept( this );
		return new TypeArray( arrayType, t.dimensions );
	}

	@Override public Type visitAstTypeBoolean( AstTypeBoolean t ){
		return TypeBoolean.getInstance();
	}

	@Override public Type visitAstTypeInteger( AstTypeInteger t ){
		return TypeInt.getInstance();
	}

	
	// #################### Private Methods ####################
	
	private void addTopLevelNamesToSymbolTable( Module m ) throws StaticAnalysisException{
		for( Definition d: m.dl ){
			Entry prev = symtbl.lookup(d.name.name);
			if( prev != null )
				throw new StaticAnalysisException( "Duplicate definition of '" + d.name.name
						+ "' function. Already defined in " + prev.position + ".", d.name.position );
			
			Type retType = d.retType == null ? TypeVoid.getInstance() : d.retType.accept( this );
			List<Param> params = new ArrayList<Param>();
			for( Parameter p: d.params )
				params.add( new Param(p.ide.name, p.t.accept( this )) );
			TypeFunction defType = new TypeFunction( retType, d.b == null, params );
			symtbl.addSymbol( d.name.name, defType, d.name.position, currentModule );
		}
	}
	
	private void bindParameters( List<Parameter> params ){
		for( Parameter p: params ){
			Type paramType = p.t.accept( this );
			Entry prev = symtbl.lookup( p.ide.name );
			if( prev != null )
				throw new StaticAnalysisException( "Duplicate definition of '" + p.ide.name
						+ "' parameter. Already defined in " + prev.position + ".", p.ide.position );
			symtbl.addSymbol( p.ide.name, paramType, p.ide.position, currentModule );
		}
	}	
}
