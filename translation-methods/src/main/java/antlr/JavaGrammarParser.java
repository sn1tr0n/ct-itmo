// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/antlr/JavaGrammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NEW=2, FOR=3, WHILE=4, VOID=5, IMPORT=6, PACKAGE=7, CLASS=8, IF=9, 
		ELSE=10, DIG=11, INTEGER=12, FLOATING=13, PLUS=14, MINUS=15, MULTIPLY=16, 
		DIVIDE=17, EQUAL=18, NEQ=19, GREATEROr_EQ=20, LESSOr_EQ=21, MOD=22, INC=23, 
		DEC=24, UN_NOT=25, BIN_AND=26, BINOr=27, AND=28, OR=29, NOT=30, QUESTION_MARK=31, 
		PUBLIC=32, PRIVATE=33, PROTECTED=34, ABSTRACT=35, FINAL=36, THROWS=37, 
		RETURN=38, STATIC=39, EXTENDS=40, SUPER=41, LBRACKET=42, RBRACKET=43, 
		LSBRACKET=44, RSBRACKET=45, LCBRACKET=46, RCBRACKET=47, LTBRACKET=48, 
		RTBRACKET=49, SEMICOLON=50, EQ=51, DOT=52, COMMA=53, QUOTE=54, WORD=55, 
		WS=56;
	public static final int
		RULE_result = 0, RULE_packageBlock = 1, RULE_importBlock = 2, RULE_variableDefinition = 3, 
		RULE_variableStatement = 4, RULE_objectCall = 5, RULE_arg = 6, RULE_argList = 7, 
		RULE_className = 8, RULE_classModifiers = 9, RULE_notPublicModifiers = 10, 
		RULE_class_static = 11, RULE_inner_classDefinition = 12, RULE_defModifier = 13, 
		RULE_class_var_def = 14, RULE_classDefinition = 15, RULE_constructorDefinition = 16, 
		RULE_functionDefinition = 17, RULE_returnExpression = 18, RULE_funcBlock = 19, 
		RULE_static_var = 20, RULE_expression = 21, RULE_type = 22, RULE_number = 23, 
		RULE_notQuoteWord = 24, RULE_stringLiteral = 25, RULE_varName = 26, RULE_expressionList = 27, 
		RULE_funcType = 28, RULE_funcName = 29, RULE_funcCall = 30, RULE_booleanExpr = 31, 
		RULE_ifBlock = 32, RULE_elseBlock = 33, RULE_ifDefinition = 34, RULE_exprOrStatement = 35, 
		RULE_forDefinition = 36, RULE_whileDefinition = 37, RULE_genericDefenitionBlock = 38, 
		RULE_genericUsageBlock = 39, RULE_genericConstructorBlock = 40, RULE_genericWildcardTypeParameter = 41, 
		RULE_typeParameterConstraint = 42, RULE_operator = 43, RULE_booleanOperator = 44, 
		RULE_unaryOperator = 45, RULE_incDec = 46, RULE_boolean_composer = 47, 
		RULE_dottedWords = 48, RULE_throwsGroup = 49, RULE_modifier = 50, RULE_static = 51, 
		RULE_dottedWord = 52;
	private static String[] makeRuleNames() {
		return new String[] {
			"result", "packageBlock", "importBlock", "variableDefinition", "variableStatement", 
			"objectCall", "arg", "argList", "className", "classModifiers", "notPublicModifiers", 
			"class_static", "inner_classDefinition", "defModifier", "class_var_def", 
			"classDefinition", "constructorDefinition", "functionDefinition", "returnExpression", 
			"funcBlock", "static_var", "expression", "type", "number", "notQuoteWord", 
			"stringLiteral", "varName", "expressionList", "funcType", "funcName", 
			"funcCall", "booleanExpr", "ifBlock", "elseBlock", "ifDefinition", "exprOrStatement", 
			"forDefinition", "whileDefinition", "genericDefenitionBlock", "genericUsageBlock", 
			"genericConstructorBlock", "genericWildcardTypeParameter", "typeParameterConstraint", 
			"operator", "booleanOperator", "unaryOperator", "incDec", "boolean_composer", 
			"dottedWords", "throwsGroup", "modifier", "static", "dottedWord"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[]'", "'new'", "'for'", "'while'", "'void'", "'import'", "'package'", 
			"'class'", "'if'", "'else'", null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'=='", "'!='", "'>='", "'<='", "'%'", "'++'", "'--'", "'~'", "'&'", 
			"'|'", "'&&'", "'||'", "'!'", "'?'", "'public'", "'private'", "'protected'", 
			"'abstract'", "'final'", "'throws'", "'return'", "'static'", "'extends'", 
			"'super'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'", "';'", 
			"'='", "'.'", "','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NEW", "FOR", "WHILE", "VOID", "IMPORT", "PACKAGE", "CLASS", 
			"IF", "ELSE", "DIG", "INTEGER", "FLOATING", "PLUS", "MINUS", "MULTIPLY", 
			"DIVIDE", "EQUAL", "NEQ", "GREATEROr_EQ", "LESSOr_EQ", "MOD", "INC", 
			"DEC", "UN_NOT", "BIN_AND", "BINOr", "AND", "OR", "NOT", "QUESTION_MARK", 
			"PUBLIC", "PRIVATE", "PROTECTED", "ABSTRACT", "FINAL", "THROWS", "RETURN", 
			"STATIC", "EXTENDS", "SUPER", "LBRACKET", "RBRACKET", "LSBRACKET", "RSBRACKET", 
			"LCBRACKET", "RCBRACKET", "LTBRACKET", "RTBRACKET", "SEMICOLON", "EQ", 
			"DOT", "COMMA", "QUOTE", "WORD", "WS"
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
	public String getGrammarFileName() { return "JavaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResultContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JavaGrammarParser.EOF, 0); }
		public PackageBlockContext packageBlock() {
			return getRuleContext(PackageBlockContext.class,0);
		}
		public ImportBlockContext importBlock() {
			return getRuleContext(ImportBlockContext.class,0);
		}
		public ClassDefinitionContext classDefinition() {
			return getRuleContext(ClassDefinitionContext.class,0);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_result);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(106);
				packageBlock();
				}
			}

			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(109);
				importBlock();
				}
				break;
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 133143986432L) != 0)) {
				{
				setState(112);
				classDefinition();
				}
			}

			setState(115);
			match(EOF);
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
	public static class PackageBlockContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(JavaGrammarParser.PACKAGE, 0); }
		public DottedWordContext dottedWord() {
			return getRuleContext(DottedWordContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(JavaGrammarParser.SEMICOLON, 0); }
		public PackageBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterPackageBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitPackageBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitPackageBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageBlockContext packageBlock() throws RecognitionException {
		PackageBlockContext _localctx = new PackageBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(PACKAGE);
			setState(118);
			dottedWord();
			setState(119);
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
	public static class ImportBlockContext extends ParserRuleContext {
		public List<TerminalNode> IMPORT() { return getTokens(JavaGrammarParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(JavaGrammarParser.IMPORT, i);
		}
		public List<DottedWordContext> dottedWord() {
			return getRuleContexts(DottedWordContext.class);
		}
		public DottedWordContext dottedWord(int i) {
			return getRuleContext(DottedWordContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(JavaGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavaGrammarParser.SEMICOLON, i);
		}
		public ImportBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterImportBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitImportBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitImportBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportBlockContext importBlock() throws RecognitionException {
		ImportBlockContext _localctx = new ImportBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(121);
				match(IMPORT);
				setState(122);
				dottedWord();
				setState(123);
				match(SEMICOLON);
				}
				}
				setState(129);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public GenericUsageBlockContext genericUsageBlock() {
			return getRuleContext(GenericUsageBlockContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			type();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LTBRACKET) {
				{
				setState(131);
				genericUsageBlock();
				}
			}

			setState(134);
			variableStatement();
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
	public static class VariableStatementContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(JavaGrammarParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableStatementContext variableStatement() throws RecognitionException {
		VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			varName();
			setState(137);
			match(EQ);
			setState(138);
			expression(0);
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
	public static class ObjectCallContext extends ParserRuleContext {
		public DottedWordContext dottedWord() {
			return getRuleContext(DottedWordContext.class,0);
		}
		public TerminalNode DOT() { return getToken(JavaGrammarParser.DOT, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ObjectCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterObjectCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitObjectCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitObjectCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectCallContext objectCall() throws RecognitionException {
		ObjectCallContext _localctx = new ObjectCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objectCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			dottedWord();
			setState(141);
			match(DOT);
			setState(142);
			funcCall();
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
	public static class ArgContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public GenericUsageBlockContext genericUsageBlock() {
			return getRuleContext(GenericUsageBlockContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			type();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LTBRACKET) {
				{
				setState(145);
				genericUsageBlock();
				}
			}

			setState(148);
			varName();
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
	public static class ArgListContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			arg();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(151);
				match(COMMA);
				setState(152);
				arg();
				}
				}
				setState(157);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(WORD);
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
	public static class ClassModifiersContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(JavaGrammarParser.ABSTRACT, 0); }
		public TerminalNode FINAL() { return getToken(JavaGrammarParser.FINAL, 0); }
		public ClassModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClassModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClassModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClassModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifiersContext classModifiers() throws RecognitionException {
		ClassModifiersContext _localctx = new ClassModifiersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !(_la==ABSTRACT || _la==FINAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class NotPublicModifiersContext extends ParserRuleContext {
		public TerminalNode PROTECTED() { return getToken(JavaGrammarParser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(JavaGrammarParser.PRIVATE, 0); }
		public NotPublicModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notPublicModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterNotPublicModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitNotPublicModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitNotPublicModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotPublicModifiersContext notPublicModifiers() throws RecognitionException {
		NotPublicModifiersContext _localctx = new NotPublicModifiersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_notPublicModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==PRIVATE || _la==PROTECTED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Class_staticContext extends ParserRuleContext {
		public StaticContext static_() {
			return getRuleContext(StaticContext.class,0);
		}
		public Class_staticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_static; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClass_static(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClass_static(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClass_static(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_staticContext class_static() throws RecognitionException {
		Class_staticContext _localctx = new Class_staticContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_class_static);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			static_();
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
	public static class Inner_classDefinitionContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(JavaGrammarParser.CLASS, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode LCBRACKET() { return getToken(JavaGrammarParser.LCBRACKET, 0); }
		public TerminalNode RCBRACKET() { return getToken(JavaGrammarParser.RCBRACKET, 0); }
		public NotPublicModifiersContext notPublicModifiers() {
			return getRuleContext(NotPublicModifiersContext.class,0);
		}
		public Class_staticContext class_static() {
			return getRuleContext(Class_staticContext.class,0);
		}
		public ClassModifiersContext classModifiers() {
			return getRuleContext(ClassModifiersContext.class,0);
		}
		public GenericDefenitionBlockContext genericDefenitionBlock() {
			return getRuleContext(GenericDefenitionBlockContext.class,0);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ConstructorDefinitionContext> constructorDefinition() {
			return getRuleContexts(ConstructorDefinitionContext.class);
		}
		public ConstructorDefinitionContext constructorDefinition(int i) {
			return getRuleContext(ConstructorDefinitionContext.class,i);
		}
		public List<Inner_classDefinitionContext> inner_classDefinition() {
			return getRuleContexts(Inner_classDefinitionContext.class);
		}
		public Inner_classDefinitionContext inner_classDefinition(int i) {
			return getRuleContext(Inner_classDefinitionContext.class,i);
		}
		public List<Class_var_defContext> class_var_def() {
			return getRuleContexts(Class_var_defContext.class);
		}
		public Class_var_defContext class_var_def(int i) {
			return getRuleContext(Class_var_defContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(JavaGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavaGrammarParser.SEMICOLON, i);
		}
		public Inner_classDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inner_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterInner_classDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitInner_classDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitInner_classDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inner_classDefinitionContext inner_classDefinition() throws RecognitionException {
		Inner_classDefinitionContext _localctx = new Inner_classDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inner_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIVATE || _la==PROTECTED) {
				{
				setState(166);
				notPublicModifiers();
				}
			}

			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(169);
				class_static();
				}
			}

			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ABSTRACT || _la==FINAL) {
				{
				setState(172);
				classModifiers();
				}
			}

			setState(175);
			match(CLASS);
			setState(176);
			className();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LTBRACKET) {
				{
				setState(177);
				genericDefenitionBlock();
				}
			}

			setState(180);
			match(LCBRACKET);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36310954895474976L) != 0)) {
				{
				setState(187);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(181);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(182);
					constructorDefinition();
					}
					break;
				case 3:
					{
					{
					setState(183);
					class_var_def();
					setState(184);
					match(SEMICOLON);
					}
					}
					break;
				case 4:
					{
					setState(186);
					inner_classDefinition();
					}
					break;
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(RCBRACKET);
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
	public static class DefModifierContext extends ParserRuleContext {
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public DefModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterDefModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitDefModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitDefModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefModifierContext defModifier() throws RecognitionException {
		DefModifierContext _localctx = new DefModifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			modifier();
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
	public static class Class_var_defContext extends ParserRuleContext {
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public StaticContext static_() {
			return getRuleContext(StaticContext.class,0);
		}
		public Class_var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClass_var_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClass_var_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClass_var_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_var_defContext class_var_def() throws RecognitionException {
		Class_var_defContext _localctx = new Class_var_defContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_class_var_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) {
				{
				setState(196);
				modifier();
				}
			}

			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(199);
				static_();
				}
			}

			setState(202);
			variableDefinition();
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
	public static class ClassDefinitionContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(JavaGrammarParser.CLASS, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode LCBRACKET() { return getToken(JavaGrammarParser.LCBRACKET, 0); }
		public TerminalNode RCBRACKET() { return getToken(JavaGrammarParser.RCBRACKET, 0); }
		public DefModifierContext defModifier() {
			return getRuleContext(DefModifierContext.class,0);
		}
		public ClassModifiersContext classModifiers() {
			return getRuleContext(ClassModifiersContext.class,0);
		}
		public GenericDefenitionBlockContext genericDefenitionBlock() {
			return getRuleContext(GenericDefenitionBlockContext.class,0);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ConstructorDefinitionContext> constructorDefinition() {
			return getRuleContexts(ConstructorDefinitionContext.class);
		}
		public ConstructorDefinitionContext constructorDefinition(int i) {
			return getRuleContext(ConstructorDefinitionContext.class,i);
		}
		public List<Inner_classDefinitionContext> inner_classDefinition() {
			return getRuleContexts(Inner_classDefinitionContext.class);
		}
		public Inner_classDefinitionContext inner_classDefinition(int i) {
			return getRuleContext(Inner_classDefinitionContext.class,i);
		}
		public List<Class_var_defContext> class_var_def() {
			return getRuleContexts(Class_var_defContext.class);
		}
		public Class_var_defContext class_var_def(int i) {
			return getRuleContext(Class_var_defContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(JavaGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavaGrammarParser.SEMICOLON, i);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClassDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClassDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) {
				{
				setState(204);
				defModifier();
				}
			}

			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ABSTRACT || _la==FINAL) {
				{
				setState(207);
				classModifiers();
				}
			}

			setState(210);
			match(CLASS);
			setState(211);
			className();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LTBRACKET) {
				{
				setState(212);
				genericDefenitionBlock();
				}
			}

			setState(215);
			match(LCBRACKET);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36310954895474976L) != 0)) {
				{
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(216);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(217);
					constructorDefinition();
					}
					break;
				case 3:
					{
					{
					setState(218);
					class_var_def();
					setState(219);
					match(SEMICOLON);
					}
					}
					break;
				case 4:
					{
					setState(221);
					inner_classDefinition();
					}
					break;
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(RCBRACKET);
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
	public static class ConstructorDefinitionContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ThrowsGroupContext throwsGroup() {
			return getRuleContext(ThrowsGroupContext.class,0);
		}
		public ConstructorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterConstructorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitConstructorDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitConstructorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDefinitionContext constructorDefinition() throws RecognitionException {
		ConstructorDefinitionContext _localctx = new ConstructorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constructorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) {
				{
				setState(229);
				modifier();
				}
			}

			setState(232);
			className();
			setState(233);
			match(LBRACKET);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(234);
				argList();
				}
			}

			setState(237);
			match(RBRACKET);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(238);
				throwsGroup();
				}
			}

			setState(241);
			funcBlock();
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public StaticContext static_() {
			return getRuleContext(StaticContext.class,0);
		}
		public GenericDefenitionBlockContext genericDefenitionBlock() {
			return getRuleContext(GenericDefenitionBlockContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ThrowsGroupContext throwsGroup() {
			return getRuleContext(ThrowsGroupContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) {
				{
				setState(243);
				modifier();
				}
			}

			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(246);
				static_();
				}
			}

			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LTBRACKET) {
				{
				setState(249);
				genericDefenitionBlock();
				}
			}

			setState(252);
			funcType();
			setState(253);
			funcName();
			setState(254);
			match(LBRACKET);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(255);
				argList();
				}
			}

			setState(258);
			match(RBRACKET);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(259);
				throwsGroup();
				}
			}

			setState(262);
			funcBlock();
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
	public static class ReturnExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitReturnExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitReturnExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnExpressionContext returnExpression() throws RecognitionException {
		ReturnExpressionContext _localctx = new ReturnExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			expression(0);
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
	public static class FuncBlockContext extends ParserRuleContext {
		public TerminalNode LCBRACKET() { return getToken(JavaGrammarParser.LCBRACKET, 0); }
		public TerminalNode RCBRACKET() { return getToken(JavaGrammarParser.RCBRACKET, 0); }
		public List<IfDefinitionContext> ifDefinition() {
			return getRuleContexts(IfDefinitionContext.class);
		}
		public IfDefinitionContext ifDefinition(int i) {
			return getRuleContext(IfDefinitionContext.class,i);
		}
		public List<ForDefinitionContext> forDefinition() {
			return getRuleContexts(ForDefinitionContext.class);
		}
		public ForDefinitionContext forDefinition(int i) {
			return getRuleContext(ForDefinitionContext.class,i);
		}
		public List<WhileDefinitionContext> whileDefinition() {
			return getRuleContexts(WhileDefinitionContext.class);
		}
		public WhileDefinitionContext whileDefinition(int i) {
			return getRuleContext(WhileDefinitionContext.class,i);
		}
		public TerminalNode RETURN() { return getToken(JavaGrammarParser.RETURN, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(JavaGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavaGrammarParser.SEMICOLON, i);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<ObjectCallContext> objectCall() {
			return getRuleContexts(ObjectCallContext.class);
		}
		public ObjectCallContext objectCall(int i) {
			return getRuleContext(ObjectCallContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ReturnExpressionContext returnExpression() {
			return getRuleContext(ReturnExpressionContext.class,0);
		}
		public FuncBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFuncBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFuncBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFuncBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncBlockContext funcBlock() throws RecognitionException {
		FuncBlockContext _localctx = new FuncBlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(LCBRACKET);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 54043195587181084L) != 0)) {
				{
				setState(279);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					{
					setState(267);
					variableDefinition();
					setState(268);
					match(SEMICOLON);
					}
					}
					break;
				case 2:
					{
					{
					setState(270);
					objectCall();
					setState(271);
					match(SEMICOLON);
					}
					}
					break;
				case 3:
					{
					{
					setState(273);
					expression(0);
					setState(274);
					match(SEMICOLON);
					}
					}
					break;
				case 4:
					{
					setState(276);
					ifDefinition();
					}
					break;
				case 5:
					{
					setState(277);
					forDefinition();
					}
					break;
				case 6:
					{
					setState(278);
					whileDefinition();
					}
					break;
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(284);
				match(RETURN);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 54043195587180548L) != 0)) {
					{
					setState(285);
					returnExpression();
					}
				}

				setState(288);
				match(SEMICOLON);
				}
			}

			setState(291);
			match(RCBRACKET);
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
	public static class Static_varContext extends ParserRuleContext {
		public DottedWordContext dottedWord() {
			return getRuleContext(DottedWordContext.class,0);
		}
		public Static_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterStatic_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitStatic_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitStatic_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Static_varContext static_var() throws RecognitionException {
		Static_varContext _localctx = new Static_varContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_static_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			dottedWord();
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public DottedWordContext dottedWord() {
			return getRuleContext(DottedWordContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public TerminalNode NEW() { return getToken(JavaGrammarParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSBRACKET() { return getToken(JavaGrammarParser.LSBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSBRACKET() { return getToken(JavaGrammarParser.RSBRACKET, 0); }
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public GenericConstructorBlockContext genericConstructorBlock() {
			return getRuleContext(GenericConstructorBlockContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ObjectCallContext objectCall() {
			return getRuleContext(ObjectCallContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public IncDecContext incDec() {
			return getRuleContext(IncDecContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(296);
				number();
				}
				break;
			case 2:
				{
				setState(297);
				stringLiteral();
				}
				break;
			case 3:
				{
				setState(298);
				dottedWord();
				}
				break;
			case 4:
				{
				setState(299);
				varName();
				}
				break;
			case 5:
				{
				setState(300);
				match(NEW);
				setState(301);
				type();
				setState(302);
				match(LSBRACKET);
				setState(303);
				expression(0);
				setState(304);
				match(RSBRACKET);
				}
				break;
			case 6:
				{
				setState(306);
				match(NEW);
				setState(307);
				type();
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LTBRACKET) {
					{
					setState(308);
					genericConstructorBlock();
					}
				}

				setState(311);
				match(LBRACKET);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 54043195587180548L) != 0)) {
					{
					setState(312);
					expressionList();
					}
				}

				setState(315);
				match(RBRACKET);
				}
				break;
			case 7:
				{
				setState(317);
				unaryOperator();
				setState(318);
				expression(4);
				}
				break;
			case 8:
				{
				setState(320);
				funcCall();
				}
				break;
			case 9:
				{
				setState(321);
				objectCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(330);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(325);
						operator();
						setState(326);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(329);
						incDec();
						}
						break;
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	public static class TypeContext extends ParserRuleContext {
		public DottedWordContext dottedWord() {
			return getRuleContext(DottedWordContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			dottedWord();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(336);
				match(T__0);
				}
				}
				setState(341);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(JavaGrammarParser.INTEGER, 0); }
		public TerminalNode FLOATING() { return getToken(JavaGrammarParser.FLOATING, 0); }
		public TerminalNode DIG() { return getToken(JavaGrammarParser.DIG, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class NotQuoteWordContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE() { return getTokens(JavaGrammarParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(JavaGrammarParser.QUOTE, i);
		}
		public NotQuoteWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notQuoteWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterNotQuoteWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitNotQuoteWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitNotQuoteWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotQuoteWordContext notQuoteWord() throws RecognitionException {
		NotQuoteWordContext _localctx = new NotQuoteWordContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_notQuoteWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100789566373886L) != 0)) {
				{
				{
				setState(344);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==QUOTE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(349);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE() { return getTokens(JavaGrammarParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(JavaGrammarParser.QUOTE, i);
		}
		public NotQuoteWordContext notQuoteWord() {
			return getRuleContext(NotQuoteWordContext.class,0);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(QUOTE);
			setState(351);
			notQuoteWord();
			setState(352);
			match(QUOTE);
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
	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(WORD);
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
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			expression(0);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(357);
				match(COMMA);
				setState(358);
				expression(0);
				}
				}
				setState(363);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(JavaGrammarParser.VOID, 0); }
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_funcType);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(VOID);
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
	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(WORD);
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
	public static class FuncCallContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			funcName();
			setState(371);
			match(LBRACKET);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 54043195587180548L) != 0)) {
				{
				setState(372);
				expressionList();
				}
			}

			setState(375);
			match(RBRACKET);
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
	public static class BooleanExprContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public BooleanOperatorContext booleanOperator() {
			return getRuleContext(BooleanOperatorContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JavaGrammarParser.NOT, 0); }
		public List<BooleanExprContext> booleanExpr() {
			return getRuleContexts(BooleanExprContext.class);
		}
		public BooleanExprContext booleanExpr(int i) {
			return getRuleContext(BooleanExprContext.class,i);
		}
		public Boolean_composerContext boolean_composer() {
			return getRuleContext(Boolean_composerContext.class,0);
		}
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		return booleanExpr(0);
	}

	private BooleanExprContext booleanExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, _parentState);
		BooleanExprContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_booleanExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(378);
				expression(0);
				}
				break;
			case 3:
				{
				setState(379);
				match(LBRACKET);
				setState(380);
				expression(0);
				setState(381);
				match(RBRACKET);
				}
				break;
			case 4:
				{
				setState(383);
				expression(0);
				setState(384);
				booleanOperator();
				setState(385);
				expression(0);
				}
				break;
			case 5:
				{
				setState(387);
				match(NOT);
				setState(388);
				booleanExpr(2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(397);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanExpr);
					setState(391);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(392);
					boolean_composer();
					setState(393);
					booleanExpr(2);
					}
					} 
				}
				setState(399);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
	public static class IfBlockContext extends ParserRuleContext {
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ifBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			funcBlock();
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
	public static class ElseBlockContext extends ParserRuleContext {
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_elseBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			funcBlock();
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
	public static class IfDefinitionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(JavaGrammarParser.IF, 0); }
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(JavaGrammarParser.ELSE, 0); }
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public IfDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterIfDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitIfDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitIfDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDefinitionContext ifDefinition() throws RecognitionException {
		IfDefinitionContext _localctx = new IfDefinitionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ifDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(IF);
			setState(405);
			match(LBRACKET);
			setState(406);
			booleanExpr(0);
			setState(407);
			match(RBRACKET);
			setState(408);
			ifBlock();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(409);
				match(ELSE);
				setState(410);
				elseBlock();
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
	public static class ExprOrStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public ExprOrStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOrStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterExprOrStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitExprOrStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitExprOrStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprOrStatementContext exprOrStatement() throws RecognitionException {
		ExprOrStatementContext _localctx = new ExprOrStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_exprOrStatement);
		try {
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				variableStatement();
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
	public static class ForDefinitionContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(JavaGrammarParser.FOR, 0); }
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(JavaGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavaGrammarParser.SEMICOLON, i);
		}
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public List<ExprOrStatementContext> exprOrStatement() {
			return getRuleContexts(ExprOrStatementContext.class);
		}
		public ExprOrStatementContext exprOrStatement(int i) {
			return getRuleContext(ExprOrStatementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public ForDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterForDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitForDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitForDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDefinitionContext forDefinition() throws RecognitionException {
		ForDefinitionContext _localctx = new ForDefinitionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(FOR);
			setState(418);
			match(LBRACKET);
			{
			setState(419);
			variableDefinition();
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(420);
				match(COMMA);
				setState(421);
				variableDefinition();
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(427);
			match(SEMICOLON);
			setState(428);
			booleanExpr(0);
			setState(429);
			match(SEMICOLON);
			{
			{
			setState(430);
			exprOrStatement();
			}
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(431);
				match(COMMA);
				setState(432);
				exprOrStatement();
				}
				}
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(438);
			match(RBRACKET);
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				{
				setState(439);
				match(SEMICOLON);
				}
				break;
			case LCBRACKET:
				{
				setState(440);
				funcBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class WhileDefinitionContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(JavaGrammarParser.WHILE, 0); }
		public TerminalNode LBRACKET() { return getToken(JavaGrammarParser.LBRACKET, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(JavaGrammarParser.RBRACKET, 0); }
		public TerminalNode SEMICOLON() { return getToken(JavaGrammarParser.SEMICOLON, 0); }
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public WhileDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterWhileDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitWhileDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitWhileDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileDefinitionContext whileDefinition() throws RecognitionException {
		WhileDefinitionContext _localctx = new WhileDefinitionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_whileDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(WHILE);
			setState(444);
			match(LBRACKET);
			setState(445);
			booleanExpr(0);
			setState(446);
			match(RBRACKET);
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				{
				setState(447);
				match(SEMICOLON);
				}
				break;
			case LCBRACKET:
				{
				setState(448);
				funcBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class GenericDefenitionBlockContext extends ParserRuleContext {
		public TerminalNode LTBRACKET() { return getToken(JavaGrammarParser.LTBRACKET, 0); }
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public TerminalNode RTBRACKET() { return getToken(JavaGrammarParser.RTBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public GenericDefenitionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericDefenitionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterGenericDefenitionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitGenericDefenitionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitGenericDefenitionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericDefenitionBlockContext genericDefenitionBlock() throws RecognitionException {
		GenericDefenitionBlockContext _localctx = new GenericDefenitionBlockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_genericDefenitionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(LTBRACKET);
			setState(452);
			match(WORD);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(453);
				match(COMMA);
				setState(454);
				match(WORD);
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(460);
			match(RTBRACKET);
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
	public static class GenericUsageBlockContext extends ParserRuleContext {
		public TerminalNode LTBRACKET() { return getToken(JavaGrammarParser.LTBRACKET, 0); }
		public List<GenericWildcardTypeParameterContext> genericWildcardTypeParameter() {
			return getRuleContexts(GenericWildcardTypeParameterContext.class);
		}
		public GenericWildcardTypeParameterContext genericWildcardTypeParameter(int i) {
			return getRuleContext(GenericWildcardTypeParameterContext.class,i);
		}
		public TerminalNode RTBRACKET() { return getToken(JavaGrammarParser.RTBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public GenericUsageBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericUsageBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterGenericUsageBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitGenericUsageBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitGenericUsageBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericUsageBlockContext genericUsageBlock() throws RecognitionException {
		GenericUsageBlockContext _localctx = new GenericUsageBlockContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_genericUsageBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(LTBRACKET);
			setState(463);
			genericWildcardTypeParameter();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(464);
				match(COMMA);
				setState(465);
				genericWildcardTypeParameter();
				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(471);
			match(RTBRACKET);
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
	public static class GenericConstructorBlockContext extends ParserRuleContext {
		public TerminalNode LTBRACKET() { return getToken(JavaGrammarParser.LTBRACKET, 0); }
		public TerminalNode RTBRACKET() { return getToken(JavaGrammarParser.RTBRACKET, 0); }
		public List<GenericWildcardTypeParameterContext> genericWildcardTypeParameter() {
			return getRuleContexts(GenericWildcardTypeParameterContext.class);
		}
		public GenericWildcardTypeParameterContext genericWildcardTypeParameter(int i) {
			return getRuleContext(GenericWildcardTypeParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public GenericConstructorBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericConstructorBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterGenericConstructorBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitGenericConstructorBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitGenericConstructorBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericConstructorBlockContext genericConstructorBlock() throws RecognitionException {
		GenericConstructorBlockContext _localctx = new GenericConstructorBlockContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_genericConstructorBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(LTBRACKET);
			setState(483);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RTBRACKET:
				{
				}
				break;
			case QUESTION_MARK:
			case WORD:
				{
				setState(475);
				genericWildcardTypeParameter();
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(476);
					match(COMMA);
					setState(477);
					genericWildcardTypeParameter();
					}
					}
					setState(482);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(485);
			match(RTBRACKET);
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
	public static class GenericWildcardTypeParameterContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public GenericUsageBlockContext genericUsageBlock() {
			return getRuleContext(GenericUsageBlockContext.class,0);
		}
		public TerminalNode QUESTION_MARK() { return getToken(JavaGrammarParser.QUESTION_MARK, 0); }
		public TypeParameterConstraintContext typeParameterConstraint() {
			return getRuleContext(TypeParameterConstraintContext.class,0);
		}
		public GenericWildcardTypeParameterContext genericWildcardTypeParameter() {
			return getRuleContext(GenericWildcardTypeParameterContext.class,0);
		}
		public GenericWildcardTypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericWildcardTypeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterGenericWildcardTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitGenericWildcardTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitGenericWildcardTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericWildcardTypeParameterContext genericWildcardTypeParameter() throws RecognitionException {
		GenericWildcardTypeParameterContext _localctx = new GenericWildcardTypeParameterContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_genericWildcardTypeParameter);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(487);
				match(WORD);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LTBRACKET) {
					{
					setState(488);
					genericUsageBlock();
					}
				}

				}
				}
				break;
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(491);
				match(QUESTION_MARK);
				setState(492);
				typeParameterConstraint();
				setState(493);
				genericWildcardTypeParameter();
				}
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
	public static class TypeParameterConstraintContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(JavaGrammarParser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(JavaGrammarParser.SUPER, 0); }
		public TypeParameterConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterTypeParameterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitTypeParameterConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitTypeParameterConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterConstraintContext typeParameterConstraint() throws RecognitionException {
		TypeParameterConstraintContext _localctx = new TypeParameterConstraintContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_typeParameterConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(JavaGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(JavaGrammarParser.MINUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(JavaGrammarParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(JavaGrammarParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(JavaGrammarParser.MOD, 0); }
		public TerminalNode BIN_AND() { return getToken(JavaGrammarParser.BIN_AND, 0); }
		public TerminalNode BINOr() { return getToken(JavaGrammarParser.BINOr, 0); }
		public BooleanOperatorContext booleanOperator() {
			return getRuleContext(BooleanOperatorContext.class,0);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_operator);
		try {
			setState(507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				match(PLUS);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(MINUS);
				}
				break;
			case MULTIPLY:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(MULTIPLY);
				}
				break;
			case DIVIDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(502);
				match(DIVIDE);
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 5);
				{
				setState(503);
				match(MOD);
				}
				break;
			case BIN_AND:
				enterOuterAlt(_localctx, 6);
				{
				setState(504);
				match(BIN_AND);
				}
				break;
			case BINOr:
				enterOuterAlt(_localctx, 7);
				{
				setState(505);
				match(BINOr);
				}
				break;
			case EQUAL:
			case NEQ:
			case GREATEROr_EQ:
			case LESSOr_EQ:
			case LTBRACKET:
			case RTBRACKET:
				enterOuterAlt(_localctx, 8);
				{
				setState(506);
				booleanOperator();
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
	public static class BooleanOperatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(JavaGrammarParser.EQUAL, 0); }
		public TerminalNode NEQ() { return getToken(JavaGrammarParser.NEQ, 0); }
		public TerminalNode LTBRACKET() { return getToken(JavaGrammarParser.LTBRACKET, 0); }
		public TerminalNode GREATEROr_EQ() { return getToken(JavaGrammarParser.GREATEROr_EQ, 0); }
		public TerminalNode RTBRACKET() { return getToken(JavaGrammarParser.RTBRACKET, 0); }
		public TerminalNode LESSOr_EQ() { return getToken(JavaGrammarParser.LESSOr_EQ, 0); }
		public BooleanOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterBooleanOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitBooleanOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitBooleanOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanOperatorContext booleanOperator() throws RecognitionException {
		BooleanOperatorContext _localctx = new BooleanOperatorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_booleanOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 844424934064128L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode UN_NOT() { return getToken(JavaGrammarParser.UN_NOT, 0); }
		public IncDecContext incDec() {
			return getRuleContext(IncDecContext.class,0);
		}
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_unaryOperator);
		try {
			setState(513);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UN_NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				match(UN_NOT);
				}
				break;
			case INC:
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
				incDec();
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
	public static class IncDecContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(JavaGrammarParser.INC, 0); }
		public TerminalNode DEC() { return getToken(JavaGrammarParser.DEC, 0); }
		public IncDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitIncDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncDecContext incDec() throws RecognitionException {
		IncDecContext _localctx = new IncDecContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_incDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_la = _input.LA(1);
			if ( !(_la==INC || _la==DEC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Boolean_composerContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(JavaGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(JavaGrammarParser.OR, 0); }
		public Boolean_composerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_composer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterBoolean_composer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitBoolean_composer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitBoolean_composer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_composerContext boolean_composer() throws RecognitionException {
		Boolean_composerContext _localctx = new Boolean_composerContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_boolean_composer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class DottedWordsContext extends ParserRuleContext {
		public List<DottedWordContext> dottedWord() {
			return getRuleContexts(DottedWordContext.class);
		}
		public DottedWordContext dottedWord(int i) {
			return getRuleContext(DottedWordContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaGrammarParser.COMMA, i);
		}
		public DottedWordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dottedWords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterDottedWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitDottedWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitDottedWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DottedWordsContext dottedWords() throws RecognitionException {
		DottedWordsContext _localctx = new DottedWordsContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_dottedWords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			dottedWord();
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(520);
				match(COMMA);
				setState(521);
				dottedWord();
				}
				}
				setState(526);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ThrowsGroupContext extends ParserRuleContext {
		public TerminalNode THROWS() { return getToken(JavaGrammarParser.THROWS, 0); }
		public DottedWordsContext dottedWords() {
			return getRuleContext(DottedWordsContext.class,0);
		}
		public ThrowsGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwsGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterThrowsGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitThrowsGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitThrowsGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowsGroupContext throwsGroup() throws RecognitionException {
		ThrowsGroupContext _localctx = new ThrowsGroupContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_throwsGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(THROWS);
			setState(528);
			dottedWords();
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
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(JavaGrammarParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(JavaGrammarParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(JavaGrammarParser.PROTECTED, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class StaticContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(JavaGrammarParser.STATIC, 0); }
		public StaticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterStatic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitStatic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitStatic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticContext static_() throws RecognitionException {
		StaticContext _localctx = new StaticContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_static);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(STATIC);
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
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaGrammarParser.DOT, i);
		}
		public DottedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dottedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterDottedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitDottedWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitDottedWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DottedWordContext dottedWord() throws RecognitionException {
		DottedWordContext _localctx = new DottedWordContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_dottedWord);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(WORD);
			setState(539);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(535);
					match(DOT);
					setState(536);
					match(WORD);
					}
					} 
				}
				setState(541);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 31:
			return booleanExpr_sempred((BooleanExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean booleanExpr_sempred(BooleanExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u021f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u0001\u0000\u0003\u0000l\b\u0000"+
		"\u0001\u0000\u0003\u0000o\b\u0000\u0001\u0000\u0003\u0000r\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002~\b\u0002\n\u0002"+
		"\f\u0002\u0081\t\u0002\u0001\u0003\u0001\u0003\u0003\u0003\u0085\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u0093\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u009a\b\u0007\n\u0007\f\u0007\u009d\t\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0003\f\u00a8\b\f\u0001\f\u0003\f\u00ab\b\f\u0001\f\u0003\f\u00ae\b"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b3\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u00bc\b\f\n\f\f\f\u00bf\t\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\u000e\u0003\u000e\u00c6\b\u000e\u0001\u000e"+
		"\u0003\u000e\u00c9\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003\u000f"+
		"\u00ce\b\u000f\u0001\u000f\u0003\u000f\u00d1\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00d6\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00df"+
		"\b\u000f\n\u000f\f\u000f\u00e2\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0003\u0010\u00e7\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00ec\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00f0\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0003\u0011\u00f5\b\u0011\u0001\u0011\u0003"+
		"\u0011\u00f8\b\u0011\u0001\u0011\u0003\u0011\u00fb\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0101\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0105\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u0118\b\u0013\n\u0013\f\u0013\u011b"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u011f\b\u0013\u0001\u0013"+
		"\u0003\u0013\u0122\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u0136\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u013a\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0143\b\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u014b\b\u0015\n\u0015\f\u0015\u014e\t\u0015\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0152\b\u0016\n\u0016\f\u0016\u0155\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0005\u0018\u015a\b\u0018\n\u0018\f\u0018\u015d\t\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0168\b\u001b\n\u001b\f\u001b"+
		"\u016b\t\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u016f\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0176"+
		"\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0186\b\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u018c\b\u001f\n\u001f\f\u001f"+
		"\u018f\t\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0003\"\u019c\b\"\u0001#\u0001#\u0003#\u01a0"+
		"\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u01a7\b$\n$\f$\u01aa\t$"+
		"\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u01b2\b$\n$\f$\u01b5"+
		"\t$\u0001$\u0001$\u0001$\u0003$\u01ba\b$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u01c2\b%\u0001&\u0001&\u0001&\u0001&\u0005&\u01c8\b&\n"+
		"&\f&\u01cb\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u01d3"+
		"\b\'\n\'\f\'\u01d6\t\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0005(\u01df\b(\n(\f(\u01e2\t(\u0003(\u01e4\b(\u0001(\u0001(\u0001)"+
		"\u0001)\u0003)\u01ea\b)\u0001)\u0001)\u0001)\u0001)\u0003)\u01f0\b)\u0001"+
		"*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003"+
		"+\u01fc\b+\u0001,\u0001,\u0001-\u0001-\u0003-\u0202\b-\u0001.\u0001.\u0001"+
		"/\u0001/\u00010\u00010\u00010\u00050\u020b\b0\n0\f0\u020e\t0\u00011\u0001"+
		"1\u00011\u00012\u00012\u00013\u00013\u00014\u00014\u00014\u00054\u021a"+
		"\b4\n4\f4\u021d\t4\u00014\u0000\u0002*>5\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDFHJLNPRTVXZ\\^`bdfh\u0000\t\u0001\u0000#$\u0001\u0000!\"\u0001\u0000"+
		"\u000b\r\u0001\u000066\u0001\u0000()\u0002\u0000\u0012\u001501\u0001\u0000"+
		"\u0017\u0018\u0001\u0000\u001c\u001d\u0001\u0000 \"\u023d\u0000k\u0001"+
		"\u0000\u0000\u0000\u0002u\u0001\u0000\u0000\u0000\u0004\u007f\u0001\u0000"+
		"\u0000\u0000\u0006\u0082\u0001\u0000\u0000\u0000\b\u0088\u0001\u0000\u0000"+
		"\u0000\n\u008c\u0001\u0000\u0000\u0000\f\u0090\u0001\u0000\u0000\u0000"+
		"\u000e\u0096\u0001\u0000\u0000\u0000\u0010\u009e\u0001\u0000\u0000\u0000"+
		"\u0012\u00a0\u0001\u0000\u0000\u0000\u0014\u00a2\u0001\u0000\u0000\u0000"+
		"\u0016\u00a4\u0001\u0000\u0000\u0000\u0018\u00a7\u0001\u0000\u0000\u0000"+
		"\u001a\u00c2\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000\u0000\u0000"+
		"\u001e\u00cd\u0001\u0000\u0000\u0000 \u00e6\u0001\u0000\u0000\u0000\""+
		"\u00f4\u0001\u0000\u0000\u0000$\u0108\u0001\u0000\u0000\u0000&\u010a\u0001"+
		"\u0000\u0000\u0000(\u0125\u0001\u0000\u0000\u0000*\u0142\u0001\u0000\u0000"+
		"\u0000,\u014f\u0001\u0000\u0000\u0000.\u0156\u0001\u0000\u0000\u00000"+
		"\u015b\u0001\u0000\u0000\u00002\u015e\u0001\u0000\u0000\u00004\u0162\u0001"+
		"\u0000\u0000\u00006\u0164\u0001\u0000\u0000\u00008\u016e\u0001\u0000\u0000"+
		"\u0000:\u0170\u0001\u0000\u0000\u0000<\u0172\u0001\u0000\u0000\u0000>"+
		"\u0185\u0001\u0000\u0000\u0000@\u0190\u0001\u0000\u0000\u0000B\u0192\u0001"+
		"\u0000\u0000\u0000D\u0194\u0001\u0000\u0000\u0000F\u019f\u0001\u0000\u0000"+
		"\u0000H\u01a1\u0001\u0000\u0000\u0000J\u01bb\u0001\u0000\u0000\u0000L"+
		"\u01c3\u0001\u0000\u0000\u0000N\u01ce\u0001\u0000\u0000\u0000P\u01d9\u0001"+
		"\u0000\u0000\u0000R\u01ef\u0001\u0000\u0000\u0000T\u01f1\u0001\u0000\u0000"+
		"\u0000V\u01fb\u0001\u0000\u0000\u0000X\u01fd\u0001\u0000\u0000\u0000Z"+
		"\u0201\u0001\u0000\u0000\u0000\\\u0203\u0001\u0000\u0000\u0000^\u0205"+
		"\u0001\u0000\u0000\u0000`\u0207\u0001\u0000\u0000\u0000b\u020f\u0001\u0000"+
		"\u0000\u0000d\u0212\u0001\u0000\u0000\u0000f\u0214\u0001\u0000\u0000\u0000"+
		"h\u0216\u0001\u0000\u0000\u0000jl\u0003\u0002\u0001\u0000kj\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000\u0000\u0000mo\u0003"+
		"\u0004\u0002\u0000nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"oq\u0001\u0000\u0000\u0000pr\u0003\u001e\u000f\u0000qp\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005\u0000"+
		"\u0000\u0001t\u0001\u0001\u0000\u0000\u0000uv\u0005\u0007\u0000\u0000"+
		"vw\u0003h4\u0000wx\u00052\u0000\u0000x\u0003\u0001\u0000\u0000\u0000y"+
		"z\u0005\u0006\u0000\u0000z{\u0003h4\u0000{|\u00052\u0000\u0000|~\u0001"+
		"\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0005\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0003,\u0016\u0000\u0083\u0085\u0003N\'\u0000\u0084\u0083"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000\u0087\u0007\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u00034\u001a\u0000\u0089\u008a\u00053\u0000"+
		"\u0000\u008a\u008b\u0003*\u0015\u0000\u008b\t\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0003h4\u0000\u008d\u008e\u00054\u0000\u0000\u008e\u008f"+
		"\u0003<\u001e\u0000\u008f\u000b\u0001\u0000\u0000\u0000\u0090\u0092\u0003"+
		",\u0016\u0000\u0091\u0093\u0003N\'\u0000\u0092\u0091\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u00034\u001a\u0000\u0095\r\u0001\u0000\u0000\u0000"+
		"\u0096\u009b\u0003\f\u0006\u0000\u0097\u0098\u00055\u0000\u0000\u0098"+
		"\u009a\u0003\f\u0006\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009d"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u000f\u0001\u0000\u0000\u0000\u009d\u009b"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u00057\u0000\u0000\u009f\u0011\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0007\u0000\u0000\u0000\u00a1\u0013\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0007\u0001\u0000\u0000\u00a3\u0015\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0003f3\u0000\u00a5\u0017\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a8\u0003\u0014\n\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ab\u0003\u0016\u000b\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ae\u0003\u0012\t\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0005\b\u0000\u0000\u00b0\u00b2\u0003\u0010\b\u0000\u00b1\u00b3"+
		"\u0003L&\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00bd\u0005.\u0000"+
		"\u0000\u00b5\u00bc\u0003\"\u0011\u0000\u00b6\u00bc\u0003 \u0010\u0000"+
		"\u00b7\u00b8\u0003\u001c\u000e\u0000\u00b8\u00b9\u00052\u0000\u0000\u00b9"+
		"\u00bc\u0001\u0000\u0000\u0000\u00ba\u00bc\u0003\u0018\f\u0000\u00bb\u00b5"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b6\u0001\u0000\u0000\u0000\u00bb\u00b7"+
		"\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005/\u0000\u0000\u00c1\u0019\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0003d2\u0000\u00c3\u001b\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c6\u0003d2\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c9\u0003f3\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0003"+
		"\u0006\u0003\u0000\u00cb\u001d\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003"+
		"\u001a\r\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000"+
		"\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00d1\u0003\u0012"+
		"\t\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\b\u0000\u0000"+
		"\u00d3\u00d5\u0003\u0010\b\u0000\u00d4\u00d6\u0003L&\u0000\u00d5\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d7\u00e0\u0005.\u0000\u0000\u00d8\u00df\u0003"+
		"\"\u0011\u0000\u00d9\u00df\u0003 \u0010\u0000\u00da\u00db\u0003\u001c"+
		"\u000e\u0000\u00db\u00dc\u00052\u0000\u0000\u00dc\u00df\u0001\u0000\u0000"+
		"\u0000\u00dd\u00df\u0003\u0018\f\u0000\u00de\u00d8\u0001\u0000\u0000\u0000"+
		"\u00de\u00d9\u0001\u0000\u0000\u0000\u00de\u00da\u0001\u0000\u0000\u0000"+
		"\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0005/\u0000\u0000\u00e4\u001f\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e7\u0003d2\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0003"+
		"\u0010\b\u0000\u00e9\u00eb\u0005*\u0000\u0000\u00ea\u00ec\u0003\u000e"+
		"\u0007\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0005+\u0000"+
		"\u0000\u00ee\u00f0\u0003b1\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f2\u0003&\u0013\u0000\u00f2!\u0001\u0000\u0000\u0000\u00f3\u00f5\u0003"+
		"d2\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f8\u0003f3\u0000\u00f7"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"\u00fa\u0001\u0000\u0000\u0000\u00f9\u00fb\u0003L&\u0000\u00fa\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u00038\u001c\u0000\u00fd\u00fe\u0003:\u001d"+
		"\u0000\u00fe\u0100\u0005*\u0000\u0000\u00ff\u0101\u0003\u000e\u0007\u0000"+
		"\u0100\u00ff\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0104\u0005+\u0000\u0000\u0103"+
		"\u0105\u0003b1\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0104\u0105\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0003"+
		"&\u0013\u0000\u0107#\u0001\u0000\u0000\u0000\u0108\u0109\u0003*\u0015"+
		"\u0000\u0109%\u0001\u0000\u0000\u0000\u010a\u0119\u0005.\u0000\u0000\u010b"+
		"\u010c\u0003\u0006\u0003\u0000\u010c\u010d\u00052\u0000\u0000\u010d\u0118"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0003\n\u0005\u0000\u010f\u0110\u0005"+
		"2\u0000\u0000\u0110\u0118\u0001\u0000\u0000\u0000\u0111\u0112\u0003*\u0015"+
		"\u0000\u0112\u0113\u00052\u0000\u0000\u0113\u0118\u0001\u0000\u0000\u0000"+
		"\u0114\u0118\u0003D\"\u0000\u0115\u0118\u0003H$\u0000\u0116\u0118\u0003"+
		"J%\u0000\u0117\u010b\u0001\u0000\u0000\u0000\u0117\u010e\u0001\u0000\u0000"+
		"\u0000\u0117\u0111\u0001\u0000\u0000\u0000\u0117\u0114\u0001\u0000\u0000"+
		"\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0116\u0001\u0000\u0000"+
		"\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u0121\u0001\u0000\u0000"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u011e\u0005&\u0000\u0000"+
		"\u011d\u011f\u0003$\u0012\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u00052\u0000\u0000\u0121\u011c\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0005/\u0000\u0000\u0124\'\u0001\u0000\u0000\u0000\u0125\u0126\u0003"+
		"h4\u0000\u0126)\u0001\u0000\u0000\u0000\u0127\u0128\u0006\u0015\uffff"+
		"\uffff\u0000\u0128\u0143\u0003.\u0017\u0000\u0129\u0143\u00032\u0019\u0000"+
		"\u012a\u0143\u0003h4\u0000\u012b\u0143\u00034\u001a\u0000\u012c\u012d"+
		"\u0005\u0002\u0000\u0000\u012d\u012e\u0003,\u0016\u0000\u012e\u012f\u0005"+
		",\u0000\u0000\u012f\u0130\u0003*\u0015\u0000\u0130\u0131\u0005-\u0000"+
		"\u0000\u0131\u0143\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u0002\u0000"+
		"\u0000\u0133\u0135\u0003,\u0016\u0000\u0134\u0136\u0003P(\u0000\u0135"+
		"\u0134\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137\u0139\u0005*\u0000\u0000\u0138\u013a"+
		"\u00036\u001b\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"+\u0000\u0000\u013c\u0143\u0001\u0000\u0000\u0000\u013d\u013e\u0003Z-"+
		"\u0000\u013e\u013f\u0003*\u0015\u0004\u013f\u0143\u0001\u0000\u0000\u0000"+
		"\u0140\u0143\u0003<\u001e\u0000\u0141\u0143\u0003\n\u0005\u0000\u0142"+
		"\u0127\u0001\u0000\u0000\u0000\u0142\u0129\u0001\u0000\u0000\u0000\u0142"+
		"\u012a\u0001\u0000\u0000\u0000\u0142\u012b\u0001\u0000\u0000\u0000\u0142"+
		"\u012c\u0001\u0000\u0000\u0000\u0142\u0132\u0001\u0000\u0000\u0000\u0142"+
		"\u013d\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142"+
		"\u0141\u0001\u0000\u0000\u0000\u0143\u014c\u0001\u0000\u0000\u0000\u0144"+
		"\u0145\n\u0005\u0000\u0000\u0145\u0146\u0003V+\u0000\u0146\u0147\u0003"+
		"*\u0015\u0006\u0147\u014b\u0001\u0000\u0000\u0000\u0148\u0149\n\u0003"+
		"\u0000\u0000\u0149\u014b\u0003\\.\u0000\u014a\u0144\u0001\u0000\u0000"+
		"\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000"+
		"\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000"+
		"\u0000\u014d+\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000"+
		"\u014f\u0153\u0003h4\u0000\u0150\u0152\u0005\u0001\u0000\u0000\u0151\u0150"+
		"\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154-\u0001"+
		"\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0157\u0007"+
		"\u0002\u0000\u0000\u0157/\u0001\u0000\u0000\u0000\u0158\u015a\b\u0003"+
		"\u0000\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u015a\u015d\u0001\u0000"+
		"\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000"+
		"\u0000\u0000\u015c1\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000"+
		"\u0000\u015e\u015f\u00056\u0000\u0000\u015f\u0160\u00030\u0018\u0000\u0160"+
		"\u0161\u00056\u0000\u0000\u01613\u0001\u0000\u0000\u0000\u0162\u0163\u0005"+
		"7\u0000\u0000\u01635\u0001\u0000\u0000\u0000\u0164\u0169\u0003*\u0015"+
		"\u0000\u0165\u0166\u00055\u0000\u0000\u0166\u0168\u0003*\u0015\u0000\u0167"+
		"\u0165\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000\u0000\u0000\u0169"+
		"\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a"+
		"7\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016c\u016f"+
		"\u0003,\u0016\u0000\u016d\u016f\u0005\u0005\u0000\u0000\u016e\u016c\u0001"+
		"\u0000\u0000\u0000\u016e\u016d\u0001\u0000\u0000\u0000\u016f9\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u00057\u0000\u0000\u0171;\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0003:\u001d\u0000\u0173\u0175\u0005*\u0000\u0000\u0174\u0176"+
		"\u00036\u001b\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0175\u0176\u0001"+
		"\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0005"+
		"+\u0000\u0000\u0178=\u0001\u0000\u0000\u0000\u0179\u0186\u0006\u001f\uffff"+
		"\uffff\u0000\u017a\u0186\u0003*\u0015\u0000\u017b\u017c\u0005*\u0000\u0000"+
		"\u017c\u017d\u0003*\u0015\u0000\u017d\u017e\u0005+\u0000\u0000\u017e\u0186"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u0003*\u0015\u0000\u0180\u0181\u0003"+
		"X,\u0000\u0181\u0182\u0003*\u0015\u0000\u0182\u0186\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0005\u001e\u0000\u0000\u0184\u0186\u0003>\u001f\u0002"+
		"\u0185\u0179\u0001\u0000\u0000\u0000\u0185\u017a\u0001\u0000\u0000\u0000"+
		"\u0185\u017b\u0001\u0000\u0000\u0000\u0185\u017f\u0001\u0000\u0000\u0000"+
		"\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u018d\u0001\u0000\u0000\u0000"+
		"\u0187\u0188\n\u0001\u0000\u0000\u0188\u0189\u0003^/\u0000\u0189\u018a"+
		"\u0003>\u001f\u0002\u018a\u018c\u0001\u0000\u0000\u0000\u018b\u0187\u0001"+
		"\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b\u0001"+
		"\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e?\u0001\u0000"+
		"\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0191\u0003&\u0013"+
		"\u0000\u0191A\u0001\u0000\u0000\u0000\u0192\u0193\u0003&\u0013\u0000\u0193"+
		"C\u0001\u0000\u0000\u0000\u0194\u0195\u0005\t\u0000\u0000\u0195\u0196"+
		"\u0005*\u0000\u0000\u0196\u0197\u0003>\u001f\u0000\u0197\u0198\u0005+"+
		"\u0000\u0000\u0198\u019b\u0003@ \u0000\u0199\u019a\u0005\n\u0000\u0000"+
		"\u019a\u019c\u0003B!\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c"+
		"\u0001\u0000\u0000\u0000\u019cE\u0001\u0000\u0000\u0000\u019d\u01a0\u0003"+
		"*\u0015\u0000\u019e\u01a0\u0003\b\u0004\u0000\u019f\u019d\u0001\u0000"+
		"\u0000\u0000\u019f\u019e\u0001\u0000\u0000\u0000\u01a0G\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0005\u0003\u0000\u0000\u01a2\u01a3\u0005*\u0000\u0000"+
		"\u01a3\u01a8\u0003\u0006\u0003\u0000\u01a4\u01a5\u00055\u0000\u0000\u01a5"+
		"\u01a7\u0003\u0006\u0003\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a7"+
		"\u01aa\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a9\u0001\u0000\u0000\u0000\u01a9\u01ab\u0001\u0000\u0000\u0000\u01aa"+
		"\u01a8\u0001\u0000\u0000\u0000\u01ab\u01ac\u00052\u0000\u0000\u01ac\u01ad"+
		"\u0003>\u001f\u0000\u01ad\u01ae\u00052\u0000\u0000\u01ae\u01b3\u0003F"+
		"#\u0000\u01af\u01b0\u00055\u0000\u0000\u01b0\u01b2\u0003F#\u0000\u01b1"+
		"\u01af\u0001\u0000\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3"+
		"\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4"+
		"\u01b6\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6"+
		"\u01b9\u0005+\u0000\u0000\u01b7\u01ba\u00052\u0000\u0000\u01b8\u01ba\u0003"+
		"&\u0013\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9\u01b8\u0001\u0000"+
		"\u0000\u0000\u01baI\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005\u0004\u0000"+
		"\u0000\u01bc\u01bd\u0005*\u0000\u0000\u01bd\u01be\u0003>\u001f\u0000\u01be"+
		"\u01c1\u0005+\u0000\u0000\u01bf\u01c2\u00052\u0000\u0000\u01c0\u01c2\u0003"+
		"&\u0013\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c2K\u0001\u0000\u0000\u0000\u01c3\u01c4\u00050\u0000\u0000"+
		"\u01c4\u01c9\u00057\u0000\u0000\u01c5\u01c6\u00055\u0000\u0000\u01c6\u01c8"+
		"\u00057\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01cb\u0001"+
		"\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001"+
		"\u0000\u0000\u0000\u01ca\u01cc\u0001\u0000\u0000\u0000\u01cb\u01c9\u0001"+
		"\u0000\u0000\u0000\u01cc\u01cd\u00051\u0000\u0000\u01cdM\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cf\u00050\u0000\u0000\u01cf\u01d4\u0003R)\u0000\u01d0"+
		"\u01d1\u00055\u0000\u0000\u01d1\u01d3\u0003R)\u0000\u01d2\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5\u01d7\u0001"+
		"\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d7\u01d8\u0005"+
		"1\u0000\u0000\u01d8O\u0001\u0000\u0000\u0000\u01d9\u01e3\u00050\u0000"+
		"\u0000\u01da\u01e4\u0001\u0000\u0000\u0000\u01db\u01e0\u0003R)\u0000\u01dc"+
		"\u01dd\u00055\u0000\u0000\u01dd\u01df\u0003R)\u0000\u01de\u01dc\u0001"+
		"\u0000\u0000\u0000\u01df\u01e2\u0001\u0000\u0000\u0000\u01e0\u01de\u0001"+
		"\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e4\u0001"+
		"\u0000\u0000\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e3\u01da\u0001"+
		"\u0000\u0000\u0000\u01e3\u01db\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e5\u01e6\u00051\u0000\u0000\u01e6Q\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e9\u00057\u0000\u0000\u01e8\u01ea\u0003N\'\u0000\u01e9"+
		"\u01e8\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea"+
		"\u01f0\u0001\u0000\u0000\u0000\u01eb\u01ec\u0005\u001f\u0000\u0000\u01ec"+
		"\u01ed\u0003T*\u0000\u01ed\u01ee\u0003R)\u0000\u01ee\u01f0\u0001\u0000"+
		"\u0000\u0000\u01ef\u01e7\u0001\u0000\u0000\u0000\u01ef\u01eb\u0001\u0000"+
		"\u0000\u0000\u01f0S\u0001\u0000\u0000\u0000\u01f1\u01f2\u0007\u0004\u0000"+
		"\u0000\u01f2U\u0001\u0000\u0000\u0000\u01f3\u01fc\u0005\u000e\u0000\u0000"+
		"\u01f4\u01fc\u0005\u000f\u0000\u0000\u01f5\u01fc\u0005\u0010\u0000\u0000"+
		"\u01f6\u01fc\u0005\u0011\u0000\u0000\u01f7\u01fc\u0005\u0016\u0000\u0000"+
		"\u01f8\u01fc\u0005\u001a\u0000\u0000\u01f9\u01fc\u0005\u001b\u0000\u0000"+
		"\u01fa\u01fc\u0003X,\u0000\u01fb\u01f3\u0001\u0000\u0000\u0000\u01fb\u01f4"+
		"\u0001\u0000\u0000\u0000\u01fb\u01f5\u0001\u0000\u0000\u0000\u01fb\u01f6"+
		"\u0001\u0000\u0000\u0000\u01fb\u01f7\u0001\u0000\u0000\u0000\u01fb\u01f8"+
		"\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fa"+
		"\u0001\u0000\u0000\u0000\u01fcW\u0001\u0000\u0000\u0000\u01fd\u01fe\u0007"+
		"\u0005\u0000\u0000\u01feY\u0001\u0000\u0000\u0000\u01ff\u0202\u0005\u0019"+
		"\u0000\u0000\u0200\u0202\u0003\\.\u0000\u0201\u01ff\u0001\u0000\u0000"+
		"\u0000\u0201\u0200\u0001\u0000\u0000\u0000\u0202[\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0007\u0006\u0000\u0000\u0204]\u0001\u0000\u0000\u0000\u0205"+
		"\u0206\u0007\u0007\u0000\u0000\u0206_\u0001\u0000\u0000\u0000\u0207\u020c"+
		"\u0003h4\u0000\u0208\u0209\u00055\u0000\u0000\u0209\u020b\u0003h4\u0000"+
		"\u020a\u0208\u0001\u0000\u0000\u0000\u020b\u020e\u0001\u0000\u0000\u0000"+
		"\u020c\u020a\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000"+
		"\u020da\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0005%\u0000\u0000\u0210\u0211\u0003`0\u0000\u0211c\u0001\u0000"+
		"\u0000\u0000\u0212\u0213\u0007\b\u0000\u0000\u0213e\u0001\u0000\u0000"+
		"\u0000\u0214\u0215\u0005\'\u0000\u0000\u0215g\u0001\u0000\u0000\u0000"+
		"\u0216\u021b\u00057\u0000\u0000\u0217\u0218\u00054\u0000\u0000\u0218\u021a"+
		"\u00057\u0000\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u021a\u021d\u0001"+
		"\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021b\u021c\u0001"+
		"\u0000\u0000\u0000\u021ci\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000"+
		"\u0000\u0000<knq\u007f\u0084\u0092\u009b\u00a7\u00aa\u00ad\u00b2\u00bb"+
		"\u00bd\u00c5\u00c8\u00cd\u00d0\u00d5\u00de\u00e0\u00e6\u00eb\u00ef\u00f4"+
		"\u00f7\u00fa\u0100\u0104\u0117\u0119\u011e\u0121\u0135\u0139\u0142\u014a"+
		"\u014c\u0153\u015b\u0169\u016e\u0175\u0185\u018d\u019b\u019f\u01a8\u01b3"+
		"\u01b9\u01c1\u01c9\u01d4\u01e0\u01e3\u01e9\u01ef\u01fb\u0201\u020c\u021b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}