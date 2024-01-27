// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/GG.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, COLON=2, SINGLE_QUOTE=3, OR=4, MAYBE=5, ALO=6, SOBRACKET=7, 
		SCBRACKET=8, WORD=9, NOT_CAPS_WORD=10, CAPS_WORD=11, CHAR=12, REGEX=13, 
		WS=14, DOT=15;
	public static final int
		RULE_term = 0, RULE_nonTerm = 1, RULE_dottedWord = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"term", "nonTerm", "dottedWord"
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
			"SCBRACKET", "WORD", "NOT_CAPS_WORD", "CAPS_WORD", "CHAR", "REGEX", "WS", 
			"DOT"
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
	public String getGrammarFileName() { return "GG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TerminalNode CAPS_WORD() { return getToken(GGParser.CAPS_WORD, 0); }
		public TerminalNode COLON() { return getToken(GGParser.COLON, 0); }
		public List<TerminalNode> SOBRACKET() { return getTokens(GGParser.SOBRACKET); }
		public TerminalNode SOBRACKET(int i) {
			return getToken(GGParser.SOBRACKET, i);
		}
		public TerminalNode REGEX() { return getToken(GGParser.REGEX, 0); }
		public TerminalNode SEMICOLON() { return getToken(GGParser.SEMICOLON, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GGListener ) ((GGListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GGListener ) ((GGListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GGVisitor ) return ((GGVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(CAPS_WORD);
			setState(7);
			match(COLON);
			setState(8);
			match(SOBRACKET);
			setState(9);
			match(REGEX);
			setState(10);
			match(SOBRACKET);
			setState(11);
			match(SEMICOLON);
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
	public static class NonTermContext extends ParserRuleContext {
		public TerminalNode NOT_CAPS_WORD() { return getToken(GGParser.NOT_CAPS_WORD, 0); }
		public TerminalNode COLON() { return getToken(GGParser.COLON, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NonTermContext nonTerm() {
			return getRuleContext(NonTermContext.class,0);
		}
		public TerminalNode ALO() { return getToken(GGParser.ALO, 0); }
		public TerminalNode MAYBE() { return getToken(GGParser.MAYBE, 0); }
		public NonTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GGListener ) ((GGListener)listener).enterNonTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GGListener ) ((GGListener)listener).exitNonTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GGVisitor ) return ((GGVisitor<? extends T>)visitor).visitNonTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTermContext nonTerm() throws RecognitionException {
		NonTermContext _localctx = new NonTermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nonTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			match(NOT_CAPS_WORD);
			setState(14);
			match(COLON);
			{
			setState(17);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAPS_WORD:
				{
				setState(15);
				term();
				}
				break;
			case NOT_CAPS_WORD:
				{
				setState(16);
				nonTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(20);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(19);
				_la = _input.LA(1);
				if ( !(_la==MAYBE || _la==ALO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
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
	public static class DottedWordContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(GGParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GGParser.WORD, i);
		}
		public List<TerminalNode> DOT() { return getTokens(GGParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GGParser.DOT, i);
		}
		public DottedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dottedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GGListener ) ((GGListener)listener).enterDottedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GGListener ) ((GGListener)listener).exitDottedWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GGVisitor ) return ((GGVisitor<? extends T>)visitor).visitDottedWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DottedWordContext dottedWord() throws RecognitionException {
		DottedWordContext _localctx = new DottedWordContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dottedWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(WORD);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(23);
				match(DOT);
				setState(24);
				match(WORD);
				}
				}
				setState(29);
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

	public static final String _serializedATN =
		"\u0004\u0001\u000f\u001f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0012\b\u0001\u0001\u0001\u0003\u0001\u0015\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u001a\b\u0002\n"+
		"\u0002\f\u0002\u001d\t\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002"+
		"\u0004\u0000\u0001\u0001\u0000\u0005\u0006\u001e\u0000\u0006\u0001\u0000"+
		"\u0000\u0000\u0002\r\u0001\u0000\u0000\u0000\u0004\u0016\u0001\u0000\u0000"+
		"\u0000\u0006\u0007\u0005\u000b\u0000\u0000\u0007\b\u0005\u0002\u0000\u0000"+
		"\b\t\u0005\u0007\u0000\u0000\t\n\u0005\r\u0000\u0000\n\u000b\u0005\u0007"+
		"\u0000\u0000\u000b\f\u0005\u0001\u0000\u0000\f\u0001\u0001\u0000\u0000"+
		"\u0000\r\u000e\u0005\n\u0000\u0000\u000e\u0011\u0005\u0002\u0000\u0000"+
		"\u000f\u0012\u0003\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000"+
		"\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0010\u0001\u0000\u0000\u0000"+
		"\u0012\u0014\u0001\u0000\u0000\u0000\u0013\u0015\u0007\u0000\u0000\u0000"+
		"\u0014\u0013\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000"+
		"\u0015\u0003\u0001\u0000\u0000\u0000\u0016\u001b\u0005\t\u0000\u0000\u0017"+
		"\u0018\u0005\u000f\u0000\u0000\u0018\u001a\u0005\t\u0000\u0000\u0019\u0017"+
		"\u0001\u0000\u0000\u0000\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0005"+
		"\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u0003\u0011"+
		"\u0014\u001b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}