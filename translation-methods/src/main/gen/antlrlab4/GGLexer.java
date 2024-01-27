// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/antlrlab4/GG.g4 by ANTLR 4.13.1
package antlrlab4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GGLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, COLON=2, SINGLE_QUOTE=3, OR=4, MAYBE=5, ALO=6, SOBRACKET=7, 
		SCBRACKET=8, WORD=9, NOT_CAPS_WORD=10, CAPS_WORD=11, CHAR=12, REGEX=13, 
		WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SEMICOLON", "COLON", "SINGLE_QUOTE", "OR", "MAYBE", "ALO", "SOBRACKET", 
			"SCBRACKET", "WORD", "NOT_CAPS_WORD", "CAPS_WORD", "CHAR", "REGEX", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "'''", "'|'", "'*'", "'+'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEMICOLON", "COLON", "SINGLE_QUOTE", "OR", "MAYBE", "ALO", "SOBRACKET", 
			"SCBRACKET", "WORD", "NOT_CAPS_WORD", "CAPS_WORD", "CHAR", "REGEX", "WS"
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


	public GGLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GG.g4"; }

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
		"\u0004\u0000\u000eP\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b0\b\b\n\b\f\b3\t\b\u0001\t\u0001"+
		"\t\u0005\t7\b\t\n\t\f\t:\t\t\u0001\n\u0001\n\u0005\n>\b\n\n\n\f\nA\t\n"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\fG\b\f\u000b\f\f\fH\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000"+
		"\u0007\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000__az\u0001\u0000"+
		"AZ\u0003\u000009AZ__\u0001\u0000\'\'\u0003\u0000\t\n\r\r  S\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000"+
		"\u0000\u0000\u0003\u001f\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000"+
		"\u0000\u0007#\u0001\u0000\u0000\u0000\t%\u0001\u0000\u0000\u0000\u000b"+
		"\'\u0001\u0000\u0000\u0000\r)\u0001\u0000\u0000\u0000\u000f+\u0001\u0000"+
		"\u0000\u0000\u0011-\u0001\u0000\u0000\u0000\u00134\u0001\u0000\u0000\u0000"+
		"\u0015;\u0001\u0000\u0000\u0000\u0017B\u0001\u0000\u0000\u0000\u0019D"+
		"\u0001\u0000\u0000\u0000\u001bL\u0001\u0000\u0000\u0000\u001d\u001e\u0005"+
		";\u0000\u0000\u001e\u0002\u0001\u0000\u0000\u0000\u001f \u0005:\u0000"+
		"\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005\'\u0000\u0000\"\u0006\u0001"+
		"\u0000\u0000\u0000#$\u0005|\u0000\u0000$\b\u0001\u0000\u0000\u0000%&\u0005"+
		"*\u0000\u0000&\n\u0001\u0000\u0000\u0000\'(\u0005+\u0000\u0000(\f\u0001"+
		"\u0000\u0000\u0000)*\u0005[\u0000\u0000*\u000e\u0001\u0000\u0000\u0000"+
		"+,\u0005]\u0000\u0000,\u0010\u0001\u0000\u0000\u0000-1\u0007\u0000\u0000"+
		"\u0000.0\u0007\u0001\u0000\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0012"+
		"\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000048\u0007\u0002\u0000"+
		"\u000057\u0007\u0001\u0000\u000065\u0001\u0000\u0000\u00007:\u0001\u0000"+
		"\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009\u0014"+
		"\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;?\u0007\u0003\u0000"+
		"\u0000<>\u0007\u0004\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0016"+
		"\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\t\u0000\u0000\u0000"+
		"C\u0018\u0001\u0000\u0000\u0000DF\u0005\'\u0000\u0000EG\b\u0005\u0000"+
		"\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0005"+
		"\'\u0000\u0000K\u001a\u0001\u0000\u0000\u0000LM\u0007\u0006\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NO\u0006\r\u0000\u0000O\u001c\u0001\u0000\u0000"+
		"\u0000\u0005\u000018?H\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}