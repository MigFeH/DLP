// Generated from D:/TRABAJOS/Desktop/Clase/DLP/Proyecto/src/parser/TSmm.g4 by ANTLR 4.13.2
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
		T__38=39, T__39=40, WHITE_SPACES=41, INT_CONSTANT=42, REAL_CONSTANT=43, 
		CHAR_CONSTANT=44, COMENTARIO_UNILINEA=45, COMENTARIO_MULTILINEA=46, ID=47;
	public static final int
		RULE_program = 0, RULE_main_function_definition = 1, RULE_expression = 2, 
		RULE_statement = 3, RULE_asignacion_sin_punto_coma = 4, RULE_inicio_bucle_for = 5, 
		RULE_definicion_inicializacion_simple = 6, RULE_cuerpo_condicional = 7, 
		RULE_tipo_simple = 8, RULE_tipo = 9, RULE_var_definition = 10, RULE_function_definition = 11, 
		RULE_function_type = 12, RULE_function_param = 13, RULE_function_return_type = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main_function_definition", "expression", "statement", "asignacion_sin_punto_coma", 
			"inicio_bucle_for", "definicion_inicializacion_simple", "cuerpo_condicional", 
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
			"'log'", "';'", "'input'", "'if'", "'else'", "'while'", "'return'", "'for'", 
			"'='", "'let'", "'int'", "'number'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "WHITE_SPACES", "INT_CONSTANT", "REAL_CONSTANT", 
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
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(36);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(30);
						((ProgramContext)_localctx).var_definition = var_definition();
						 _localctx.defs.addAll(((ProgramContext)_localctx).var_definition.ast); 
						}
						break;
					case T__0:
						{
						setState(33);
						((ProgramContext)_localctx).function_definition = function_definition();
						 _localctx.defs.add(((ProgramContext)_localctx).function_definition.ast); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(41);
			((ProgramContext)_localctx).main = main_function_definition();
			setState(42);
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
			setState(45);
			((Main_function_definitionContext)_localctx).START = match(T__0);
			setState(46);
			match(T__1);
			setState(47);
			match(T__2);
			setState(48);
			match(T__3);
			setState(49);
			match(T__4);
			setState(50);
			match(T__5);
			setState(51);
			match(T__6);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(52);
				((Main_function_definitionContext)_localctx).var_definition = var_definition();
				 _localctx.definicionesVariables.addAll(((Main_function_definitionContext)_localctx).var_definition.ast); 
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 171587433160712L) != 0)) {
				{
				{
				setState(60);
				((Main_function_definitionContext)_localctx).statement = statement();
				 _localctx.sentencias.add(((Main_function_definitionContext)_localctx).statement.ast); 
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(72);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);

				                ((ExpressionContext)_localctx).ast =  new ConstanteInt(
				                    ((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
				                    ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1,
				                    LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				            
				}
				break;
			case 2:
				{
				setState(74);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);

				                ((ExpressionContext)_localctx).ast =  new ConstanteReal(
				                    ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
				                    ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1,
				                    LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				            
				}
				break;
			case 3:
				{
				setState(76);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);

				                ((ExpressionContext)_localctx).ast =  new ConstanteCaracter(
				                    ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
				                    ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1,
				                    LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				            
				}
				break;
			case 4:
				{
				setState(78);
				((ExpressionContext)_localctx).ID = match(ID);

				                ((ExpressionContext)_localctx).ast =  new Variable(
				                    ((ExpressionContext)_localctx).ID.getLine(),
				                    ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                    (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				            
				}
				break;
			case 5:
				{
				setState(80);
				match(T__2);
				setState(81);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(82);
				match(T__3);

				                ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast;
				            
				}
				break;
			case 6:
				{
				setState(85);
				match(T__2);
				setState(86);
				((ExpressionContext)_localctx).e1 = ((ExpressionContext)_localctx).expression = expression(0);
				setState(87);
				match(T__11);
				setState(88);
				((ExpressionContext)_localctx).tipo_simple = tipo_simple();
				setState(89);
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
				setState(92);
				match(T__12);
				setState(93);
				((ExpressionContext)_localctx).expression = expression(7);

				                ((ExpressionContext)_localctx).ast =  new MenosUnario(
				                    ((ExpressionContext)_localctx).expression.ast.getLinea(),
				                    ((ExpressionContext)_localctx).expression.ast.getColumna(),
				                    ((ExpressionContext)_localctx).expression.ast);
				            
				}
				break;
			case 8:
				{
				setState(96);
				match(T__13);
				setState(97);
				((ExpressionContext)_localctx).expression = expression(6);

				                ((ExpressionContext)_localctx).ast =  new Negacion(
				                    ((ExpressionContext)_localctx).expression.ast.getLinea(),
				                    ((ExpressionContext)_localctx).expression.ast.getColumna(),
				                    ((ExpressionContext)_localctx).expression.ast);
				            
				}
				break;
			case 9:
				{
				setState(100);
				((ExpressionContext)_localctx).ID = match(ID);

				                ((ExpressionContext)_localctx).variable =  new Variable(
				                    ((ExpressionContext)_localctx).ID.getLine(),
				                    ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                    (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));

				                ((ExpressionContext)_localctx).argumentos =  new ArrayList<>();
				            
				setState(102);
				match(T__2);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 171523813957640L) != 0)) {
					{
					setState(103);
					((ExpressionContext)_localctx).e1 = ((ExpressionContext)_localctx).expression = expression(0);
					 _localctx.argumentos.add(((ExpressionContext)_localctx).e1.ast); 
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__26) {
						{
						{
						setState(105);
						match(T__26);
						setState(106);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						 _localctx.argumentos.add(((ExpressionContext)_localctx).e2.ast); 
						}
						}
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(116);
				match(T__3);

				                ((ExpressionContext)_localctx).ast =  new Invocacion(
				                    ((ExpressionContext)_localctx).ID.getLine(),
				                    ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                    _localctx.variable,
				                    _localctx.argumentos);
				            
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(121);
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
						setState(122);
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
						setState(125);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(126);
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
						setState(127);
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
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
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
						setState(132);
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
						setState(135);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(136);
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
						setState(137);
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
						setState(140);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(141);
						match(T__8);
						setState(142);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(143);
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
						setState(146);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(147);
						match(T__10);
						setState(148);
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
				setState(154);
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
		public Asignacion_sin_punto_comaContext asignacion_sin_punto_coma;
		public ExpressionContext condicion;
		public Cuerpo_condicionalContext cuerpoIf;
		public Cuerpo_condicionalContext cuerpoElse;
		public Cuerpo_condicionalContext cuerpo;
		public ExpressionContext expression;
		public Token ID;
		public Inicio_bucle_forContext inicio_bucle_for;
		public ExpressionContext fin;
		public Asignacion_sin_punto_comaContext salto;
		public Cuerpo_condicionalContext cuerpo_condicional;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Asignacion_sin_punto_comaContext asignacion_sin_punto_coma() {
			return getRuleContext(Asignacion_sin_punto_comaContext.class,0);
		}
		public List<Cuerpo_condicionalContext> cuerpo_condicional() {
			return getRuleContexts(Cuerpo_condicionalContext.class);
		}
		public Cuerpo_condicionalContext cuerpo_condicional(int i) {
			return getRuleContext(Cuerpo_condicionalContext.class,i);
		}
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public Inicio_bucle_forContext inicio_bucle_for() {
			return getRuleContext(Inicio_bucle_forContext.class,0);
		}
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
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((StatementContext)_localctx).START = match(T__27);
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(156);
						((StatementContext)_localctx).e1 = expression(0);
						setState(157);
						match(T__26);
						 _localctx.parametros.add(((StatementContext)_localctx).e1.ast); 
						}
						} 
					}
					setState(164);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(165);
				((StatementContext)_localctx).e2 = expression(0);
				setState(166);
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
				setState(169);
				((StatementContext)_localctx).START = match(T__29);
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(170);
						((StatementContext)_localctx).e1 = expression(0);
						setState(171);
						match(T__26);
						 _localctx.parametros.add(((StatementContext)_localctx).e1.ast); 
						}
						} 
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(179);
				((StatementContext)_localctx).e2 = expression(0);
				setState(180);
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
				setState(183);
				((StatementContext)_localctx).asignacion_sin_punto_coma = asignacion_sin_punto_coma();
				setState(184);
				match(T__28);

				                ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).asignacion_sin_punto_coma.ast;
				            
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				((StatementContext)_localctx).START = match(T__30);
				setState(188);
				match(T__2);
				setState(189);
				((StatementContext)_localctx).condicion = expression(0);
				setState(190);
				match(T__3);
				setState(191);
				((StatementContext)_localctx).cuerpoIf = cuerpo_condicional();
				setState(196);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(192);
					match(T__31);
					setState(193);
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
				setState(200);
				((StatementContext)_localctx).START = match(T__32);
				setState(201);
				match(T__2);
				setState(202);
				((StatementContext)_localctx).condicion = expression(0);
				setState(203);
				match(T__3);
				setState(204);
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
				setState(207);
				((StatementContext)_localctx).START = match(T__33);
				setState(208);
				((StatementContext)_localctx).expression = expression(0);
				setState(209);
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
				setState(212);
				((StatementContext)_localctx).ID = match(ID);
				setState(213);
				match(T__2);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 171523813957640L) != 0)) {
					{
					setState(220);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(214);
							((StatementContext)_localctx).e1 = expression(0);
							setState(215);
							match(T__26);
							 _localctx.parametros.add(((StatementContext)_localctx).e1.ast); 
							}
							} 
						}
						setState(222);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(223);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.parametros.add(((StatementContext)_localctx).e2.ast); 
					}
				}

				setState(228);
				match(T__3);
				setState(229);
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
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(231);
				((StatementContext)_localctx).START = match(T__34);
				setState(232);
				match(T__2);
				setState(233);
				((StatementContext)_localctx).inicio_bucle_for = inicio_bucle_for();
				setState(234);
				match(T__28);
				setState(235);
				((StatementContext)_localctx).fin = expression(0);
				setState(236);
				match(T__28);
				setState(237);
				((StatementContext)_localctx).salto = asignacion_sin_punto_coma();
				setState(238);
				match(T__3);
				setState(239);
				((StatementContext)_localctx).cuerpo_condicional = cuerpo_condicional();

				                ((StatementContext)_localctx).ast =  new For(
				                    ((StatementContext)_localctx).START.getLine(),
				                    ((StatementContext)_localctx).START.getCharPositionInLine() + 1,
				                    ((StatementContext)_localctx).inicio_bucle_for.ast,
				                    ((StatementContext)_localctx).fin.ast,
				                    ((StatementContext)_localctx).salto.ast,
				                    ((StatementContext)_localctx).cuerpo_condicional.ast
				                );
				            
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
	public static class Asignacion_sin_punto_comaContext extends ParserRuleContext {
		public Sentencia ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Asignacion_sin_punto_comaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion_sin_punto_coma; }
	}

	public final Asignacion_sin_punto_comaContext asignacion_sin_punto_coma() throws RecognitionException {
		Asignacion_sin_punto_comaContext _localctx = new Asignacion_sin_punto_comaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asignacion_sin_punto_coma);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			((Asignacion_sin_punto_comaContext)_localctx).e1 = expression(0);
			setState(245);
			match(T__35);
			setState(246);
			((Asignacion_sin_punto_comaContext)_localctx).e2 = expression(0);

			                ((Asignacion_sin_punto_comaContext)_localctx).ast =  new Asignacion(
			                    ((Asignacion_sin_punto_comaContext)_localctx).e1.ast.getLinea(),
			                    ((Asignacion_sin_punto_comaContext)_localctx).e1.ast.getColumna(),
			                    ((Asignacion_sin_punto_comaContext)_localctx).e1.ast,
			                    ((Asignacion_sin_punto_comaContext)_localctx).e2.ast);
			            
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
	public static class Inicio_bucle_forContext extends ParserRuleContext {
		public List<Sentencia> ast = new ArrayList<>();
		public Asignacion_sin_punto_comaContext asignacion_sin_punto_coma;
		public Definicion_inicializacion_simpleContext definicion_inicializacion_simple;
		public Asignacion_sin_punto_comaContext asignacion_sin_punto_coma() {
			return getRuleContext(Asignacion_sin_punto_comaContext.class,0);
		}
		public Definicion_inicializacion_simpleContext definicion_inicializacion_simple() {
			return getRuleContext(Definicion_inicializacion_simpleContext.class,0);
		}
		public Inicio_bucle_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio_bucle_for; }
	}

	public final Inicio_bucle_forContext inicio_bucle_for() throws RecognitionException {
		Inicio_bucle_forContext _localctx = new Inicio_bucle_forContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inicio_bucle_for);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__12:
			case T__13:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				((Inicio_bucle_forContext)_localctx).asignacion_sin_punto_coma = asignacion_sin_punto_coma();
				 _localctx.ast.add(((Inicio_bucle_forContext)_localctx).asignacion_sin_punto_coma.ast); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				((Inicio_bucle_forContext)_localctx).definicion_inicializacion_simple = definicion_inicializacion_simple();
				 _localctx.ast.addAll(((Inicio_bucle_forContext)_localctx).definicion_inicializacion_simple.ast); 
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
	public static class Definicion_inicializacion_simpleContext extends ParserRuleContext {
		public List<Sentencia> ast = new ArrayList<>();
		public Token ID;
		public TipoContext tipo;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Definicion_inicializacion_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion_inicializacion_simple; }
	}

	public final Definicion_inicializacion_simpleContext definicion_inicializacion_simple() throws RecognitionException {
		Definicion_inicializacion_simpleContext _localctx = new Definicion_inicializacion_simpleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_definicion_inicializacion_simple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__36);
			setState(258);
			((Definicion_inicializacion_simpleContext)_localctx).ID = match(ID);
			setState(259);
			match(T__4);
			setState(260);
			((Definicion_inicializacion_simpleContext)_localctx).tipo = tipo();
			setState(261);
			match(T__35);
			setState(262);
			((Definicion_inicializacion_simpleContext)_localctx).expression = expression(0);

			                Variable var = new Variable(((Definicion_inicializacion_simpleContext)_localctx).ID.getLine(), ((Definicion_inicializacion_simpleContext)_localctx).ID.getCharPositionInLine() + 1, (((Definicion_inicializacion_simpleContext)_localctx).ID!=null?((Definicion_inicializacion_simpleContext)_localctx).ID.getText():null));

			                _localctx.ast.add(new DefinicionVar(
			                    var.getLinea(),
			                    var.getColumna(),
			                    ((Definicion_inicializacion_simpleContext)_localctx).tipo.ast,
			                    var.getNombre()
			                ));

			                _localctx.ast.add(new Asignacion(
			                    var.getLinea(),
			                    var.getColumna(),
			                    var,
			                    ((Definicion_inicializacion_simpleContext)_localctx).expression.ast
			                ));
			            
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
		enterRule(_localctx, 14, RULE_cuerpo_condicional);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				match(T__6);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 171587433160712L) != 0)) {
					{
					{
					setState(266);
					((Cuerpo_condicionalContext)_localctx).statement = statement();
					 _localctx.ast.add(((Cuerpo_condicionalContext)_localctx).statement.ast); 
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(274);
				match(T__7);
				}
				break;
			case T__2:
			case T__12:
			case T__13:
			case T__27:
			case T__29:
			case T__30:
			case T__32:
			case T__33:
			case T__34:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
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
		enterRule(_localctx, 16, RULE_tipo_simple);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(T__37);
				 ((Tipo_simpleContext)_localctx).ast =  TipoInt.getInstance(); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(T__38);
				 ((Tipo_simpleContext)_localctx).ast =  TipoNumber.getInstance(); 
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(T__39);
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
		enterRule(_localctx, 18, RULE_tipo);
		int _la;
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(T__8);
				setState(289);
				((TipoContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(290);
				match(T__9);
				setState(291);
				((TipoContext)_localctx).tipo = tipo();

				                ((TipoContext)_localctx).ast =  new TipoArray(
				                    ((TipoContext)_localctx).tipo.ast,
				                    LexerHelper.lexemeToInt((((TipoContext)_localctx).INT_CONSTANT!=null?((TipoContext)_localctx).INT_CONSTANT.getText():null)));
				            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(T__8);
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(295);
					((TipoContext)_localctx).var_definition = var_definition();
					 _localctx.lineasDefiniciones.addAll(((TipoContext)_localctx).var_definition.ast); 
					}
					}
					setState(300); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__36 );
				setState(302);
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
				setState(305);
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
		enterRule(_localctx, 20, RULE_var_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(T__36);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(311);
					((Var_definitionContext)_localctx).ID1 = match(ID);
					setState(312);
					match(T__26);
					 _localctx.ids.add(new Variable(((Var_definitionContext)_localctx).ID1.getLine(), ((Var_definitionContext)_localctx).ID1.getCharPositionInLine() + 1, (((Var_definitionContext)_localctx).ID1!=null?((Var_definitionContext)_localctx).ID1.getText():null))); 
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(319);
			((Var_definitionContext)_localctx).ID2 = match(ID);
			 _localctx.ids.add(new Variable(((Var_definitionContext)_localctx).ID2.getLine(), ((Var_definitionContext)_localctx).ID2.getCharPositionInLine() + 1, (((Var_definitionContext)_localctx).ID2!=null?((Var_definitionContext)_localctx).ID2.getText():null))); 
			setState(321);
			match(T__4);
			setState(322);
			((Var_definitionContext)_localctx).tipo = tipo();
			setState(323);
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
		enterRule(_localctx, 22, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			((Function_definitionContext)_localctx).START = match(T__0);
			setState(327);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(328);
			((Function_definitionContext)_localctx).function_type = function_type();
			setState(329);
			match(T__6);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(330);
				((Function_definitionContext)_localctx).var_definition = var_definition();
				 _localctx.definicionesVariables.addAll(((Function_definitionContext)_localctx).var_definition.ast); 
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 171587433160712L) != 0)) {
				{
				{
				setState(338);
				((Function_definitionContext)_localctx).statement = statement();
				 _localctx.sentencias.add(((Function_definitionContext)_localctx).statement.ast); 
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(346);
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
		enterRule(_localctx, 24, RULE_function_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(T__2);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(356);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(350);
						((Function_typeContext)_localctx).param1 = function_param();
						setState(351);
						match(T__26);
						 _localctx.parametros.add(((Function_typeContext)_localctx).param1.ast); 
						}
						} 
					}
					setState(358);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(359);
				((Function_typeContext)_localctx).param2 = function_param();
				 _localctx.parametros.add(((Function_typeContext)_localctx).param2.ast); 
				}
			}

			setState(364);
			match(T__3);
			setState(365);
			match(T__4);
			setState(366);
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
		enterRule(_localctx, 26, RULE_function_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			((Function_paramContext)_localctx).ID = match(ID);
			setState(370);
			match(T__4);
			setState(371);
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
		enterRule(_localctx, 28, RULE_function_return_type);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
			case T__38:
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				((Function_return_typeContext)_localctx).tipo_simple = tipo_simple();

				                ((Function_return_typeContext)_localctx).ast =  ((Function_return_typeContext)_localctx).tipo_simple.ast;
				            
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
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
		"\u0004\u0001/\u017e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000%\b\u0000"+
		"\n\u0000\f\u0000(\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00018\b\u0001"+
		"\n\u0001\f\u0001;\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"@\b\u0001\n\u0001\f\u0001C\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002n\b\u0002\n\u0002\f\u0002q\t\u0002"+
		"\u0003\u0002s\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002w\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u0097\b\u0002\n\u0002\f\u0002\u009a\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00a1\b\u0003\n\u0003"+
		"\f\u0003\u00a4\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"\u00af\b\u0003\n\u0003\f\u0003\u00b2\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00c5\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003\u00db\b\u0003\n\u0003\f\u0003\u00de\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00e3\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u00f3\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0100\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u010e\b\u0007\n\u0007"+
		"\f\u0007\u0111\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0117\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u011f\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0004\t\u012b\b\t\u000b\t\f\t\u012c\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0135\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u013b\b\n\n\n\f\n\u013e\t\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u014e"+
		"\b\u000b\n\u000b\f\u000b\u0151\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u0156\b\u000b\n\u000b\f\u000b\u0159\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0163"+
		"\b\f\n\f\f\f\u0166\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u016b\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u017c\b\u000e\u0001\u000e\u0000\u0001\u0004\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0004\u0001"+
		"\u0000\u000f\u0011\u0002\u0000\r\r\u0012\u0012\u0001\u0000\u0013\u0018"+
		"\u0001\u0000\u0019\u001a\u019c\u0000&\u0001\u0000\u0000\u0000\u0002-\u0001"+
		"\u0000\u0000\u0000\u0004v\u0001\u0000\u0000\u0000\u0006\u00f2\u0001\u0000"+
		"\u0000\u0000\b\u00f4\u0001\u0000\u0000\u0000\n\u00ff\u0001\u0000\u0000"+
		"\u0000\f\u0101\u0001\u0000\u0000\u0000\u000e\u0116\u0001\u0000\u0000\u0000"+
		"\u0010\u011e\u0001\u0000\u0000\u0000\u0012\u0134\u0001\u0000\u0000\u0000"+
		"\u0014\u0136\u0001\u0000\u0000\u0000\u0016\u0146\u0001\u0000\u0000\u0000"+
		"\u0018\u015d\u0001\u0000\u0000\u0000\u001a\u0171\u0001\u0000\u0000\u0000"+
		"\u001c\u017b\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0014\n\u0000\u001f"+
		" \u0006\u0000\uffff\uffff\u0000 %\u0001\u0000\u0000\u0000!\"\u0003\u0016"+
		"\u000b\u0000\"#\u0006\u0000\uffff\uffff\u0000#%\u0001\u0000\u0000\u0000"+
		"$\u001e\u0001\u0000\u0000\u0000$!\u0001\u0000\u0000\u0000%(\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001"+
		"\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0003\u0002\u0001\u0000"+
		"*+\u0005\u0000\u0000\u0001+,\u0006\u0000\uffff\uffff\u0000,\u0001\u0001"+
		"\u0000\u0000\u0000-.\u0005\u0001\u0000\u0000./\u0005\u0002\u0000\u0000"+
		"/0\u0005\u0003\u0000\u000001\u0005\u0004\u0000\u000012\u0005\u0005\u0000"+
		"\u000023\u0005\u0006\u0000\u000039\u0005\u0007\u0000\u000045\u0003\u0014"+
		"\n\u000056\u0006\u0001\uffff\uffff\u000068\u0001\u0000\u0000\u000074\u0001"+
		"\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:A\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000<=\u0003\u0006\u0003\u0000=>\u0006\u0001\uffff\uffff\u0000>@\u0001"+
		"\u0000\u0000\u0000?<\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000DE\u0005\b\u0000\u0000EF\u0006\u0001\uffff"+
		"\uffff\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0006\u0002\uffff\uffff"+
		"\u0000HI\u0005*\u0000\u0000Iw\u0006\u0002\uffff\uffff\u0000JK\u0005+\u0000"+
		"\u0000Kw\u0006\u0002\uffff\uffff\u0000LM\u0005,\u0000\u0000Mw\u0006\u0002"+
		"\uffff\uffff\u0000NO\u0005/\u0000\u0000Ow\u0006\u0002\uffff\uffff\u0000"+
		"PQ\u0005\u0003\u0000\u0000QR\u0003\u0004\u0002\u0000RS\u0005\u0004\u0000"+
		"\u0000ST\u0006\u0002\uffff\uffff\u0000Tw\u0001\u0000\u0000\u0000UV\u0005"+
		"\u0003\u0000\u0000VW\u0003\u0004\u0002\u0000WX\u0005\f\u0000\u0000XY\u0003"+
		"\u0010\b\u0000YZ\u0005\u0004\u0000\u0000Z[\u0006\u0002\uffff\uffff\u0000"+
		"[w\u0001\u0000\u0000\u0000\\]\u0005\r\u0000\u0000]^\u0003\u0004\u0002"+
		"\u0007^_\u0006\u0002\uffff\uffff\u0000_w\u0001\u0000\u0000\u0000`a\u0005"+
		"\u000e\u0000\u0000ab\u0003\u0004\u0002\u0006bc\u0006\u0002\uffff\uffff"+
		"\u0000cw\u0001\u0000\u0000\u0000de\u0005/\u0000\u0000ef\u0006\u0002\uffff"+
		"\uffff\u0000fr\u0005\u0003\u0000\u0000gh\u0003\u0004\u0002\u0000ho\u0006"+
		"\u0002\uffff\uffff\u0000ij\u0005\u001b\u0000\u0000jk\u0003\u0004\u0002"+
		"\u0000kl\u0006\u0002\uffff\uffff\u0000ln\u0001\u0000\u0000\u0000mi\u0001"+
		"\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000rg\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0004\u0000\u0000uw\u0006\u0002\uffff\uffff\u0000"+
		"vG\u0001\u0000\u0000\u0000vJ\u0001\u0000\u0000\u0000vL\u0001\u0000\u0000"+
		"\u0000vN\u0001\u0000\u0000\u0000vP\u0001\u0000\u0000\u0000vU\u0001\u0000"+
		"\u0000\u0000v\\\u0001\u0000\u0000\u0000v`\u0001\u0000\u0000\u0000vd\u0001"+
		"\u0000\u0000\u0000w\u0098\u0001\u0000\u0000\u0000xy\n\u0005\u0000\u0000"+
		"yz\u0007\u0000\u0000\u0000z{\u0003\u0004\u0002\u0006{|\u0006\u0002\uffff"+
		"\uffff\u0000|\u0097\u0001\u0000\u0000\u0000}~\n\u0004\u0000\u0000~\u007f"+
		"\u0007\u0001\u0000\u0000\u007f\u0080\u0003\u0004\u0002\u0005\u0080\u0081"+
		"\u0006\u0002\uffff\uffff\u0000\u0081\u0097\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\n\u0003\u0000\u0000\u0083\u0084\u0007\u0002\u0000\u0000\u0084\u0085"+
		"\u0003\u0004\u0002\u0004\u0085\u0086\u0006\u0002\uffff\uffff\u0000\u0086"+
		"\u0097\u0001\u0000\u0000\u0000\u0087\u0088\n\u0002\u0000\u0000\u0088\u0089"+
		"\u0007\u0003\u0000\u0000\u0089\u008a\u0003\u0004\u0002\u0003\u008a\u008b"+
		"\u0006\u0002\uffff\uffff\u0000\u008b\u0097\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\n\n\u0000\u0000\u008d\u008e\u0005\t\u0000\u0000\u008e\u008f\u0003"+
		"\u0004\u0002\u0000\u008f\u0090\u0005\n\u0000\u0000\u0090\u0091\u0006\u0002"+
		"\uffff\uffff\u0000\u0091\u0097\u0001\u0000\u0000\u0000\u0092\u0093\n\t"+
		"\u0000\u0000\u0093\u0094\u0005\u000b\u0000\u0000\u0094\u0095\u0005/\u0000"+
		"\u0000\u0095\u0097\u0006\u0002\uffff\uffff\u0000\u0096x\u0001\u0000\u0000"+
		"\u0000\u0096}\u0001\u0000\u0000\u0000\u0096\u0082\u0001\u0000\u0000\u0000"+
		"\u0096\u0087\u0001\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000\u0000"+
		"\u0096\u0092\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u0005\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u00a2\u0005\u001c\u0000\u0000\u009c\u009d\u0003\u0004\u0002\u0000"+
		"\u009d\u009e\u0005\u001b\u0000\u0000\u009e\u009f\u0006\u0003\uffff\uffff"+
		"\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009c\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\u0004\u0002"+
		"\u0000\u00a6\u00a7\u0005\u001d\u0000\u0000\u00a7\u00a8\u0006\u0003\uffff"+
		"\uffff\u0000\u00a8\u00f3\u0001\u0000\u0000\u0000\u00a9\u00b0\u0005\u001e"+
		"\u0000\u0000\u00aa\u00ab\u0003\u0004\u0002\u0000\u00ab\u00ac\u0005\u001b"+
		"\u0000\u0000\u00ac\u00ad\u0006\u0003\uffff\uffff\u0000\u00ad\u00af\u0001"+
		"\u0000\u0000\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00af\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0003\u0004\u0002\u0000\u00b4\u00b5\u0005"+
		"\u001d\u0000\u0000\u00b5\u00b6\u0006\u0003\uffff\uffff\u0000\u00b6\u00f3"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0003\b\u0004\u0000\u00b8\u00b9\u0005"+
		"\u001d\u0000\u0000\u00b9\u00ba\u0006\u0003\uffff\uffff\u0000\u00ba\u00f3"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u001f\u0000\u0000\u00bc\u00bd"+
		"\u0005\u0003\u0000\u0000\u00bd\u00be\u0003\u0004\u0002\u0000\u00be\u00bf"+
		"\u0005\u0004\u0000\u0000\u00bf\u00c4\u0003\u000e\u0007\u0000\u00c0\u00c1"+
		"\u0005 \u0000\u0000\u00c1\u00c2\u0003\u000e\u0007\u0000\u00c2\u00c3\u0006"+
		"\u0003\uffff\uffff\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0006\u0003\uffff\uffff\u0000\u00c7"+
		"\u00f3\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005!\u0000\u0000\u00c9\u00ca"+
		"\u0005\u0003\u0000\u0000\u00ca\u00cb\u0003\u0004\u0002\u0000\u00cb\u00cc"+
		"\u0005\u0004\u0000\u0000\u00cc\u00cd\u0003\u000e\u0007\u0000\u00cd\u00ce"+
		"\u0006\u0003\uffff\uffff\u0000\u00ce\u00f3\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005\"\u0000\u0000\u00d0\u00d1\u0003\u0004\u0002\u0000\u00d1\u00d2"+
		"\u0005\u001d\u0000\u0000\u00d2\u00d3\u0006\u0003\uffff\uffff\u0000\u00d3"+
		"\u00f3\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005/\u0000\u0000\u00d5\u00e2"+
		"\u0005\u0003\u0000\u0000\u00d6\u00d7\u0003\u0004\u0002\u0000\u00d7\u00d8"+
		"\u0005\u001b\u0000\u0000\u00d8\u00d9\u0006\u0003\uffff\uffff\u0000\u00d9"+
		"\u00db\u0001\u0000\u0000\u0000\u00da\u00d6\u0001\u0000\u0000\u0000\u00db"+
		"\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd\u00df\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df\u00e0\u0003\u0004\u0002\u0000\u00e0"+
		"\u00e1\u0006\u0003\uffff\uffff\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e2\u00dc\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u0004\u0000\u0000"+
		"\u00e5\u00e6\u0005\u001d\u0000\u0000\u00e6\u00f3\u0006\u0003\uffff\uffff"+
		"\u0000\u00e7\u00e8\u0005#\u0000\u0000\u00e8\u00e9\u0005\u0003\u0000\u0000"+
		"\u00e9\u00ea\u0003\n\u0005\u0000\u00ea\u00eb\u0005\u001d\u0000\u0000\u00eb"+
		"\u00ec\u0003\u0004\u0002\u0000\u00ec\u00ed\u0005\u001d\u0000\u0000\u00ed"+
		"\u00ee\u0003\b\u0004\u0000\u00ee\u00ef\u0005\u0004\u0000\u0000\u00ef\u00f0"+
		"\u0003\u000e\u0007\u0000\u00f0\u00f1\u0006\u0003\uffff\uffff\u0000\u00f1"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f2\u009b\u0001\u0000\u0000\u0000\u00f2"+
		"\u00a9\u0001\u0000\u0000\u0000\u00f2\u00b7\u0001\u0000\u0000\u0000\u00f2"+
		"\u00bb\u0001\u0000\u0000\u0000\u00f2\u00c8\u0001\u0000\u0000\u0000\u00f2"+
		"\u00cf\u0001\u0000\u0000\u0000\u00f2\u00d4\u0001\u0000\u0000\u0000\u00f2"+
		"\u00e7\u0001\u0000\u0000\u0000\u00f3\u0007\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0003\u0004\u0002\u0000\u00f5\u00f6\u0005$\u0000\u0000\u00f6\u00f7"+
		"\u0003\u0004\u0002\u0000\u00f7\u00f8\u0006\u0004\uffff\uffff\u0000\u00f8"+
		"\t\u0001\u0000\u0000\u0000\u00f9\u00fa\u0003\b\u0004\u0000\u00fa\u00fb"+
		"\u0006\u0005\uffff\uffff\u0000\u00fb\u0100\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0003\f\u0006\u0000\u00fd\u00fe\u0006\u0005\uffff\uffff\u0000\u00fe"+
		"\u0100\u0001\u0000\u0000\u0000\u00ff\u00f9\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fc\u0001\u0000\u0000\u0000\u0100\u000b\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0005%\u0000\u0000\u0102\u0103\u0005/\u0000\u0000\u0103\u0104\u0005"+
		"\u0005\u0000\u0000\u0104\u0105\u0003\u0012\t\u0000\u0105\u0106\u0005$"+
		"\u0000\u0000\u0106\u0107\u0003\u0004\u0002\u0000\u0107\u0108\u0006\u0006"+
		"\uffff\uffff\u0000\u0108\r\u0001\u0000\u0000\u0000\u0109\u010f\u0005\u0007"+
		"\u0000\u0000\u010a\u010b\u0003\u0006\u0003\u0000\u010b\u010c\u0006\u0007"+
		"\uffff\uffff\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u010a\u0001"+
		"\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0112\u0001"+
		"\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0117\u0005"+
		"\b\u0000\u0000\u0113\u0114\u0003\u0006\u0003\u0000\u0114\u0115\u0006\u0007"+
		"\uffff\uffff\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0109\u0001"+
		"\u0000\u0000\u0000\u0116\u0113\u0001\u0000\u0000\u0000\u0117\u000f\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0005&\u0000\u0000\u0119\u011f\u0006\b"+
		"\uffff\uffff\u0000\u011a\u011b\u0005\'\u0000\u0000\u011b\u011f\u0006\b"+
		"\uffff\uffff\u0000\u011c\u011d\u0005(\u0000\u0000\u011d\u011f\u0006\b"+
		"\uffff\uffff\u0000\u011e\u0118\u0001\u0000\u0000\u0000\u011e\u011a\u0001"+
		"\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0011\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005\t\u0000\u0000\u0121\u0122\u0005*"+
		"\u0000\u0000\u0122\u0123\u0005\n\u0000\u0000\u0123\u0124\u0003\u0012\t"+
		"\u0000\u0124\u0125\u0006\t\uffff\uffff\u0000\u0125\u0135\u0001\u0000\u0000"+
		"\u0000\u0126\u012a\u0005\t\u0000\u0000\u0127\u0128\u0003\u0014\n\u0000"+
		"\u0128\u0129\u0006\t\uffff\uffff\u0000\u0129\u012b\u0001\u0000\u0000\u0000"+
		"\u012a\u0127\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000"+
		"\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000"+
		"\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0005\n\u0000\u0000\u012f"+
		"\u0130\u0006\t\uffff\uffff\u0000\u0130\u0135\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0003\u0010\b\u0000\u0132\u0133\u0006\t\uffff\uffff\u0000\u0133"+
		"\u0135\u0001\u0000\u0000\u0000\u0134\u0120\u0001\u0000\u0000\u0000\u0134"+
		"\u0126\u0001\u0000\u0000\u0000\u0134\u0131\u0001\u0000\u0000\u0000\u0135"+
		"\u0013\u0001\u0000\u0000\u0000\u0136\u013c\u0005%\u0000\u0000\u0137\u0138"+
		"\u0005/\u0000\u0000\u0138\u0139\u0005\u001b\u0000\u0000\u0139\u013b\u0006"+
		"\n\uffff\uffff\u0000\u013a\u0137\u0001\u0000\u0000\u0000\u013b\u013e\u0001"+
		"\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013d\u0001"+
		"\u0000\u0000\u0000\u013d\u013f\u0001\u0000\u0000\u0000\u013e\u013c\u0001"+
		"\u0000\u0000\u0000\u013f\u0140\u0005/\u0000\u0000\u0140\u0141\u0006\n"+
		"\uffff\uffff\u0000\u0141\u0142\u0005\u0005\u0000\u0000\u0142\u0143\u0003"+
		"\u0012\t\u0000\u0143\u0144\u0005\u001d\u0000\u0000\u0144\u0145\u0006\n"+
		"\uffff\uffff\u0000\u0145\u0015\u0001\u0000\u0000\u0000\u0146\u0147\u0005"+
		"\u0001\u0000\u0000\u0147\u0148\u0005/\u0000\u0000\u0148\u0149\u0003\u0018"+
		"\f\u0000\u0149\u014f\u0005\u0007\u0000\u0000\u014a\u014b\u0003\u0014\n"+
		"\u0000\u014b\u014c\u0006\u000b\uffff\uffff\u0000\u014c\u014e\u0001\u0000"+
		"\u0000\u0000\u014d\u014a\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000"+
		"\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000"+
		"\u0000\u0000\u0150\u0157\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000"+
		"\u0000\u0000\u0152\u0153\u0003\u0006\u0003\u0000\u0153\u0154\u0006\u000b"+
		"\uffff\uffff\u0000\u0154\u0156\u0001\u0000\u0000\u0000\u0155\u0152\u0001"+
		"\u0000\u0000\u0000\u0156\u0159\u0001\u0000\u0000\u0000\u0157\u0155\u0001"+
		"\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u015a\u0001"+
		"\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u015a\u015b\u0005"+
		"\b\u0000\u0000\u015b\u015c\u0006\u000b\uffff\uffff\u0000\u015c\u0017\u0001"+
		"\u0000\u0000\u0000\u015d\u016a\u0005\u0003\u0000\u0000\u015e\u015f\u0003"+
		"\u001a\r\u0000\u015f\u0160\u0005\u001b\u0000\u0000\u0160\u0161\u0006\f"+
		"\uffff\uffff\u0000\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u015e\u0001"+
		"\u0000\u0000\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162\u0001"+
		"\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0167\u0001"+
		"\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u0168\u0003"+
		"\u001a\r\u0000\u0168\u0169\u0006\f\uffff\uffff\u0000\u0169\u016b\u0001"+
		"\u0000\u0000\u0000\u016a\u0164\u0001\u0000\u0000\u0000\u016a\u016b\u0001"+
		"\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016d\u0005"+
		"\u0004\u0000\u0000\u016d\u016e\u0005\u0005\u0000\u0000\u016e\u016f\u0003"+
		"\u001c\u000e\u0000\u016f\u0170\u0006\f\uffff\uffff\u0000\u0170\u0019\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0005/\u0000\u0000\u0172\u0173\u0005\u0005"+
		"\u0000\u0000\u0173\u0174\u0003\u0010\b\u0000\u0174\u0175\u0006\r\uffff"+
		"\uffff\u0000\u0175\u001b\u0001\u0000\u0000\u0000\u0176\u0177\u0003\u0010"+
		"\b\u0000\u0177\u0178\u0006\u000e\uffff\uffff\u0000\u0178\u017c\u0001\u0000"+
		"\u0000\u0000\u0179\u017a\u0005\u0006\u0000\u0000\u017a\u017c\u0006\u000e"+
		"\uffff\uffff\u0000\u017b\u0176\u0001\u0000\u0000\u0000\u017b\u0179\u0001"+
		"\u0000\u0000\u0000\u017c\u001d\u0001\u0000\u0000\u0000\u001b$&9Aorv\u0096"+
		"\u0098\u00a2\u00b0\u00c4\u00dc\u00e2\u00f2\u00ff\u010f\u0116\u011e\u012c"+
		"\u0134\u013c\u014f\u0157\u0164\u016a\u017b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}