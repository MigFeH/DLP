// Generated from C:/Users/uo287577/Desktop/DLP/Sesion 03/Proyecto/src/parser/TSmm.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TSmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITE_SPACES=1, INT_CONSTANT=2, REAL_CONSTANT=3, COMENTARIO_UNILINEA=4, 
		COMENTARIO_MULTILINEA=5, ID=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHITE_SPACES", "INT_CONSTANT", "REAL_CONSTANT", "MANTISA", "EXPONENTE", 
			"COMENTARIO_UNILINEA", "COMENTARIO_MULTILINEA", "ID", "LETRA", "DIGITO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITE_SPACES", "INT_CONSTANT", "REAL_CONSTANT", "COMENTARIO_UNILINEA", 
			"COMENTARIO_MULTILINEA", "ID"
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


	public TSmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TSmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0006^\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0017"+
		"\b\u0000\u000b\u0000\f\u0000\u0018\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0001"+
		"\u0001\u0003\u0001%\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002+\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u00059\b\u0005\n\u0005\f\u0005<\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006F\b\u0006\n\u0006\f\u0006I\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007R\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0004\u0007W\b\u0007\u000b\u0007\f\u0007X\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0002:G\u0000\n\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0000"+
		"\t\u0000\u000b\u0004\r\u0005\u000f\u0006\u0011\u0000\u0013\u0000\u0001"+
		"\u0000\u0006\u0003\u0000\t\n\r\r  \u0001\u000019\u0001\u000009\u0002\u0000"+
		"EEee\u0002\u0000++--\u0002\u0000AZazc\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0001\u0016\u0001\u0000\u0000\u0000\u0003"+
		"$\u0001\u0000\u0000\u0000\u0005*\u0001\u0000\u0000\u0000\u0007,\u0001"+
		"\u0000\u0000\u0000\t0\u0001\u0000\u0000\u0000\u000b4\u0001\u0000\u0000"+
		"\u0000\rA\u0001\u0000\u0000\u0000\u000fQ\u0001\u0000\u0000\u0000\u0011"+
		"Z\u0001\u0000\u0000\u0000\u0013\\\u0001\u0000\u0000\u0000\u0015\u0017"+
		"\u0007\u0000\u0000\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0006\u0000\u0000\u0000\u001b\u0002\u0001\u0000\u0000\u0000\u001c \u0007"+
		"\u0001\u0000\u0000\u001d\u001f\u0007\u0002\u0000\u0000\u001e\u001d\u0001"+
		"\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000 !\u0001\u0000\u0000\u0000!%\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000#%\u00050\u0000\u0000$\u001c\u0001\u0000\u0000\u0000"+
		"$#\u0001\u0000\u0000\u0000%\u0004\u0001\u0000\u0000\u0000&+\u0003\u0007"+
		"\u0003\u0000\'(\u0003\u0007\u0003\u0000()\u0003\t\u0004\u0000)+\u0001"+
		"\u0000\u0000\u0000*&\u0001\u0000\u0000\u0000*\'\u0001\u0000\u0000\u0000"+
		"+\u0006\u0001\u0000\u0000\u0000,-\u0003\u0003\u0001\u0000-.\u0005.\u0000"+
		"\u0000./\u0003\u0003\u0001\u0000/\b\u0001\u0000\u0000\u000001\u0007\u0003"+
		"\u0000\u000012\u0007\u0004\u0000\u000023\u0003\u0003\u0001\u00003\n\u0001"+
		"\u0000\u0000\u000045\u0005/\u0000\u000056\u0005/\u0000\u00006:\u0001\u0000"+
		"\u0000\u000079\t\u0000\u0000\u000087\u0001\u0000\u0000\u00009<\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;=\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005\n\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0006\u0005\u0000\u0000@\f\u0001\u0000\u0000\u0000"+
		"AB\u0005/\u0000\u0000BC\u0005*\u0000\u0000CG\u0001\u0000\u0000\u0000D"+
		"F\t\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JK\u0005*\u0000\u0000KL\u0005/\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MN\u0006\u0006\u0000\u0000N\u000e\u0001\u0000"+
		"\u0000\u0000OR\u0003\u0011\b\u0000PR\u0005_\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QP\u0001\u0000\u0000\u0000RV\u0001\u0000\u0000\u0000SW\u0003"+
		"\u0011\b\u0000TW\u0003\u0013\t\u0000UW\u0005_\u0000\u0000VS\u0001\u0000"+
		"\u0000\u0000VT\u0001\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"Y\u0010\u0001\u0000\u0000\u0000Z[\u0007\u0005\u0000\u0000[\u0012\u0001"+
		"\u0000\u0000\u0000\\]\u0007\u0002\u0000\u0000]\u0014\u0001\u0000\u0000"+
		"\u0000\n\u0000\u0018 $*:GQVX\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}