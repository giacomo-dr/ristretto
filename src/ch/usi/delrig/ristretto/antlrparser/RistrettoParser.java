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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, IDE=23, INT=24, DEC=25, 
		HEX=26, WS=27, LCOMMENT=28, MCOMMENT=29, STRING=30, NOT=31, MINUS=32, 
		MOD=33, DIV=34, MUL=35, PLUS=36, GE=37, GT=38, LE=39, LT=40, NEQ=41, EQ=42, 
		AND=43, OR=44;
	public static final int
		RULE_module = 0, RULE_def = 1, RULE_funHeader = 2, RULE_params = 3, RULE_param = 4, 
		RULE_block = 5, RULE_stm = 6, RULE_type = 7, RULE_exp = 8, RULE_primary = 9, 
		RULE_call = 10, RULE_exps = 11;
	public static final String[] ruleNames = {
		"module", "def", "funHeader", "params", "param", "block", "stm", "type", 
		"exp", "primary", "call", "exps"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'extern'", "';'", "'void'", "'('", "')'", "','", "'{'", "'}'", 
		"'if'", "'else'", "'while'", "'='", "'['", "']'", "'return'", "'int'", 
		"'boolean'", "'new'", "'.'", "'length'", "'true'", "'false'", null, null, 
		null, null, null, null, null, null, "'!'", "'-'", "'%'", "'/'", "'*'", 
		"'+'", "'>='", "'>'", "'<='", "'<'", "'!='", "'=='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "IDE", 
		"INT", "DEC", "HEX", "WS", "LCOMMENT", "MCOMMENT", "STRING", "NOT", "MINUS", 
		"MOD", "DIV", "MUL", "PLUS", "GE", "GT", "LE", "LT", "NEQ", "EQ", "AND", 
		"OR"
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
	public static class ModuleContext extends ParserRuleContext {
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				def();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__15) | (1L << T__16))) != 0) );
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
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	 
		public DefContext() { }
		public void copyFrom(DefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefBlockContext extends DefContext {
		public FunHeaderContext funHeader() {
			return getRuleContext(FunHeaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DefBlockContext(DefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitDefBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefExternContext extends DefContext {
		public FunHeaderContext funHeader() {
			return getRuleContext(FunHeaderContext.class,0);
		}
		public DefExternContext(DefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitDefExtern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__15:
			case T__16:
				_localctx = new DefBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				funHeader();
				setState(30);
				block();
				}
				break;
			case T__0:
				_localctx = new DefExternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				match(T__0);
				setState(33);
				funHeader();
				setState(34);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FunHeaderContext extends ParserRuleContext {
		public TerminalNode IDE() { return getToken(RistrettoParser.IDE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funHeader; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitFunHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunHeaderContext funHeader() throws RecognitionException {
		FunHeaderContext _localctx = new FunHeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__16:
				{
				setState(38);
				type(0);
				}
				break;
			case T__2:
				{
				setState(39);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(42);
			match(IDE);
			setState(43);
			match(T__3);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15 || _la==T__16) {
				{
				setState(44);
				params();
				}
			}

			setState(47);
			match(T__4);
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
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			param();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(50);
				match(T__5);
				setState(51);
				param();
				}
				}
				setState(56);
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
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			type(0);
			setState(58);
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
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__6);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << IDE) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				{
				setState(61);
				stm();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(T__7);
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
		enterRule(_localctx, 12, RULE_stm);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new StmIfElseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(T__8);
				setState(70);
				match(T__3);
				setState(71);
				exp(0);
				setState(72);
				match(T__4);
				setState(73);
				stm();
				setState(74);
				match(T__9);
				setState(75);
				stm();
				}
				break;
			case 2:
				_localctx = new StmIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__8);
				setState(78);
				match(T__3);
				setState(79);
				exp(0);
				setState(80);
				match(T__4);
				setState(81);
				stm();
				}
				break;
			case 3:
				_localctx = new StmWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(T__10);
				setState(84);
				match(T__3);
				setState(85);
				exp(0);
				setState(86);
				match(T__4);
				setState(87);
				stm();
				}
				break;
			case 4:
				_localctx = new StmAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				match(IDE);
				setState(90);
				match(T__11);
				setState(91);
				exp(0);
				setState(92);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new StmAssignArrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				primary(0);
				setState(95);
				match(T__12);
				setState(96);
				exp(0);
				setState(97);
				match(T__13);
				setState(98);
				match(T__11);
				setState(99);
				exp(0);
				setState(100);
				match(T__1);
				}
				break;
			case 6:
				_localctx = new StmReturnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				match(T__14);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << IDE) | (1L << INT) | (1L << STRING) | (1L << NOT) | (1L << MINUS))) != 0)) {
					{
					setState(103);
					exp(0);
					}
				}

				setState(106);
				match(T__1);
				}
				break;
			case 7:
				_localctx = new StmDeclareContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(107);
				type(0);
				setState(108);
				match(IDE);
				setState(109);
				match(T__11);
				setState(110);
				exp(0);
				setState(111);
				match(T__1);
				}
				break;
			case 8:
				_localctx = new StmCallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(113);
				call();
				setState(114);
				match(T__1);
				}
				break;
			case 9:
				_localctx = new StmBlockContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(116);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				_localctx = new TypeIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(120);
				match(T__15);
				}
				break;
			case T__16:
				{
				_localctx = new TypeBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeArrayContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(124);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(125);
					match(T__12);
					setState(126);
					match(T__13);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__6:
			case T__17:
			case T__20:
			case T__21:
			case IDE:
			case INT:
			case STRING:
				{
				_localctx = new ExpPrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(133);
				primary(0);
				}
				break;
			case NOT:
			case MINUS:
				{
				_localctx = new ExpUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
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
				setState(135);
				exp(6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpModDivMulContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(138);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(139);
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
						setState(140);
						exp(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpPlusMinusContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(141);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(142);
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
						setState(143);
						exp(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpGtLtContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(144);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(145);
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
						setState(146);
						exp(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpEqNeqContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(147);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(148);
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
						setState(149);
						exp(3);
						}
						break;
					case 5:
						{
						_localctx = new ExpAndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(150);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(151);
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
						setState(152);
						exp(2);
						}
						break;
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class ExpNewArrayContext extends PrimaryContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpNewArrayContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RistrettoVisitor ) return ((RistrettoVisitor<? extends T>)visitor).visitExpNewArray(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new ExpNewArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(159);
				match(T__17);
				setState(160);
				type(0);
				setState(165); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(161);
						match(T__12);
						setState(162);
						exp(0);
						setState(163);
						match(T__13);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(167); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				_localctx = new ExpListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__6);
				setState(170);
				exps();
				setState(171);
				match(T__7);
				}
				break;
			case 3:
				{
				_localctx = new ExpParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(T__3);
				setState(174);
				exp(0);
				setState(175);
				match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new ExpCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				call();
				}
				break;
			case 5:
				{
				_localctx = new ExpIdeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(IDE);
				}
				break;
			case 6:
				{
				_localctx = new ExpLitBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				((ExpLitBoolContext)_localctx).val = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
					((ExpLitBoolContext)_localctx).val = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 7:
				{
				_localctx = new ExpLitStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExpLitIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(192);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpArrayContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(184);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(185);
						match(T__12);
						setState(186);
						exp(0);
						setState(187);
						match(T__13);
						}
						break;
					case 2:
						{
						_localctx = new ExpLengthContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(189);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(190);
						match(T__18);
						setState(191);
						match(T__19);
						}
						break;
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 20, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IDE);
			setState(198);
			match(T__3);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << IDE) | (1L << INT) | (1L << STRING) | (1L << NOT) | (1L << MINUS))) != 0)) {
				{
				setState(199);
				exps();
				}
			}

			setState(202);
			match(T__4);
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
		enterRule(_localctx, 22, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			exp(0);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(205);
				match(T__5);
				setState(206);
				exp(0);
				}
				}
				setState(211);
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
		case 7:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 8:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 9:
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
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u00d7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\'\n\3\3\4\3\4\5\4+\n\4\3\4\3\4\3\4\5\4\60\n\4\3\4\3\4\3\5\3\5"+
		"\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\6\3\6\3\6\3\7\3\7\7\7A\n\7\f\7\16\7D"+
		"\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bk\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bx\n\b\3\t\3\t\3\t\5\t}\n\t\3\t\3\t\3\t\7\t\u0082\n\t\f\t\16\t\u0085"+
		"\13\t\3\n\3\n\3\n\3\n\5\n\u008b\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u009c\n\n\f\n\16\n\u009f\13\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\6\13\u00a8\n\13\r\13\16\13\u00a9\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b9\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00c3\n\13\f\13\16\13\u00c6"+
		"\13\13\3\f\3\f\3\f\5\f\u00cb\n\f\3\f\3\f\3\r\3\r\3\r\7\r\u00d2\n\r\f\r"+
		"\16\r\u00d5\13\r\3\r\2\5\20\22\24\16\2\4\6\b\n\f\16\20\22\24\26\30\2\t"+
		"\3\2!\"\3\2#%\4\2\"\"&&\3\2\'*\3\2+,\3\2-.\3\2\27\30\u00ed\2\33\3\2\2"+
		"\2\4&\3\2\2\2\6*\3\2\2\2\b\63\3\2\2\2\n;\3\2\2\2\f>\3\2\2\2\16w\3\2\2"+
		"\2\20|\3\2\2\2\22\u008a\3\2\2\2\24\u00b8\3\2\2\2\26\u00c7\3\2\2\2\30\u00ce"+
		"\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36"+
		"\3\2\2\2\36\3\3\2\2\2\37 \5\6\4\2 !\5\f\7\2!\'\3\2\2\2\"#\7\3\2\2#$\5"+
		"\6\4\2$%\7\4\2\2%\'\3\2\2\2&\37\3\2\2\2&\"\3\2\2\2\'\5\3\2\2\2(+\5\20"+
		"\t\2)+\7\5\2\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,-\7\31\2\2-/\7\6\2\2.\60"+
		"\5\b\5\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\7\2\2\62\7\3\2\2"+
		"\2\638\5\n\6\2\64\65\7\b\2\2\65\67\5\n\6\2\66\64\3\2\2\2\67:\3\2\2\28"+
		"\66\3\2\2\289\3\2\2\29\t\3\2\2\2:8\3\2\2\2;<\5\20\t\2<=\7\31\2\2=\13\3"+
		"\2\2\2>B\7\t\2\2?A\5\16\b\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE"+
		"\3\2\2\2DB\3\2\2\2EF\7\n\2\2F\r\3\2\2\2GH\7\13\2\2HI\7\6\2\2IJ\5\22\n"+
		"\2JK\7\7\2\2KL\5\16\b\2LM\7\f\2\2MN\5\16\b\2Nx\3\2\2\2OP\7\13\2\2PQ\7"+
		"\6\2\2QR\5\22\n\2RS\7\7\2\2ST\5\16\b\2Tx\3\2\2\2UV\7\r\2\2VW\7\6\2\2W"+
		"X\5\22\n\2XY\7\7\2\2YZ\5\16\b\2Zx\3\2\2\2[\\\7\31\2\2\\]\7\16\2\2]^\5"+
		"\22\n\2^_\7\4\2\2_x\3\2\2\2`a\5\24\13\2ab\7\17\2\2bc\5\22\n\2cd\7\20\2"+
		"\2de\7\16\2\2ef\5\22\n\2fg\7\4\2\2gx\3\2\2\2hj\7\21\2\2ik\5\22\n\2ji\3"+
		"\2\2\2jk\3\2\2\2kl\3\2\2\2lx\7\4\2\2mn\5\20\t\2no\7\31\2\2op\7\16\2\2"+
		"pq\5\22\n\2qr\7\4\2\2rx\3\2\2\2st\5\26\f\2tu\7\4\2\2ux\3\2\2\2vx\5\f\7"+
		"\2wG\3\2\2\2wO\3\2\2\2wU\3\2\2\2w[\3\2\2\2w`\3\2\2\2wh\3\2\2\2wm\3\2\2"+
		"\2ws\3\2\2\2wv\3\2\2\2x\17\3\2\2\2yz\b\t\1\2z}\7\22\2\2{}\7\23\2\2|y\3"+
		"\2\2\2|{\3\2\2\2}\u0083\3\2\2\2~\177\f\5\2\2\177\u0080\7\17\2\2\u0080"+
		"\u0082\7\20\2\2\u0081~\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\21\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087"+
		"\b\n\1\2\u0087\u008b\5\24\13\2\u0088\u0089\t\2\2\2\u0089\u008b\5\22\n"+
		"\b\u008a\u0086\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u009d\3\2\2\2\u008c\u008d"+
		"\f\7\2\2\u008d\u008e\t\3\2\2\u008e\u009c\5\22\n\b\u008f\u0090\f\6\2\2"+
		"\u0090\u0091\t\4\2\2\u0091\u009c\5\22\n\7\u0092\u0093\f\5\2\2\u0093\u0094"+
		"\t\5\2\2\u0094\u009c\5\22\n\6\u0095\u0096\f\4\2\2\u0096\u0097\t\6\2\2"+
		"\u0097\u009c\5\22\n\5\u0098\u0099\f\3\2\2\u0099\u009a\t\7\2\2\u009a\u009c"+
		"\5\22\n\4\u009b\u008c\3\2\2\2\u009b\u008f\3\2\2\2\u009b\u0092\3\2\2\2"+
		"\u009b\u0095\3\2\2\2\u009b\u0098\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\23\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a1\b\13\1\2\u00a1\u00a2\7\24\2\2\u00a2\u00a7\5\20\t\2\u00a3\u00a4"+
		"\7\17\2\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\7\20\2\2\u00a6\u00a8\3\2\2"+
		"\2\u00a7\u00a3\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00b9\3\2\2\2\u00ab\u00ac\7\t\2\2\u00ac\u00ad\5\30\r\2"+
		"\u00ad\u00ae\7\n\2\2\u00ae\u00b9\3\2\2\2\u00af\u00b0\7\6\2\2\u00b0\u00b1"+
		"\5\22\n\2\u00b1\u00b2\7\7\2\2\u00b2\u00b9\3\2\2\2\u00b3\u00b9\5\26\f\2"+
		"\u00b4\u00b9\7\31\2\2\u00b5\u00b9\t\b\2\2\u00b6\u00b9\7 \2\2\u00b7\u00b9"+
		"\7\32\2\2\u00b8\u00a0\3\2\2\2\u00b8\u00ab\3\2\2\2\u00b8\u00af\3\2\2\2"+
		"\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00c4\3\2\2\2\u00ba\u00bb\f\f\2\2\u00bb"+
		"\u00bc\7\17\2\2\u00bc\u00bd\5\22\n\2\u00bd\u00be\7\20\2\2\u00be\u00c3"+
		"\3\2\2\2\u00bf\u00c0\f\n\2\2\u00c0\u00c1\7\25\2\2\u00c1\u00c3\7\26\2\2"+
		"\u00c2\u00ba\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\25\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7"+
		"\u00c8\7\31\2\2\u00c8\u00ca\7\6\2\2\u00c9\u00cb\5\30\r\2\u00ca\u00c9\3"+
		"\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7\7\2\2\u00cd"+
		"\27\3\2\2\2\u00ce\u00d3\5\22\n\2\u00cf\u00d0\7\b\2\2\u00d0\u00d2\5\22"+
		"\n\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\31\3\2\2\2\u00d5\u00d3\3\2\2\2\25\35&*/8Bjw|\u0083"+
		"\u008a\u009b\u009d\u00a9\u00b8\u00c2\u00c4\u00ca\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}