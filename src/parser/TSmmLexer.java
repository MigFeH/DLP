// Generated from C:/Users/uo287577/Desktop/DLP/Proyecto/lab-dlp/src/parser/TSmm.g4 by ANTLR 4.13.2
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
		WHITE_SPACES=1, INT_CONSTANT=2, REAL_CONSTANT=3, CHAR_CONSTANT=4, COMENTARIO_UNILINEA=5, 
		COMENTARIO_MULTILINEA=6, ID=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHITE_SPACES", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "EXPONENTE", 
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
			null, "WHITE_SPACES", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"COMENTARIO_UNILINEA", "COMENTARIO_MULTILINEA", "ID"
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
		"\u0004\u0000\u0007\u0090\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000"+
		"\u0017\b\u0000\u000b\u0000\f\u0000\u0018\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001"+
		"\u0001\u0001\u0003\u0001%\b\u0001\u0001\u0002\u0005\u0002(\b\u0002\n\u0002"+
		"\f\u0002+\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002/\b\u0002\n\u0002"+
		"\f\u00022\t\u0002\u0001\u0002\u0005\u00025\b\u0002\n\u0002\f\u00028\t"+
		"\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0002\u0003\u0002D\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"L\b\u0003\u000b\u0003\f\u0003M\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\\\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004`\b\u0004\u0001\u0004\u0004\u0004c\b\u0004\u000b\u0004"+
		"\f\u0004d\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"k\b\u0005\n\u0005\f\u0005n\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"x\b\u0006\n\u0006\f\u0006{\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u0084\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u0089\b\u0007\u000b\u0007"+
		"\f\u0007\u008a\u0001\b\u0001\b\u0001\t\u0001\t\u0002ly\u0000\n\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0000\u000b\u0005\r\u0006\u000f"+
		"\u0007\u0011\u0000\u0013\u0000\u0001\u0000\u0006\u0003\u0000\t\n\r\r "+
		" \u0001\u000019\u0001\u000009\u0002\u0000EEee\u0002\u0000++--\u0002\u0000"+
		"AZaz\u00a1\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001\u0016\u0001\u0000\u0000"+
		"\u0000\u0003$\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007"+
		"[\u0001\u0000\u0000\u0000\t]\u0001\u0000\u0000\u0000\u000bf\u0001\u0000"+
		"\u0000\u0000\rs\u0001\u0000\u0000\u0000\u000f\u0083\u0001\u0000\u0000"+
		"\u0000\u0011\u008c\u0001\u0000\u0000\u0000\u0013\u008e\u0001\u0000\u0000"+
		"\u0000\u0015\u0017\u0007\u0000\u0000\u0000\u0016\u0015\u0001\u0000\u0000"+
		"\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000"+
		"\u0000\u001a\u001b\u0006\u0000\u0000\u0000\u001b\u0002\u0001\u0000\u0000"+
		"\u0000\u001c \u0007\u0001\u0000\u0000\u001d\u001f\u0007\u0002\u0000\u0000"+
		"\u001e\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 "+
		"\u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!%\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000#%\u00050\u0000\u0000$\u001c\u0001"+
		"\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%\u0004\u0001\u0000\u0000"+
		"\u0000&(\u0003\u0013\t\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000"+
		"\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,0\u0005.\u0000\u0000-/\u0003"+
		"\u0013\t\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u00001D\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000035\u0003\u0013\t\u000043\u0001\u0000\u0000\u0000"+
		"58\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009;\u0005.\u0000"+
		"\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;?\u0001\u0000"+
		"\u0000\u0000<>\u0003\u0013\t\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BD\u0003\t\u0004\u0000C)\u0001"+
		"\u0000\u0000\u0000C6\u0001\u0000\u0000\u0000D\u0006\u0001\u0000\u0000"+
		"\u0000EF\u0005\'\u0000\u0000FG\t\u0000\u0000\u0000G\\\u0005\'\u0000\u0000"+
		"HI\u0005\'\u0000\u0000IK\u0005\\\u0000\u0000JL\u0003\u0013\t\u0000KJ\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0005\'\u0000\u0000"+
		"P\\\u0001\u0000\u0000\u0000QR\u0005\'\u0000\u0000RS\u0005\\\u0000\u0000"+
		"ST\u0005n\u0000\u0000TU\u0001\u0000\u0000\u0000U\\\u0005\'\u0000\u0000"+
		"VW\u0005\'\u0000\u0000WX\u0005\\\u0000\u0000XY\u0005t\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\\\u0005\'\u0000\u0000[E\u0001\u0000\u0000\u0000[H"+
		"\u0001\u0000\u0000\u0000[Q\u0001\u0000\u0000\u0000[V\u0001\u0000\u0000"+
		"\u0000\\\b\u0001\u0000\u0000\u0000]_\u0007\u0003\u0000\u0000^`\u0007\u0004"+
		"\u0000\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001"+
		"\u0000\u0000\u0000ac\u0003\u0013\t\u0000ba\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"e\n\u0001\u0000\u0000\u0000fg\u0005/\u0000\u0000gh\u0005/\u0000\u0000"+
		"hl\u0001\u0000\u0000\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000"+
		"kn\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\n\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qr\u0006\u0005\u0000\u0000r\f\u0001\u0000"+
		"\u0000\u0000st\u0005/\u0000\u0000tu\u0005*\u0000\u0000uy\u0001\u0000\u0000"+
		"\u0000vx\t\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z|\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000|}\u0005*\u0000\u0000}~\u0005/\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0006\u0006\u0000\u0000"+
		"\u0080\u000e\u0001\u0000\u0000\u0000\u0081\u0084\u0003\u0011\b\u0000\u0082"+
		"\u0084\u0005_\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0088\u0001\u0000\u0000\u0000\u0085\u0089"+
		"\u0003\u0011\b\u0000\u0086\u0089\u0003\u0013\t\u0000\u0087\u0089\u0005"+
		"_\u0000\u0000\u0088\u0085\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u0010\u0001\u0000\u0000\u0000\u008c\u008d\u0007\u0005"+
		"\u0000\u0000\u008d\u0012\u0001\u0000\u0000\u0000\u008e\u008f\u0007\u0002"+
		"\u0000\u0000\u008f\u0014\u0001\u0000\u0000\u0000\u0013\u0000\u0018 $)"+
		"06:?CM[_dly\u0083\u0088\u008a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}