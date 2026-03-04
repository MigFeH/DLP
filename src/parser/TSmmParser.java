// Generated from C:/Users/uo287577/Desktop/DLP/Sesion 03/Proyecto/src/parser/TSmm.g4 by ANTLR 4.13.2
package parser;
 // para meter todos los imports
import ast.*;
import ast.expresiones.*;
import ast.definiciones.*;
import ast.tipos.*;
import ast.sentencia.*;
import errorhandler.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TSmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, WHITE_SPACES=40, INT_CONSTANT=41, REAL_CONSTANT=42, CHAR_CONSTANT=43, 
		COMENTARIO_UNILINEA=44, COMENTARIO_MULTILINEA=45, ID=46;
	public static final int
		RULE_program = 0, RULE_main_function_definition = 1, RULE_expression = 2, 
		RULE_statement = 3, RULE_cuerpo_condicional = 4, RULE_tipo_simple = 5, 
		RULE_tipo = 6, RULE_var_definition = 7, RULE_function_definition = 8, 
		RULE_function_type = 9, RULE_function_param = 10, RULE_function_return_type = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main_function_definition", "expression", "statement", "cuerpo_condicional", 
			"tipo_simple", "tipo", "var_definition", "function_definition", "function_type", 
			"function_param", "function_return_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'main'", "'('", "')'", "':'", "'void'", "'{'", "'}'", 
			"'['", "']'", "'.'", "'as'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", 
			"'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", "','", 
			"'log'", "';'", "'input'", "'='", "'if'", "'else'", "'while'", "'return'", 
			"'int'", "'number'", "'char'", "'let'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "WHITE_SPACES", "INT_CONSTANT", "REAL_CONSTANT", 
			"CHAR_CONSTANT", "COMENTARIO_UNILINEA", "COMENTARIO_MULTILINEA", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "TSmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TSmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Programa ast;
		public List<Definicion> defs = new ArrayList<>();
		public Var_definitionContext var_definition;
		public Function_definitionContext function_definition;
		public Main_function_definitionContext main;
		public TerminalNode EOF() { return getToken(TSmmParser.EOF, 0); }
		public Main_function_definitionContext main_function_definition() {
			return getRuleContext(Main_function_definitionContext.class,0);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(30);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__38:
						{
						setState(24);
						((ProgramContext)_localctx).var_definition = var_definition();
						 _localctx.defs.addAll(((ProgramContext)_localctx).var_definition.ast); 
						}
						break;
					case T__0:
						{
						setState(27);
						((ProgramContext)_localctx).function_definition = function_definition();
						 _localctx.defs.add(((ProgramContext)_localctx).function_definition.ast); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(35);
			((ProgramContext)_localctx).main = main_function_definition();
			setState(36);
			match(EOF);

			                _localctx.defs.add(((ProgramContext)_localctx).main.ast);
			                ((ProgramContext)_localctx).ast =  new Programa(_localctx.defs);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class Main_function_definitionContext extends ParserRuleContext {
		public DefinicionFunc ast;
		public List<DefinicionVar> parametros = new ArrayList<>();
		public List<DefinicionVar> definicionesVariables = new ArrayList<>();
		public List<Sentencia> sentencias = new ArrayList<>();
		public Token START;
		public Var_definitionContext var_definition;
		public StatementContext statement;
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Main_function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_function_definition; }
	}

	public final Main_function_definitionContext main_function_definition() throws RecognitionException {
		Main_function_definitionContext _localctx = new Main_function_definitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((Main_function_definitionContext)_localctx).START = match(T__0);
			setState(40);
			match(T__1);
			setState(41);
			match(T__2);
			setState(42);
			match(T__3);
			setState(43);
			match(T__4);
			setState(44);
			match(T__5);
			setState(45);
			match(T__6);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38) {
				{
				{
				setState(46);
				((Main_function_definitionContext)_localctx).var_definition = var_definition();
				 _localctx.definicionesVariables.addAll(((Main_function_definitionContext)_localctx).var_definition.ast); 
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 85819083743240L) != 0)) {
				{
				{
				setState(54);
				((Main_function_definitionContext)_localctx).statement = statement();
				 _localctx.sentencias.add(((Main_function_definitionContext)_localctx).statement.ast); 
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__7);

			                ((Main_function_definitionContext)_localctx).ast =  new DefinicionFunc(
			                    ((Main_function_definitionContext)_localctx).START.getLine(),
			                    ((Main_function_definitionContext)_localctx).START.getCharPositionInLine() + 1,
			                    new TipoFuncion(TipoVoid.getInstance(), _localctx.parametros),
			                    "main",
			                    _localctx.definicionesVariables,
			                    _localctx.sentencias);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expresion ast;
		public Variable variable;
		public List<Expresion> argumentos;
		public ExpressionContext e1;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token ID;
		public ExpressionContext expression;
		public Tipo_simpleContext tipo_simple;
		public ExpressionContext e2;
		public Token OP;
		public TerminalNode INT_CONSTANT() { return getToken(TSmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(TSmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(TSmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(66);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);

				                ((ExpressionContext)_localctx).ast =  new ConstanteInt(
				                    ((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
				                    ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1,
				                    LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				            
				}
				break;
			case 2:
				{
				setState(68);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);

				                ((ExpressionContext)_localctx).ast =  new ConstanteReal(
				                    ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
				                    ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1,
				                    LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				            
				}
				break;
			case 3:
				{
				setState(70);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);

				                ((ExpressionContext)_localctx).ast =  new ConstanteCaracter(
				                    ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
				                    ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1,
				                    LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				            
				}
				break;
			case 4:
				{
				setState(72);
				((ExpressionContext)_localctx).ID = match(ID);

				                ((ExpressionContext)_localctx).ast =  new Variable(
				                    ((ExpressionContext)_localctx).ID.getLine(),
				                    ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                    (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				            
				}
				break;
			case 5:
				{
				setState(74);
				match(T__2);
				setState(75);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(76);
				match(T__3);

				                ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast;
				            
				}
				break;
			case 6:
				{
				setState(79);
				match(T__2);
				setState(80);
				((ExpressionContext)_localctx).e1 = ((ExpressionContext)_localctx).expression = expression(0);
				setState(81);
				match(T__11);
				setState(82);
				((ExpressionContext)_localctx).tipo_simple = tipo_simple();
				setState(83);
				match(T__3);

				                ((ExpressionContext)_localctx).ast =  new Cast(
				                    ((ExpressionContext)_localctx).e1.ast.getLinea(),
				                    ((ExpressionContext)_localctx).e1.ast.getColumna(),
				                    ((ExpressionContext)_localctx).e1.ast,
				                    ((ExpressionContext)_localctx).tipo_simple.ast);
				            
				}
				break;
			case 7:
				{
				setState(86);
				match(T__12);
				setState(87);
				((ExpressionContext)_localctx).expression = expression(7);

				                ((ExpressionContext)_localctx).ast =  new MenosUnario(
				                    ((ExpressionContext)_localctx).expression.ast.getLinea(),
				                    ((ExpressionContext)_localctx).expression.ast.getColumna(),
				                    ((ExpressionContext)_localctx).expression.ast);
				            
				}
				break;
			case 8:
				{
				setState(90);
				match(T__13);
				setState(91);
				((ExpressionContext)_localctx).expression = expression(6);

				                ((ExpressionContext)_localctx).ast =  new Negacion(
				                    ((ExpressionContext)_localctx).expression.ast.getLinea(),
				                    ((ExpressionContext)_localctx).expression.ast.getColumna(),
				                    ((ExpressionContext)_localctx).expression.ast);
				            
				}
				break;
			case 9:
				{
				setState(94);
				((ExpressionContext)_localctx).ID = match(ID);

				                ((ExpressionContext)_localctx).variable =  new Variable(
				                    ((ExpressionContext)_localctx).ID.getLine(),
				                    ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                    (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));

				                ((ExpressionContext)_localctx).argumentos =  new ArrayList<>();
				            
				setState(96);
				match(T__2);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 85761906991112L) != 0)) {
					{
					setState(103);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(97);
							((ExpressionContext)_localctx).e1 = ((ExpressionContext)_localctx).expression = expression(0);
							setState(98);
							match(T__26);
							 _localctx.argumentos.add(((ExpressionContext)_localctx).e1.ast); 
							}
							} 
						}
						setState(105);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					}
					setState(106);
					((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
					 _localctx.argumentos.add(((ExpressionContext)_localctx).e2.ast); 
					}
				}

				setState(111);
				match(T__3);

				                ((ExpressionContext)_localctx).ast =  new Invocacion(
				                    ((ExpressionContext)_localctx).e1.ast.getLinea(),
				                    ((ExpressionContext)_localctx).e1.ast.getColumna(),
				                    _localctx.variable,
				                    _localctx.argumentos);
				            
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(145);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(115);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(116);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(6);

						                          ((ExpressionContext)_localctx).ast =  new Aritmetico(
						                              ((ExpressionContext)_localctx).e1.ast.getLinea(),
						                              ((ExpressionContext)_localctx).e1.ast.getColumna(),
						                              ((ExpressionContext)_localctx).e1.ast,
						                              (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),
						                              ((ExpressionContext)_localctx).e2.ast);
						                      
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(121);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__17) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(5);

						                          ((ExpressionContext)_localctx).ast =  new Aritmetico(
						                              ((ExpressionContext)_localctx).e1.ast.getLinea(),
						                              ((ExpressionContext)_localctx).e1.ast.getColumna(),
						                              ((ExpressionContext)_localctx).e1.ast,
						                              (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),
						                              ((ExpressionContext)_localctx).e2.ast);
						                      
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(126);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33030144L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(4);

						                          ((ExpressionContext)_localctx).ast =  new Comparador(
						                              ((ExpressionContext)_localctx).e1.ast.getLinea(),
						                              ((ExpressionContext)_localctx).e1.ast.getColumna(),
						                              ((ExpressionContext)_localctx).e1.ast,
						                              (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),
						                              ((ExpressionContext)_localctx).e2.ast);
						                      
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(131);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(3);

						                          ((ExpressionContext)_localctx).ast =  new Logico(
						                              ((ExpressionContext)_localctx).e1.ast.getLinea(),
						                              ((ExpressionContext)_localctx).e1.ast.getColumna(),
						                              ((ExpressionContext)_localctx).e1.ast,
						                              (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null),
						                              ((ExpressionContext)_localctx).e2.ast);
						                      
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(136);
						match(T__8);
						setState(137);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(138);
						match(T__9);

						                          ((ExpressionContext)_localctx).ast =  new AccesoArray(
						                              ((ExpressionContext)_localctx).e1.ast.getLinea(),
						                              ((ExpressionContext)_localctx).e1.ast.getColumna(),
						                              ((ExpressionContext)_localctx).e1.ast,
						                              ((ExpressionContext)_localctx).e2.ast);
						                      
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(142);
						match(T__10);
						setState(143);
						((ExpressionContext)_localctx).ID = match(ID);

						                          ((ExpressionContext)_localctx).ast =  new AccesoCampo(
						                              ((ExpressionContext)_localctx).e1.ast.getLinea(),
						                              ((ExpressionContext)_localctx).e1.ast.getColumna(),
						                              ((ExpressionContext)_localctx).e1.ast,
						                              (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						                      
						}
						break;
					}
					} 
				}
				setState(149);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Sentencia ast;
		public List<Expresion> parametros = new ArrayList<>();
		public List<Sentencia> contenidoElse = new ArrayList<>();
		public Token START;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionContext condicion;
		public Cuerpo_condicionalContext cuerpoIf;
		public Cuerpo_condicionalContext cuerpoElse;
		public Cuerpo_condicionalContext cuerpo;
		public ExpressionContext expression;
		public Token ID;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<Cuerpo_condicionalContext> cuerpo_condicional() {
			return getRuleContexts(Cuerpo_condicionalContext.class);
		}
		public Cuerpo_condicionalContext cuerpo_condicional(int i) {
			return getRuleContext(Cuerpo_condicionalContext.class,i);
		}
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				((StatementContext)_localctx).START = match(T__27);
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(151);
						((StatementContext)_localctx).e1 = expression(0);
						setState(152);
						match(T__26);
						 _localctx.parametros.add(((StatementContext)_localctx).e1.ast); 
						}
						} 
					}
					setState(159);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(160);
				((StatementContext)_localctx).e2 = expression(0);
				setState(161);
				match(T__28);

				                _localctx.parametros.add(((StatementContext)_localctx).e2.ast);
				                ((StatementContext)_localctx).ast =  new Log(
				                    ((StatementContext)_localctx).START.getLine(),
				                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                    _localctx.parametros);
				            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				((StatementContext)_localctx).START = match(T__29);
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(165);
						((StatementContext)_localctx).e1 = expression(0);
						setState(166);
						match(T__26);
						 _localctx.parametros.add(((StatementContext)_localctx).e1.ast); 
						}
						} 
					}
					setState(173);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(174);
				((StatementContext)_localctx).e2 = expression(0);
				setState(175);
				match(T__28);

				                _localctx.parametros.add(((StatementContext)_localctx).e2.ast);
				                ((StatementContext)_localctx).ast =  new Input(
				                    ((StatementContext)_localctx).START.getLine(),
				                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                    _localctx.parametros);
				            
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				((StatementContext)_localctx).e1 = expression(0);
				setState(179);
				match(T__30);
				setState(180);
				((StatementContext)_localctx).e2 = expression(0);
				setState(181);
				match(T__28);

				                ((StatementContext)_localctx).ast =  new Asignacion(
				                    ((StatementContext)_localctx).e1.ast.getLinea(),
				                    ((StatementContext)_localctx).e1.ast.getColumna(),
				                    ((StatementContext)_localctx).e1.ast,
				                    ((StatementContext)_localctx).e2.ast);
				            
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				((StatementContext)_localctx).START = match(T__31);
				setState(185);
				match(T__2);
				setState(186);
				((StatementContext)_localctx).condicion = expression(0);
				setState(187);
				match(T__3);
				setState(188);
				((StatementContext)_localctx).cuerpoIf = cuerpo_condicional();
				setState(193);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(189);
					match(T__32);
					setState(190);
					((StatementContext)_localctx).cuerpoElse = cuerpo_condicional();
					 ((StatementContext)_localctx).contenidoElse =  ((StatementContext)_localctx).cuerpoElse.ast; 
					}
					break;
				}

				                ((StatementContext)_localctx).ast =  new If(
				                    ((StatementContext)_localctx).START.getLine(),
				                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                    ((StatementContext)_localctx).condicion.ast,
				                    ((StatementContext)_localctx).cuerpoIf.ast,
				                    _localctx.contenidoElse);
				            
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				((StatementContext)_localctx).START = match(T__33);
				setState(198);
				match(T__2);
				setState(199);
				((StatementContext)_localctx).condicion = expression(0);
				setState(200);
				match(T__3);
				setState(201);
				((StatementContext)_localctx).cuerpo = cuerpo_condicional();

				                ((StatementContext)_localctx).ast =  new While(
				                    ((StatementContext)_localctx).START.getLine(),
				                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                    ((StatementContext)_localctx).condicion.ast,
				                    ((StatementContext)_localctx).cuerpo.ast);
				            
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(204);
				((StatementContext)_localctx).START = match(T__34);
				setState(205);
				((StatementContext)_localctx).expression = expression(0);
				setState(206);
				match(T__28);

				                ((StatementContext)_localctx).ast =  new Return(
				                    ((StatementContext)_localctx).START.getLine(),
				                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                    ((StatementContext)_localctx).expression.ast);
				            
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(209);
				((StatementContext)_localctx).ID = match(ID);
				setState(210);
				match(T__2);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 85761906991112L) != 0)) {
					{
					setState(217);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(211);
							((StatementContext)_localctx).e1 = expression(0);
							setState(212);
							match(T__26);
							 _localctx.parametros.add(((StatementContext)_localctx).e1.ast); 
							}
							} 
						}
						setState(219);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(220);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.parametros.add(((StatementContext)_localctx).e2.ast); 
					}
				}

				setState(225);
				match(T__3);
				setState(226);
				match(T__28);

				                Variable invocado = new Variable(
				                    ((StatementContext)_localctx).ID.getLine(),
				                    ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                    (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null));

				                ((StatementContext)_localctx).ast =  new Invocacion(
				                    ((StatementContext)_localctx).ID.getLine(),
				                    ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                    invocado,
				                    _localctx.parametros);
				            
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

	@SuppressWarnings("CheckReturnValue")
	public static class Cuerpo_condicionalContext extends ParserRuleContext {
		public List<Sentencia> ast = new ArrayList<>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Cuerpo_condicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpo_condicional; }
	}

	public final Cuerpo_condicionalContext cuerpo_condicional() throws RecognitionException {
		Cuerpo_condicionalContext _localctx = new Cuerpo_condicionalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cuerpo_condicional);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(T__6);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 85819083743240L) != 0)) {
					{
					{
					setState(231);
					((Cuerpo_condicionalContext)_localctx).statement = statement();
					 _localctx.ast.add(((Cuerpo_condicionalContext)_localctx).statement.ast); 
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(T__7);
				}
				break;
			case T__2:
			case T__12:
			case T__13:
			case T__27:
			case T__29:
			case T__31:
			case T__33:
			case T__34:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				((Cuerpo_condicionalContext)_localctx).statement = statement();
				 _localctx.ast.add(((Cuerpo_condicionalContext)_localctx).statement.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_simpleContext extends ParserRuleContext {
		public Tipo ast;
		public Tipo_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_simple; }
	}

	public final Tipo_simpleContext tipo_simple() throws RecognitionException {
		Tipo_simpleContext _localctx = new Tipo_simpleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipo_simple);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(T__35);
				 ((Tipo_simpleContext)_localctx).ast =  TipoInt.getInstance(); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(T__36);
				 ((Tipo_simpleContext)_localctx).ast =  TipoNumber.getInstance(); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(T__37);
				 ((Tipo_simpleContext)_localctx).ast =  TipoChar.getInstance(); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public Tipo ast;
		public List<DefinicionVar> lineasDefiniciones = new ArrayList<>();
		public Token INT_CONSTANT;
		public TipoContext tipo;
		public Var_definitionContext var_definition;
		public Tipo_simpleContext tipo_simple;
		public TerminalNode INT_CONSTANT() { return getToken(TSmmParser.INT_CONSTANT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		int _la;
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(T__8);
				setState(254);
				((TipoContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(255);
				match(T__9);
				setState(256);
				((TipoContext)_localctx).tipo = tipo();

				                ((TipoContext)_localctx).ast =  new TipoArray(
				                    ((TipoContext)_localctx).tipo.ast,
				                    LexerHelper.lexemeToInt((((TipoContext)_localctx).INT_CONSTANT!=null?((TipoContext)_localctx).INT_CONSTANT.getText():null)));
				            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(T__8);
				setState(263); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(260);
					((TipoContext)_localctx).var_definition = var_definition();
					 _localctx.lineasDefiniciones.addAll(((TipoContext)_localctx).var_definition.ast); 
					}
					}
					setState(265); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__38 );
				setState(267);
				match(T__9);

				                /* Con add no tenemos promocion de tipos hacia arriba, pero con addAll si */
				                List<CampoRecord> camposRegistro = new ArrayList<>();
				                List<String> nombresCamposRegistro = new ArrayList<>();

				                for(DefinicionVar variable : _localctx.lineasDefiniciones) {

				                    // Comprobacion de errores semanticos //

				                    // Comprobacion: duplicated field
				                    if(nombresCamposRegistro.contains(variable.getNombre())) {
				                        ((TipoContext)_localctx).ast =  new ErrorType("duplicated field", variable);
				                    } else {
				                        nombresCamposRegistro.add(variable.getNombre());
				                    }

				                    // ---------------------------------- //

				                    camposRegistro.add(new CampoRecord(
				                        variable.getLinea(),
				                        variable.getColumna(),
				                        variable.getTipo(),
				                        variable.getNombre()));
				                }

				                ((TipoContext)_localctx).ast =  new TipoRecord(camposRegistro);
				            
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				((TipoContext)_localctx).tipo_simple = tipo_simple();

				                ((TipoContext)_localctx).ast =  ((TipoContext)_localctx).tipo_simple.ast;
				            
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

	@SuppressWarnings("CheckReturnValue")
	public static class Var_definitionContext extends ParserRuleContext {
		public List<DefinicionVar> ast = new ArrayList<>();
		public List<Variable> ids = new ArrayList<>();
		public Token ID1;
		public Token ID2;
		public TipoContext tipo;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(TSmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TSmmParser.ID, i);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__38);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(276);
					((Var_definitionContext)_localctx).ID1 = match(ID);
					setState(277);
					match(T__26);
					 _localctx.ids.add(new Variable(((Var_definitionContext)_localctx).ID1.getLine(), ((Var_definitionContext)_localctx).ID1.getCharPositionInLine() + 1, (((Var_definitionContext)_localctx).ID1!=null?((Var_definitionContext)_localctx).ID1.getText():null))); 
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(284);
			((Var_definitionContext)_localctx).ID2 = match(ID);
			 _localctx.ids.add(new Variable(((Var_definitionContext)_localctx).ID2.getLine(), ((Var_definitionContext)_localctx).ID2.getCharPositionInLine() + 1, (((Var_definitionContext)_localctx).ID2!=null?((Var_definitionContext)_localctx).ID2.getText():null))); 
			setState(286);
			match(T__4);
			setState(287);
			((Var_definitionContext)_localctx).tipo = tipo();
			setState(288);
			match(T__28);


			                for(Variable id : _localctx.ids) {
			                    _localctx.ast.add(new DefinicionVar(
			                        id.getLinea(),
			                        id.getColumna(),
			                        ((Var_definitionContext)_localctx).tipo.ast,
			                        id.getNombre()));
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public DefinicionFunc ast;
		public List<DefinicionVar> parametros = new ArrayList<>();
		public List<DefinicionVar> definicionesVariables = new ArrayList<>();
		public List<Sentencia> sentencias = new ArrayList<>();
		public Token START;
		public Token ID;
		public Function_typeContext function_type;
		public Var_definitionContext var_definition;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public Function_typeContext function_type() {
			return getRuleContext(Function_typeContext.class,0);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			((Function_definitionContext)_localctx).START = match(T__0);
			setState(292);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(293);
			((Function_definitionContext)_localctx).function_type = function_type();
			setState(294);
			match(T__6);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38) {
				{
				{
				setState(295);
				((Function_definitionContext)_localctx).var_definition = var_definition();
				 _localctx.definicionesVariables.addAll(((Function_definitionContext)_localctx).var_definition.ast); 
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 85819083743240L) != 0)) {
				{
				{
				setState(303);
				((Function_definitionContext)_localctx).statement = statement();
				 _localctx.sentencias.add(((Function_definitionContext)_localctx).statement.ast); 
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
			match(T__7);

			                ((Function_definitionContext)_localctx).ast =  new DefinicionFunc(
			                    ((Function_definitionContext)_localctx).START.getLine(),
			                    ((Function_definitionContext)_localctx).START.getCharPositionInLine() + 1,
			                    ((Function_definitionContext)_localctx).function_type.ast,
			                    (((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null),
			                    _localctx.definicionesVariables,
			                    _localctx.sentencias);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_typeContext extends ParserRuleContext {
		public TipoFuncion ast;
		public List<DefinicionVar> parametros = new ArrayList<>();
		public Function_paramContext param1;
		public Function_paramContext param2;
		public Function_return_typeContext tipoRetorno;
		public Function_return_typeContext function_return_type() {
			return getRuleContext(Function_return_typeContext.class,0);
		}
		public List<Function_paramContext> function_param() {
			return getRuleContexts(Function_paramContext.class);
		}
		public Function_paramContext function_param(int i) {
			return getRuleContext(Function_paramContext.class,i);
		}
		public Function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_type; }
	}

	public final Function_typeContext function_type() throws RecognitionException {
		Function_typeContext _localctx = new Function_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__2);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(315);
						((Function_typeContext)_localctx).param1 = function_param();
						setState(316);
						match(T__26);
						 _localctx.parametros.add(((Function_typeContext)_localctx).param1.ast); 
						}
						} 
					}
					setState(323);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(324);
				((Function_typeContext)_localctx).param2 = function_param();
				 _localctx.parametros.add(((Function_typeContext)_localctx).param2.ast); 
				}
			}

			setState(329);
			match(T__3);
			setState(330);
			match(T__4);
			setState(331);
			((Function_typeContext)_localctx).tipoRetorno = function_return_type();

			                ((Function_typeContext)_localctx).ast =  new TipoFuncion(
			                    ((Function_typeContext)_localctx).tipoRetorno.ast,
			                    _localctx.parametros);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_paramContext extends ParserRuleContext {
		public DefinicionVar ast;
		public Token ID;
		public Tipo_simpleContext tipo_simple;
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public Function_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_param; }
	}

	public final Function_paramContext function_param() throws RecognitionException {
		Function_paramContext _localctx = new Function_paramContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			((Function_paramContext)_localctx).ID = match(ID);
			setState(335);
			match(T__4);
			setState(336);
			((Function_paramContext)_localctx).tipo_simple = tipo_simple();

			                ((Function_paramContext)_localctx).ast =  new DefinicionVar(
			                    ((Function_paramContext)_localctx).ID.getLine(),
			                    ((Function_paramContext)_localctx).ID.getCharPositionInLine() + 1,
			                    ((Function_paramContext)_localctx).tipo_simple.ast,
			                    (((Function_paramContext)_localctx).ID!=null?((Function_paramContext)_localctx).ID.getText():null));
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_return_typeContext extends ParserRuleContext {
		public Tipo ast;
		public Tipo_simpleContext tipo_simple;
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public Function_return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_return_type; }
	}

	public final Function_return_typeContext function_return_type() throws RecognitionException {
		Function_return_typeContext _localctx = new Function_return_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function_return_type);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
			case T__36:
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				((Function_return_typeContext)_localctx).tipo_simple = tipo_simple();

				                ((Function_return_typeContext)_localctx).ast =  ((Function_return_typeContext)_localctx).tipo_simple.ast;
				            
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(T__5);

				                ((Function_return_typeContext)_localctx).ast =  TipoVoid.getInstance();
				            
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u015b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u001f\b\u0000\n\u0000\f\u0000\"\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002f\b\u0002\n\u0002\f\u0002i\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002n\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002r\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0092\b\u0002\n\u0002"+
		"\f\u0002\u0095\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003\u009c\b\u0003\n\u0003\f\u0003\u009f\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00aa\b\u0003\n\u0003\f\u0003"+
		"\u00ad\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00c2\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u00d8\b\u0003\n\u0003\f\u0003\u00db\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u00e0\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u00e5\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u00eb\b\u0004\n\u0004\f\u0004\u00ee\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00f4\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00fc\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"\u0108\b\u0006\u000b\u0006\f\u0006\u0109\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0112\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0118\b\u0007\n"+
		"\u0007\f\u0007\u011b\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u012b\b\b\n\b\f\b\u012e\t\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\b\u0133\b\b\n\b\f\b\u0136\t\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0140\b\t\n\t\f\t\u0143"+
		"\t\t\u0001\t\u0001\t\u0001\t\u0003\t\u0148\b\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0159\b\u000b\u0001"+
		"\u000b\u0000\u0001\u0004\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0000\u0004\u0001\u0000\u000f\u0011\u0002\u0000\r\r\u0012"+
		"\u0012\u0001\u0000\u0013\u0018\u0001\u0000\u0019\u001a\u017a\u0000 \u0001"+
		"\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004q\u0001\u0000"+
		"\u0000\u0000\u0006\u00e4\u0001\u0000\u0000\u0000\b\u00f3\u0001\u0000\u0000"+
		"\u0000\n\u00fb\u0001\u0000\u0000\u0000\f\u0111\u0001\u0000\u0000\u0000"+
		"\u000e\u0113\u0001\u0000\u0000\u0000\u0010\u0123\u0001\u0000\u0000\u0000"+
		"\u0012\u013a\u0001\u0000\u0000\u0000\u0014\u014e\u0001\u0000\u0000\u0000"+
		"\u0016\u0158\u0001\u0000\u0000\u0000\u0018\u0019\u0003\u000e\u0007\u0000"+
		"\u0019\u001a\u0006\u0000\uffff\uffff\u0000\u001a\u001f\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0003\u0010\b\u0000\u001c\u001d\u0006\u0000\uffff\uffff"+
		"\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u0018\u0001\u0000\u0000"+
		"\u0000\u001e\u001b\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!#\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0003\u0002\u0001\u0000$%\u0005"+
		"\u0000\u0000\u0001%&\u0006\u0000\uffff\uffff\u0000&\u0001\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0005\u0002\u0000\u0000)*\u0005"+
		"\u0003\u0000\u0000*+\u0005\u0004\u0000\u0000+,\u0005\u0005\u0000\u0000"+
		",-\u0005\u0006\u0000\u0000-3\u0005\u0007\u0000\u0000./\u0003\u000e\u0007"+
		"\u0000/0\u0006\u0001\uffff\uffff\u000002\u0001\u0000\u0000\u00001.\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u00004;\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000067\u0003\u0006\u0003\u000078\u0006\u0001\uffff\uffff\u00008:\u0001"+
		"\u0000\u0000\u000096\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000"+
		";9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>?\u0005\b\u0000\u0000?@\u0006\u0001\uffff"+
		"\uffff\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0006\u0002\uffff\uffff"+
		"\u0000BC\u0005)\u0000\u0000Cr\u0006\u0002\uffff\uffff\u0000DE\u0005*\u0000"+
		"\u0000Er\u0006\u0002\uffff\uffff\u0000FG\u0005+\u0000\u0000Gr\u0006\u0002"+
		"\uffff\uffff\u0000HI\u0005.\u0000\u0000Ir\u0006\u0002\uffff\uffff\u0000"+
		"JK\u0005\u0003\u0000\u0000KL\u0003\u0004\u0002\u0000LM\u0005\u0004\u0000"+
		"\u0000MN\u0006\u0002\uffff\uffff\u0000Nr\u0001\u0000\u0000\u0000OP\u0005"+
		"\u0003\u0000\u0000PQ\u0003\u0004\u0002\u0000QR\u0005\f\u0000\u0000RS\u0003"+
		"\n\u0005\u0000ST\u0005\u0004\u0000\u0000TU\u0006\u0002\uffff\uffff\u0000"+
		"Ur\u0001\u0000\u0000\u0000VW\u0005\r\u0000\u0000WX\u0003\u0004\u0002\u0007"+
		"XY\u0006\u0002\uffff\uffff\u0000Yr\u0001\u0000\u0000\u0000Z[\u0005\u000e"+
		"\u0000\u0000[\\\u0003\u0004\u0002\u0006\\]\u0006\u0002\uffff\uffff\u0000"+
		"]r\u0001\u0000\u0000\u0000^_\u0005.\u0000\u0000_`\u0006\u0002\uffff\uffff"+
		"\u0000`m\u0005\u0003\u0000\u0000ab\u0003\u0004\u0002\u0000bc\u0005\u001b"+
		"\u0000\u0000cd\u0006\u0002\uffff\uffff\u0000df\u0001\u0000\u0000\u0000"+
		"ea\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000jk\u0003\u0004\u0002\u0000kl\u0006\u0002\uffff\uffff\u0000"+
		"ln\u0001\u0000\u0000\u0000mg\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000op\u0005\u0004\u0000\u0000pr\u0006\u0002"+
		"\uffff\uffff\u0000qA\u0001\u0000\u0000\u0000qD\u0001\u0000\u0000\u0000"+
		"qF\u0001\u0000\u0000\u0000qH\u0001\u0000\u0000\u0000qJ\u0001\u0000\u0000"+
		"\u0000qO\u0001\u0000\u0000\u0000qV\u0001\u0000\u0000\u0000qZ\u0001\u0000"+
		"\u0000\u0000q^\u0001\u0000\u0000\u0000r\u0093\u0001\u0000\u0000\u0000"+
		"st\n\u0005\u0000\u0000tu\u0007\u0000\u0000\u0000uv\u0003\u0004\u0002\u0006"+
		"vw\u0006\u0002\uffff\uffff\u0000w\u0092\u0001\u0000\u0000\u0000xy\n\u0004"+
		"\u0000\u0000yz\u0007\u0001\u0000\u0000z{\u0003\u0004\u0002\u0005{|\u0006"+
		"\u0002\uffff\uffff\u0000|\u0092\u0001\u0000\u0000\u0000}~\n\u0003\u0000"+
		"\u0000~\u007f\u0007\u0002\u0000\u0000\u007f\u0080\u0003\u0004\u0002\u0004"+
		"\u0080\u0081\u0006\u0002\uffff\uffff\u0000\u0081\u0092\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\n\u0002\u0000\u0000\u0083\u0084\u0007\u0003\u0000\u0000"+
		"\u0084\u0085\u0003\u0004\u0002\u0003\u0085\u0086\u0006\u0002\uffff\uffff"+
		"\u0000\u0086\u0092\u0001\u0000\u0000\u0000\u0087\u0088\n\n\u0000\u0000"+
		"\u0088\u0089\u0005\t\u0000\u0000\u0089\u008a\u0003\u0004\u0002\u0000\u008a"+
		"\u008b\u0005\n\u0000\u0000\u008b\u008c\u0006\u0002\uffff\uffff\u0000\u008c"+
		"\u0092\u0001\u0000\u0000\u0000\u008d\u008e\n\t\u0000\u0000\u008e\u008f"+
		"\u0005\u000b\u0000\u0000\u008f\u0090\u0005.\u0000\u0000\u0090\u0092\u0006"+
		"\u0002\uffff\uffff\u0000\u0091s\u0001\u0000\u0000\u0000\u0091x\u0001\u0000"+
		"\u0000\u0000\u0091}\u0001\u0000\u0000\u0000\u0091\u0082\u0001\u0000\u0000"+
		"\u0000\u0091\u0087\u0001\u0000\u0000\u0000\u0091\u008d\u0001\u0000\u0000"+
		"\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0005\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u009d\u0005\u001c\u0000"+
		"\u0000\u0097\u0098\u0003\u0004\u0002\u0000\u0098\u0099\u0005\u001b\u0000"+
		"\u0000\u0099\u009a\u0006\u0003\uffff\uffff\u0000\u009a\u009c\u0001\u0000"+
		"\u0000\u0000\u009b\u0097\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0003\u0004\u0002\u0000\u00a1\u00a2\u0005\u001d"+
		"\u0000\u0000\u00a2\u00a3\u0006\u0003\uffff\uffff\u0000\u00a3\u00e5\u0001"+
		"\u0000\u0000\u0000\u00a4\u00ab\u0005\u001e\u0000\u0000\u00a5\u00a6\u0003"+
		"\u0004\u0002\u0000\u00a6\u00a7\u0005\u001b\u0000\u0000\u00a7\u00a8\u0006"+
		"\u0003\uffff\uffff\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a5"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0003\u0004\u0002\u0000\u00af\u00b0\u0005\u001d\u0000\u0000\u00b0\u00b1"+
		"\u0006\u0003\uffff\uffff\u0000\u00b1\u00e5\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0003\u0004\u0002\u0000\u00b3\u00b4\u0005\u001f\u0000\u0000\u00b4"+
		"\u00b5\u0003\u0004\u0002\u0000\u00b5\u00b6\u0005\u001d\u0000\u0000\u00b6"+
		"\u00b7\u0006\u0003\uffff\uffff\u0000\u00b7\u00e5\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0005 \u0000\u0000\u00b9\u00ba\u0005\u0003\u0000\u0000\u00ba"+
		"\u00bb\u0003\u0004\u0002\u0000\u00bb\u00bc\u0005\u0004\u0000\u0000\u00bc"+
		"\u00c1\u0003\b\u0004\u0000\u00bd\u00be\u0005!\u0000\u0000\u00be\u00bf"+
		"\u0003\b\u0004\u0000\u00bf\u00c0\u0006\u0003\uffff\uffff\u0000\u00c0\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bd\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0006\u0003\uffff\uffff\u0000\u00c4\u00e5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\"\u0000\u0000\u00c6\u00c7\u0005\u0003\u0000\u0000\u00c7\u00c8"+
		"\u0003\u0004\u0002\u0000\u00c8\u00c9\u0005\u0004\u0000\u0000\u00c9\u00ca"+
		"\u0003\b\u0004\u0000\u00ca\u00cb\u0006\u0003\uffff\uffff\u0000\u00cb\u00e5"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005#\u0000\u0000\u00cd\u00ce\u0003"+
		"\u0004\u0002\u0000\u00ce\u00cf\u0005\u001d\u0000\u0000\u00cf\u00d0\u0006"+
		"\u0003\uffff\uffff\u0000\u00d0\u00e5\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0005.\u0000\u0000\u00d2\u00df\u0005\u0003\u0000\u0000\u00d3\u00d4\u0003"+
		"\u0004\u0002\u0000\u00d4\u00d5\u0005\u001b\u0000\u0000\u00d5\u00d6\u0006"+
		"\u0003\uffff\uffff\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00dc"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0003\u0004\u0002\u0000\u00dd\u00de\u0006\u0003\uffff\uffff\u0000\u00de"+
		"\u00e0\u0001\u0000\u0000\u0000\u00df\u00d9\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0005\u0004\u0000\u0000\u00e2\u00e3\u0005\u001d\u0000\u0000\u00e3"+
		"\u00e5\u0006\u0003\uffff\uffff\u0000\u00e4\u0096\u0001\u0000\u0000\u0000"+
		"\u00e4\u00a4\u0001\u0000\u0000\u0000\u00e4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00e4\u00b8\u0001\u0000\u0000\u0000\u00e4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00e4\u00cc\u0001\u0000\u0000\u0000\u00e4\u00d1\u0001\u0000\u0000\u0000"+
		"\u00e5\u0007\u0001\u0000\u0000\u0000\u00e6\u00ec\u0005\u0007\u0000\u0000"+
		"\u00e7\u00e8\u0003\u0006\u0003\u0000\u00e8\u00e9\u0006\u0004\uffff\uffff"+
		"\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e7\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f4\u0005\b\u0000\u0000"+
		"\u00f0\u00f1\u0003\u0006\u0003\u0000\u00f1\u00f2\u0006\u0004\uffff\uffff"+
		"\u0000\u00f2\u00f4\u0001\u0000\u0000\u0000\u00f3\u00e6\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f4\t\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0005$\u0000\u0000\u00f6\u00fc\u0006\u0005\uffff\uffff\u0000"+
		"\u00f7\u00f8\u0005%\u0000\u0000\u00f8\u00fc\u0006\u0005\uffff\uffff\u0000"+
		"\u00f9\u00fa\u0005&\u0000\u0000\u00fa\u00fc\u0006\u0005\uffff\uffff\u0000"+
		"\u00fb\u00f5\u0001\u0000\u0000\u0000\u00fb\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u000b\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0005\t\u0000\u0000\u00fe\u00ff\u0005)\u0000\u0000\u00ff"+
		"\u0100\u0005\n\u0000\u0000\u0100\u0101\u0003\f\u0006\u0000\u0101\u0102"+
		"\u0006\u0006\uffff\uffff\u0000\u0102\u0112\u0001\u0000\u0000\u0000\u0103"+
		"\u0107\u0005\t\u0000\u0000\u0104\u0105\u0003\u000e\u0007\u0000\u0105\u0106"+
		"\u0006\u0006\uffff\uffff\u0000\u0106\u0108\u0001\u0000\u0000\u0000\u0107"+
		"\u0104\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109"+
		"\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0005\n\u0000\u0000\u010c\u010d"+
		"\u0006\u0006\uffff\uffff\u0000\u010d\u0112\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0003\n\u0005\u0000\u010f\u0110\u0006\u0006\uffff\uffff\u0000\u0110"+
		"\u0112\u0001\u0000\u0000\u0000\u0111\u00fd\u0001\u0000\u0000\u0000\u0111"+
		"\u0103\u0001\u0000\u0000\u0000\u0111\u010e\u0001\u0000\u0000\u0000\u0112"+
		"\r\u0001\u0000\u0000\u0000\u0113\u0119\u0005\'\u0000\u0000\u0114\u0115"+
		"\u0005.\u0000\u0000\u0115\u0116\u0005\u001b\u0000\u0000\u0116\u0118\u0006"+
		"\u0007\uffff\uffff\u0000\u0117\u0114\u0001\u0000\u0000\u0000\u0118\u011b"+
		"\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0001\u0000\u0000\u0000\u011a\u011c\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0005.\u0000\u0000\u011d\u011e\u0006"+
		"\u0007\uffff\uffff\u0000\u011e\u011f\u0005\u0005\u0000\u0000\u011f\u0120"+
		"\u0003\f\u0006\u0000\u0120\u0121\u0005\u001d\u0000\u0000\u0121\u0122\u0006"+
		"\u0007\uffff\uffff\u0000\u0122\u000f\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0005\u0001\u0000\u0000\u0124\u0125\u0005.\u0000\u0000\u0125\u0126\u0003"+
		"\u0012\t\u0000\u0126\u012c\u0005\u0007\u0000\u0000\u0127\u0128\u0003\u000e"+
		"\u0007\u0000\u0128\u0129\u0006\b\uffff\uffff\u0000\u0129\u012b\u0001\u0000"+
		"\u0000\u0000\u012a\u0127\u0001\u0000\u0000\u0000\u012b\u012e\u0001\u0000"+
		"\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000"+
		"\u0000\u0000\u012d\u0134\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0003\u0006\u0003\u0000\u0130\u0131\u0006\b\uffff"+
		"\uffff\u0000\u0131\u0133\u0001\u0000\u0000\u0000\u0132\u012f\u0001\u0000"+
		"\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0137\u0001\u0000"+
		"\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u0138\u0005\b\u0000"+
		"\u0000\u0138\u0139\u0006\b\uffff\uffff\u0000\u0139\u0011\u0001\u0000\u0000"+
		"\u0000\u013a\u0147\u0005\u0003\u0000\u0000\u013b\u013c\u0003\u0014\n\u0000"+
		"\u013c\u013d\u0005\u001b\u0000\u0000\u013d\u013e\u0006\t\uffff\uffff\u0000"+
		"\u013e\u0140\u0001\u0000\u0000\u0000\u013f\u013b\u0001\u0000\u0000\u0000"+
		"\u0140\u0143\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000"+
		"\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u0145\u0003\u0014\n\u0000\u0145"+
		"\u0146\u0006\t\uffff\uffff\u0000\u0146\u0148\u0001\u0000\u0000\u0000\u0147"+
		"\u0141\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148"+
		"\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u0004\u0000\u0000\u014a"+
		"\u014b\u0005\u0005\u0000\u0000\u014b\u014c\u0003\u0016\u000b\u0000\u014c"+
		"\u014d\u0006\t\uffff\uffff\u0000\u014d\u0013\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0005.\u0000\u0000\u014f\u0150\u0005\u0005\u0000\u0000\u0150\u0151"+
		"\u0003\n\u0005\u0000\u0151\u0152\u0006\n\uffff\uffff\u0000\u0152\u0015"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0003\n\u0005\u0000\u0154\u0155\u0006"+
		"\u000b\uffff\uffff\u0000\u0155\u0159\u0001\u0000\u0000\u0000\u0156\u0157"+
		"\u0005\u0006\u0000\u0000\u0157\u0159\u0006\u000b\uffff\uffff\u0000\u0158"+
		"\u0153\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159"+
		"\u0017\u0001\u0000\u0000\u0000\u001a\u001e 3;gmq\u0091\u0093\u009d\u00ab"+
		"\u00c1\u00d9\u00df\u00e4\u00ec\u00f3\u00fb\u0109\u0111\u0119\u012c\u0134"+
		"\u0141\u0147\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}