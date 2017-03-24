// Generated from ./grammar/Ristretto.g4 by ANTLR 4.6

	package ch.usi.delrig.ristretto.antlrparser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RistrettoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, IDE=21, INT=22, DEC=23, HEX=24, WS=25, LCOMMENT=26, 
		MCOMMENT=27, STRING=28, NOT=29, MINUS=30, MOD=31, DIV=32, MUL=33, PLUS=34, 
		GE=35, GT=36, LE=37, LT=38, NEQ=39, EQ=40, AND=41, OR=42;
	public static final int
		RULE_program = 0, RULE_def = 1, RULE_params = 2, RULE_param = 3, RULE_block = 4, 
		RULE_stm = 5, RULE_type = 6, RULE_exp = 7, RULE_primary = 8, RULE_call = 9, 
		RULE_exps = 10;
	public static final String[] ruleNames = {
		"program", "def", "params", "param", "block", "stm", "type", "exp", "primary", 
		"call", "exps"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'void'", "'('", "')'", "','", "'{'", "'}'", "'if'", "'else'", "'while'", 
		"'='", "';'", "'['", "']'", "'return'", "'int'", "'boolean'", "'.'", "'length'", 
		"'true'", "'false'", null, null, null, null, null, null, null, null, "'!'", 
		"'-'", "'%'", "'/'", "'*'", "'+'", "'>='", "'>'", "'<='", "'<'", "'!='", 
		"'=='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "IDE", "INT", "DEC", 
		"HEX", "WS", "LCOMMENT", "MCOMMENT", "STRING", "NOT", "MINUS", "MOD", 
		"DIV", "MUL", "PLUS", "GE", "GT", "LE", "LT", "NEQ", "EQ", "AND", "OR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Ristretto.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RistrettoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				def();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefContext extends ParserRuleContext {
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
				{
				setState(27);
				type(0);
				}
				break;
			case T__0:
				{
				setState(28);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(31);
			match(IDE);
			setState(32);
			match(T__1);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14 || _la==T__15) {
				{
				setState(33);
				params();
				}
			}

			setState(36);
			match(T__2);
			setState(37);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			param();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(40);
				match(T__3);
				setState(41);
				param();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			type(0);
			setState(48);
			match(IDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__4);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << IDE) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				{
				setState(51);
				stm();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmContext extends ParserRuleContext {
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
	 
		public StmContext() { }
		public void copyFrom(StmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmDeclareContext extends StmContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmDeclareContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmAssignArrContext extends StmContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public StmAssignArrContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmAssignArr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmBlockContext extends StmContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StmBlockContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmWhileContext extends StmContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public StmWhileContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmIfElseContext extends StmContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public StmIfElseContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmCallContext extends StmContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public StmCallContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmIfContext extends StmContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public StmIfContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmReturnContext extends StmContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmReturnContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmAssignContext extends StmContext {
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmAssignContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitStmAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stm);
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new StmIfElseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(T__6);
				setState(60);
				match(T__1);
				setState(61);
				exp(0);
				setState(62);
				match(T__2);
				setState(63);
				stm();
				setState(64);
				match(T__7);
				setState(65);
				stm();
				}
				break;
			case 2:
				_localctx = new StmIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(T__6);
				setState(68);
				match(T__1);
				setState(69);
				exp(0);
				setState(70);
				match(T__2);
				setState(71);
				stm();
				}
				break;
			case 3:
				_localctx = new StmWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(T__8);
				setState(74);
				match(T__1);
				setState(75);
				exp(0);
				setState(76);
				match(T__2);
				setState(77);
				stm();
				}
				break;
			case 4:
				_localctx = new StmAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(IDE);
				setState(80);
				match(T__9);
				setState(81);
				exp(0);
				setState(82);
				match(T__10);
				}
				break;
			case 5:
				_localctx = new StmAssignArrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				primary(0);
				setState(85);
				match(T__11);
				setState(86);
				exp(0);
				setState(87);
				match(T__12);
				setState(88);
				match(T__9);
				setState(89);
				exp(0);
				setState(90);
				match(T__10);
				}
				break;
			case 6:
				_localctx = new StmReturnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				match(T__13);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__18) | (1L << T__19) | (1L << IDE) | (1L << INT) | (1L << STRING) | (1L << NOT) | (1L << MINUS))) != 0)) {
					{
					setState(93);
					exp(0);
					}
				}

				setState(96);
				match(T__10);
				}
				break;
			case 7:
				_localctx = new StmDeclareContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(97);
				type(0);
				setState(98);
				match(IDE);
				setState(99);
				match(T__9);
				setState(100);
				exp(0);
				setState(101);
				match(T__10);
				}
				break;
			case 8:
				_localctx = new StmCallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				call();
				setState(104);
				match(T__10);
				}
				break;
			case 9:
				_localctx = new StmBlockContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeArrayContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitTypeArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeBooleanContext extends TypeContext {
		public TypeBooleanContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitTypeBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIntContext extends TypeContext {
		public TypeIntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				_localctx = new TypeIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(110);
				match(T__14);
				}
				break;
			case T__15:
				{
				_localctx = new TypeBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeArrayContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(114);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(115);
					match(T__11);
					setState(116);
					match(T__12);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpPlusMinusContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpPlusMinusContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPrimaryContext extends ExpContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpPrimaryContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpModDivMulContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpModDivMulContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpModDivMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpGtLtContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpGtLtContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpGtLt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpEqNeqContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpEqNeqContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpEqNeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpUnaryContext extends ExpContext {
		public Token op;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpUnaryContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAndOrContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpAndOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpAndOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__4:
			case T__18:
			case T__19:
			case IDE:
			case INT:
			case STRING:
				{
				_localctx = new ExpPrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(123);
				primary(0);
				}
				break;
			case NOT:
			case MINUS:
				{
				_localctx = new ExpUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				((ExpUnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
					((ExpUnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(125);
				exp(6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(143);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpModDivMulContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(128);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(129);
						((ExpModDivMulContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << DIV) | (1L << MUL))) != 0)) ) {
							((ExpModDivMulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						exp(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpPlusMinusContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(131);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(132);
						((ExpPlusMinusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((ExpPlusMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
						exp(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpGtLtContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(134);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(135);
						((ExpGtLtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << GT) | (1L << LE) | (1L << LT))) != 0)) ) {
							((ExpGtLtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						exp(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpEqNeqContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(137);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(138);
						((ExpEqNeqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NEQ || _la==EQ) ) {
							((ExpEqNeqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(139);
						exp(3);
						}
						break;
					case 5:
						{
						_localctx = new ExpAndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(140);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(141);
						((ExpAndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((ExpAndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						exp(2);
						}
						break;
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpIdeContext extends PrimaryContext {
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public ExpIdeContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpIde(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpLitIntContext extends PrimaryContext {
		public TerminalNode INT() { return getToken(RistrettoParser.INT, 0); }
		public ExpLitIntContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpLitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCallContext extends PrimaryContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ExpCallContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpArrayContext extends PrimaryContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpArrayContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpListContext extends PrimaryContext {
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public ExpListContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpLitStringContext extends PrimaryContext {
		public TerminalNode STRING() { return getToken(RistrettoParser.STRING, 0); }
		public ExpLitStringContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpLitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParenContext extends PrimaryContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpLitBoolContext extends PrimaryContext {
		public Token val;
		public ExpLitBoolContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpLitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpLengthContext extends PrimaryContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpLengthContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		return primary(0);
	}

	private PrimaryContext primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryContext _localctx = new PrimaryContext(_ctx, _parentState);
		PrimaryContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new ExpListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(149);
				match(T__4);
				setState(150);
				exps();
				setState(151);
				match(T__5);
				}
				break;
			case 2:
				{
				_localctx = new ExpParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(T__1);
				setState(154);
				exp(0);
				setState(155);
				match(T__2);
				}
				break;
			case 3:
				{
				_localctx = new ExpCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				call();
				}
				break;
			case 4:
				{
				_localctx = new ExpIdeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(IDE);
				}
				break;
			case 5:
				{
				_localctx = new ExpLitBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				((ExpLitBoolContext)_localctx).val = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
					((ExpLitBoolContext)_localctx).val = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 6:
				{
				_localctx = new ExpLitStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new ExpLitIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpArrayContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(164);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(165);
						match(T__11);
						setState(166);
						exp(0);
						setState(167);
						match(T__12);
						}
						break;
					case 2:
						{
						_localctx = new ExpLengthContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(169);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(170);
						match(T__16);
						setState(171);
						match(T__17);
						}
						break;
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(IDE);
			setState(178);
			match(T__1);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__18) | (1L << T__19) | (1L << IDE) | (1L << INT) | (1L << STRING) | (1L << NOT) | (1L << MINUS))) != 0)) {
				{
				setState(179);
				exps();
				}
			}

			setState(182);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			exp(0);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(185);
				match(T__3);
				setState(186);
				exp(0);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 7:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 8:
			return primary_sempred((PrimaryContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primary_sempred(PrimaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u00c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\5\3 \n\3\3\3\3\3\3\3\5"+
		"\3%\n\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\5\3\5\3\5"+
		"\3\6\3\6\7\6\67\n\6\f\6\16\6:\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7a\n\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7n\n\7\3\b\3\b\3\b\5\bs\n\b\3\b\3\b\3\b\7"+
		"\bx\n\b\f\b\16\b{\13\b\3\t\3\t\3\t\3\t\5\t\u0081\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0092\n\t\f\t\16\t\u0095"+
		"\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a5"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00af\n\n\f\n\16\n\u00b2\13\n"+
		"\3\13\3\13\3\13\5\13\u00b7\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u00be\n\f\f"+
		"\f\16\f\u00c1\13\f\3\f\2\5\16\20\22\r\2\4\6\b\n\f\16\20\22\24\26\2\t\3"+
		"\2\37 \3\2!#\4\2  $$\3\2%(\3\2)*\3\2+,\3\2\25\26\u00d7\2\31\3\2\2\2\4"+
		"\37\3\2\2\2\6)\3\2\2\2\b\61\3\2\2\2\n\64\3\2\2\2\fm\3\2\2\2\16r\3\2\2"+
		"\2\20\u0080\3\2\2\2\22\u00a4\3\2\2\2\24\u00b3\3\2\2\2\26\u00ba\3\2\2\2"+
		"\30\32\5\4\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2"+
		"\34\3\3\2\2\2\35 \5\16\b\2\36 \7\3\2\2\37\35\3\2\2\2\37\36\3\2\2\2 !\3"+
		"\2\2\2!\"\7\27\2\2\"$\7\4\2\2#%\5\6\4\2$#\3\2\2\2$%\3\2\2\2%&\3\2\2\2"+
		"&\'\7\5\2\2\'(\5\n\6\2(\5\3\2\2\2).\5\b\5\2*+\7\6\2\2+-\5\b\5\2,*\3\2"+
		"\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60.\3\2\2\2\61\62\5\16"+
		"\b\2\62\63\7\27\2\2\63\t\3\2\2\2\648\7\7\2\2\65\67\5\f\7\2\66\65\3\2\2"+
		"\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\b\2\2<\13"+
		"\3\2\2\2=>\7\t\2\2>?\7\4\2\2?@\5\20\t\2@A\7\5\2\2AB\5\f\7\2BC\7\n\2\2"+
		"CD\5\f\7\2Dn\3\2\2\2EF\7\t\2\2FG\7\4\2\2GH\5\20\t\2HI\7\5\2\2IJ\5\f\7"+
		"\2Jn\3\2\2\2KL\7\13\2\2LM\7\4\2\2MN\5\20\t\2NO\7\5\2\2OP\5\f\7\2Pn\3\2"+
		"\2\2QR\7\27\2\2RS\7\f\2\2ST\5\20\t\2TU\7\r\2\2Un\3\2\2\2VW\5\22\n\2WX"+
		"\7\16\2\2XY\5\20\t\2YZ\7\17\2\2Z[\7\f\2\2[\\\5\20\t\2\\]\7\r\2\2]n\3\2"+
		"\2\2^`\7\20\2\2_a\5\20\t\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bn\7\r\2\2cd\5"+
		"\16\b\2de\7\27\2\2ef\7\f\2\2fg\5\20\t\2gh\7\r\2\2hn\3\2\2\2ij\5\24\13"+
		"\2jk\7\r\2\2kn\3\2\2\2ln\5\n\6\2m=\3\2\2\2mE\3\2\2\2mK\3\2\2\2mQ\3\2\2"+
		"\2mV\3\2\2\2m^\3\2\2\2mc\3\2\2\2mi\3\2\2\2ml\3\2\2\2n\r\3\2\2\2op\b\b"+
		"\1\2ps\7\21\2\2qs\7\22\2\2ro\3\2\2\2rq\3\2\2\2sy\3\2\2\2tu\f\5\2\2uv\7"+
		"\16\2\2vx\7\17\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\17\3\2\2\2"+
		"{y\3\2\2\2|}\b\t\1\2}\u0081\5\22\n\2~\177\t\2\2\2\177\u0081\5\20\t\b\u0080"+
		"|\3\2\2\2\u0080~\3\2\2\2\u0081\u0093\3\2\2\2\u0082\u0083\f\7\2\2\u0083"+
		"\u0084\t\3\2\2\u0084\u0092\5\20\t\b\u0085\u0086\f\6\2\2\u0086\u0087\t"+
		"\4\2\2\u0087\u0092\5\20\t\7\u0088\u0089\f\5\2\2\u0089\u008a\t\5\2\2\u008a"+
		"\u0092\5\20\t\6\u008b\u008c\f\4\2\2\u008c\u008d\t\6\2\2\u008d\u0092\5"+
		"\20\t\5\u008e\u008f\f\3\2\2\u008f\u0090\t\7\2\2\u0090\u0092\5\20\t\4\u0091"+
		"\u0082\3\2\2\2\u0091\u0085\3\2\2\2\u0091\u0088\3\2\2\2\u0091\u008b\3\2"+
		"\2\2\u0091\u008e\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\21\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\b\n\1"+
		"\2\u0097\u0098\7\7\2\2\u0098\u0099\5\26\f\2\u0099\u009a\7\b\2\2\u009a"+
		"\u00a5\3\2\2\2\u009b\u009c\7\4\2\2\u009c\u009d\5\20\t\2\u009d\u009e\7"+
		"\5\2\2\u009e\u00a5\3\2\2\2\u009f\u00a5\5\24\13\2\u00a0\u00a5\7\27\2\2"+
		"\u00a1\u00a5\t\b\2\2\u00a2\u00a5\7\36\2\2\u00a3\u00a5\7\30\2\2\u00a4\u0096"+
		"\3\2\2\2\u00a4\u009b\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a4"+
		"\u00a1\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00b0\3\2"+
		"\2\2\u00a6\u00a7\f\13\2\2\u00a7\u00a8\7\16\2\2\u00a8\u00a9\5\20\t\2\u00a9"+
		"\u00aa\7\17\2\2\u00aa\u00af\3\2\2\2\u00ab\u00ac\f\n\2\2\u00ac\u00ad\7"+
		"\23\2\2\u00ad\u00af\7\24\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af"+
		"\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\23\3\2\2"+
		"\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7\27\2\2\u00b4\u00b6\7\4\2\2\u00b5"+
		"\u00b7\5\26\f\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3"+
		"\2\2\2\u00b8\u00b9\7\5\2\2\u00b9\25\3\2\2\2\u00ba\u00bf\5\20\t\2\u00bb"+
		"\u00bc\7\6\2\2\u00bc\u00be\5\20\t\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3"+
		"\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\27\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\23\33\37$.8`mry\u0080\u0091\u0093\u00a4\u00ae\u00b0\u00b6"+
		"\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}