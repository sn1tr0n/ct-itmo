// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/antlr/GG.g4 by ANTLR 4.13.1
package lab4.antlr

import lab4.*
import lab4.State
import lab4.Invoke


import org.antlr.v4.kotlinruntime.*
import org.antlr.v4.kotlinruntime.atn.*
import org.antlr.v4.kotlinruntime.atn.ATN.Companion.INVALID_ALT_NUMBER
import org.antlr.v4.kotlinruntime.dfa.*
import org.antlr.v4.kotlinruntime.misc.*
import org.antlr.v4.kotlinruntime.tree.*

@Suppress("FunctionName", "LocalVariableName", "EnumEntryName", "ConvertSecondaryConstructorToPrimary", "ConstantConditionIf", "RemoveRedundantBackticks")
public open class GGParser(input: TokenStream) : Parser(input) {
    private companion object {
        init {
            RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.runtimeVersion)
        }

        private const val SERIALIZED_ATN: String =
            "\u0004\u0001\u0015\u007f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\u0008\u0007\u0008\u0002\u0009\u0007\u0009\u0002\u000a\u0007\u000a\u0002\u000b\u0007\u000b\u0002\u000c\u0007\u000c\u0002\u000d\u0007\u000d\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u0024\u0008\u0000\u000b\u0000\u000c\u0000\u0025\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0032\u0008\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0046\u0008\u0004\u000a\u0004\u000c\u0004\u0049\u0009\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0008\u0001\u0008\u0001\u0008\u0001\u0008\u0001\u0009\u0001\u0009\u0001\u0009\u0001\u0009\u0001\u0009\u0001\u000a\u0001\u000a\u0001\u000a\u0001\u000b\u0001\u000b\u0004\u000b\u0063\u0008\u000b\u000b\u000b\u000c\u000b\u0064\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000d\u0003\u000d\u006b\u0008\u000d\u0001\u000d\u0001\u000d\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0073\u0008\u000e\u000a\u000e\u000c\u000e\u0076\u0009\u000e\u0003\u000e\u0078\u0008\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\u0008\u000a\u000c\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0001\u0002\u0000\u000f\u000f\u0011\u0011\u0077\u0000\u0020\u0001\u0000\u0000\u0000\u0002\u0029\u0001\u0000\u0000\u0000\u0004\u0033\u0001\u0000\u0000\u0000\u0006\u003a\u0001\u0000\u0000\u0000\u0008\u003c\u0001\u0000\u0000\u0000\u000a\u004c\u0001\u0000\u0000\u0000\u000c\u004e\u0001\u0000\u0000\u0000\u000e\u0051\u0001\u0000\u0000\u0000\u0010\u0054\u0001\u0000\u0000\u0000\u0012\u0058\u0001\u0000\u0000\u0000\u0014\u005d\u0001\u0000\u0000\u0000\u0016\u0062\u0001\u0000\u0000\u0000\u0018\u0066\u0001\u0000\u0000\u0000\u001a\u006a\u0001\u0000\u0000\u0000\u001c\u006e\u0001\u0000\u0000\u0000\u001e\u007b\u0001\u0000\u0000\u0000\u0020\u0023\u0003\u0002\u0001\u0000\u0021\u0024\u0003\u0004\u0002\u0000\u0022\u0024\u0003\u0008\u0004\u0000\u0023\u0021\u0001\u0000\u0000\u0000\u0023\u0022\u0001\u0000\u0000\u0000\u0024\u0025\u0001\u0000\u0000\u0000\u0025\u0023\u0001\u0000\u0000\u0000\u0025\u0026\u0001\u0000\u0000\u0000\u0026\u0027\u0001\u0000\u0000\u0000\u0027\u0028\u0005\u0000\u0000\u0001\u0028\u0001\u0001\u0000\u0000\u0000\u0029\u002a\u0005\u0001\u0000\u0000\u002a\u002b\u0005\u0006\u0000\u0000\u002b\u002c\u0005\u0010\u0000\u0000\u002c\u0031\u0005\u0005\u0000\u0000\u002d\u002e\u0005\u0002\u0000\u0000\u002e\u002f\u0005\u0006\u0000\u0000\u002f\u0030\u0005\u0013\u0000\u0000\u0030\u0032\u0005\u0005\u0000\u0000\u0031\u002d\u0001\u0000\u0000\u0000\u0031\u0032\u0001\u0000\u0000\u0000\u0032\u0003\u0001\u0000\u0000\u0000\u0033\u0034\u0003\u0006\u0003\u0000\u0034\u0035\u0006\u0002\uffff\uffff\u0000\u0035\u0036\u0005\u0006\u0000\u0000\u0036\u0037\u0005\u0013\u0000\u0000\u0037\u0038\u0006\u0002\uffff\uffff\u0000\u0038\u0039\u0005\u0005\u0000\u0000\u0039\u0005\u0001\u0000\u0000\u0000\u003a\u003b\u0007\u0000\u0000\u0000\u003b\u0007\u0001\u0000\u0000\u0000\u003c\u003d\u0003\u000c\u0006\u0000\u003d\u003e\u0003\u000a\u0005\u0000\u003e\u003f\u0006\u0004\uffff\uffff\u0000\u003f\u0040\u0005\u0004\u0000\u0000\u0040\u0041\u0003\u000e\u0007\u0000\u0041\u0042\u0005\u0006\u0000\u0000\u0042\u0047\u0003\u0014\u000a\u0000\u0043\u0044\u0005\u0008\u0000\u0000\u0044\u0046\u0003\u0014\u000a\u0000\u0045\u0043\u0001\u0000\u0000\u0000\u0046\u0049\u0001\u0000\u0000\u0000\u0047\u0045\u0001\u0000\u0000\u0000\u0047\u0048\u0001\u0000\u0000\u0000\u0048\u004a\u0001\u0000\u0000\u0000\u0049\u0047\u0001\u0000\u0000\u0000\u004a\u004b\u0005\u0005\u0000\u0000\u004b\u0009\u0001\u0000\u0000\u0000\u004c\u004d\u0005\u0010\u0000\u0000\u004d\u000b\u0001\u0000\u0000\u0000\u004e\u004f\u0003\u001c\u000e\u0000\u004f\u0050\u0006\u0006\uffff\uffff\u0000\u0050\u000d\u0001\u0000\u0000\u0000\u0051\u0052\u0003\u001c\u000e\u0000\u0052\u0053\u0006\u0007\uffff\uffff\u0000\u0053\u000f\u0001\u0000\u0000\u0000\u0054\u0055\u0003\u0006\u0003\u0000\u0055\u0056\u0006\u0008\uffff\uffff\u0000\u0056\u0057\u0003\u001a\u000d\u0000\u0057\u0011\u0001\u0000\u0000\u0000\u0058\u0059\u0003\u000a\u0005\u0000\u0059\u005a\u0006\u0009\uffff\uffff\u0000\u005a\u005b\u0003\u0018\u000c\u0000\u005b\u005c\u0003\u001a\u000d\u0000\u005c\u0013\u0001\u0000\u0000\u0000\u005d\u005e\u0003\u0016\u000b\u0000\u005e\u005f\u0006\u000a\uffff\uffff\u0000\u005f\u0015\u0001\u0000\u0000\u0000\u0060\u0063\u0003\u0010\u0008\u0000\u0061\u0063\u0003\u0012\u0009\u0000\u0062\u0060\u0001\u0000\u0000\u0000\u0062\u0061\u0001\u0000\u0000\u0000\u0063\u0064\u0001\u0000\u0000\u0000\u0064\u0062\u0001\u0000\u0000\u0000\u0064\u0065\u0001\u0000\u0000\u0000\u0065\u0017\u0001\u0000\u0000\u0000\u0066\u0067\u0003\u001c\u000e\u0000\u0067\u0068\u0006\u000c\uffff\uffff\u0000\u0068\u0019\u0001\u0000\u0000\u0000\u0069\u006b\u0005\u0014\u0000\u0000\u006a\u0069\u0001\u0000\u0000\u0000\u006a\u006b\u0001\u0000\u0000\u0000\u006b\u006c\u0001\u0000\u0000\u0000\u006c\u006d\u0006\u000d\uffff\uffff\u0000\u006d\u001b\u0001\u0000\u0000\u0000\u006e\u0077\u0005\u0009\u0000\u0000\u006f\u0074\u0003\u001e\u000f\u0000\u0070\u0071\u0005\u0003\u0000\u0000\u0071\u0073\u0003\u001e\u000f\u0000\u0072\u0070\u0001\u0000\u0000\u0000\u0073\u0076\u0001\u0000\u0000\u0000\u0074\u0072\u0001\u0000\u0000\u0000\u0074\u0075\u0001\u0000\u0000\u0000\u0075\u0078\u0001\u0000\u0000\u0000\u0076\u0074\u0001\u0000\u0000\u0000\u0077\u006f\u0001\u0000\u0000\u0000\u0077\u0078\u0001\u0000\u0000\u0000\u0078\u0079\u0001\u0000\u0000\u0000\u0079\u007a\u0005\u000a\u0000\u0000\u007a\u001d\u0001\u0000\u0000\u0000\u007b\u007c\u0005\u0012\u0000\u0000\u007c\u007d\u0006\u000f\uffff\uffff\u0000\u007d\u001f\u0001\u0000\u0000\u0000\u0009\u0023\u0025\u0031\u0047\u0062\u0064\u006a\u0074\u0077"

        private val ATN = ATNDeserializer().deserialize(SERIALIZED_ATN.toCharArray())

        private val DECISION_TO_DFA = Array(ATN.numberOfDecisions) {
            DFA(ATN.getDecisionState(it)!!, it)
        }

        private val SHARED_CONTEXT_CACHE = PredictionContextCache()
        private val RULE_NAMES: Array<String> =
            arrayOf("g", "init", "term", "termName", "nonTerm", "nonTermName", 
                    "inputWrapper", "outputWrapper", "ntTermName", "ntNonTermName", 
                    "nonTermInnerWrapper", "nonTermInner", "translationWrapper", 
                    "translationUpdateWrapper", "args", "arg")

        private val LITERAL_NAMES: Array<String?> =
            arrayOf(null, "'start'", "'WS'", "','", "'returns'", "';'", 
                    "':'", "'''", "'|'", "'['", "']'", "'{'", "'}'", "'<'", 
                    "'>'", "'eps'")

        private val SYMBOLIC_NAMES: Array<String?> =
            arrayOf(null, null, null, "COMMA", "RETURNS", "SEMICOLON", "COLON", 
                    "SINGLE_QUOTE", "OR", "SOBRACKET", "SCBRACKET", "COBRACKET", 
                    "CCBRACKET", "TOBRACKET", "TCBRACKET", "EPS", "NOT_CAPS_WORD", 
                    "CAPS_WORD", "ARG", "LITERAL", "UPDATE", "WS")

        private val VOCABULARY = VocabularyImpl(LITERAL_NAMES, SYMBOLIC_NAMES)

        private val TOKEN_NAMES: Array<String> = Array(SYMBOLIC_NAMES.size) {
            VOCABULARY.getLiteralName(it)
                ?: VOCABULARY.getSymbolicName(it)
                ?: "<INVALID>"
        }
    }

    public enum class Tokens(public val id: kotlin.Int) {
        EOF(-1),
        `T__0`(1),
        `T__1`(2),
        `COMMA`(3),
        `RETURNS`(4),
        `SEMICOLON`(5),
        `COLON`(6),
        `SINGLE_QUOTE`(7),
        `OR`(8),
        `SOBRACKET`(9),
        `SCBRACKET`(10),
        `COBRACKET`(11),
        `CCBRACKET`(12),
        `TOBRACKET`(13),
        `TCBRACKET`(14),
        `EPS`(15),
        `NOT_CAPS_WORD`(16),
        `CAPS_WORD`(17),
        `ARG`(18),
        `LITERAL`(19),
        `UPDATE`(20),
        `WS`(21)
    }

    public enum class Rules(public val id: kotlin.Int) {
        `g`(0),
        `init`(1),
        `term`(2),
        `termName`(3),
        `nonTerm`(4),
        `nonTermName`(5),
        `inputWrapper`(6),
        `outputWrapper`(7),
        `ntTermName`(8),
        `ntNonTermName`(9),
        `nonTermInnerWrapper`(10),
        `nonTermInner`(11),
        `translationWrapper`(12),
        `translationUpdateWrapper`(13),
        `args`(14),
        `arg`(15)
    }

    override var interpreter: ParserATNSimulator =
        @Suppress("LeakingThis")
        ParserATNSimulator(this, ATN, DECISION_TO_DFA, SHARED_CONTEXT_CACHE)

    override val grammarFileName: String =
        "GG.g4"

    @Deprecated("Use vocabulary instead", replaceWith = ReplaceWith("vocabulary"))
    override val tokenNames: Array<String> =
        TOKEN_NAMES

    override val ruleNames: Array<String> =
        RULE_NAMES

    override val atn: ATN =
        ATN

    override val vocabulary: Vocabulary =
        VOCABULARY

    override val serializedATN: String =
        SERIALIZED_ATN

    private val T__0 = Tokens.T__0.id
    private val T__1 = Tokens.T__1.id
    private val COMMA = Tokens.COMMA.id
    private val RETURNS = Tokens.RETURNS.id
    private val SEMICOLON = Tokens.SEMICOLON.id
    private val COLON = Tokens.COLON.id
    private val SINGLE_QUOTE = Tokens.SINGLE_QUOTE.id
    private val OR = Tokens.OR.id
    private val SOBRACKET = Tokens.SOBRACKET.id
    private val SCBRACKET = Tokens.SCBRACKET.id
    private val COBRACKET = Tokens.COBRACKET.id
    private val CCBRACKET = Tokens.CCBRACKET.id
    private val TOBRACKET = Tokens.TOBRACKET.id
    private val TCBRACKET = Tokens.TCBRACKET.id
    private val EPS = Tokens.EPS.id
    private val NOT_CAPS_WORD = Tokens.NOT_CAPS_WORD.id
    private val CAPS_WORD = Tokens.CAPS_WORD.id
    private val ARG = Tokens.ARG.id
    private val LITERAL = Tokens.LITERAL.id
    private val UPDATE = Tokens.UPDATE.id
    private val WS = Tokens.WS.id

    /* Named actions */

    /* Funcs */
    @Suppress("FunctionName")
    public open class GContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.g.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var states: MutableList<State> = mutableListOf()
        public fun getInit(): InitContext = getRuleContext(InitContext::class, 0)!!
        public fun EOF(): TerminalNode = getToken(Tokens.EOF.id, 0)!!
        public fun getTerm(): List<TermContext> = getRuleContexts(TermContext::class)
        public fun getTerm(i: Int): TermContext? = getRuleContext(TermContext::class, i)
        public fun getNonTerm(): List<NonTermContext> = getRuleContexts(NonTermContext::class)
        public fun getNonTerm(i: Int): NonTermContext? = getRuleContext(NonTermContext::class, i)

        public constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState) {
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterG(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitG(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitG(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun g(): GContext {
        var _localctx = GContext(context, state)
        enterRule(_localctx, 0, Rules.g.id)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 32
                init()
                this.state = 35 
                errorHandler.sync(this)
                _la = _input.LA(1)

                do {
                    if (true) {
                        this.state = 35
                        errorHandler.sync(this)

                        when (_input.LA(1)) {
                            EPS, CAPS_WORD -> /*LL1AltBlock*/ {
                                if (true) {
                                    this.state = 33
                                    term(_localctx.states)
                                }
                            }SOBRACKET -> /*LL1AltBlock*/ {
                                if (true) {
                                    this.state = 34
                                    nonTerm(_localctx.states)
                                }
                            }
                            else -> throw NoViableAltException(this)
                        }
                    }
                    this.state = 37 
                    errorHandler.sync(this)
                    _la = _input.LA(1)
                } while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 164352L) != 0L))
                this.state = 39
                match(EOF)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class InitContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.init.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public fun COLON(): List<TerminalNode> = getTokens(Tokens.COLON.id)
        public fun COLON(i: Int): TerminalNode = getToken(Tokens.COLON.id, i)!!
        public fun NOT_CAPS_WORD(): TerminalNode = getToken(Tokens.NOT_CAPS_WORD.id, 0)!!
        public fun SEMICOLON(): List<TerminalNode> = getTokens(Tokens.SEMICOLON.id)
        public fun SEMICOLON(i: Int): TerminalNode = getToken(Tokens.SEMICOLON.id, i)!!
        public fun LITERAL(): TerminalNode? = getToken(Tokens.LITERAL.id, 0)

        public constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState) {
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterInit(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitInit(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitInit(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun init(): InitContext {
        var _localctx = InitContext(context, state)
        enterRule(_localctx, 2, Rules.init.id)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 41
                match(T__0)
                this.state = 42
                match(COLON)
                this.state = 43
                match(NOT_CAPS_WORD)
                this.state = 44
                match(SEMICOLON)
                this.state = 49
                errorHandler.sync(this)
                _la = _input.LA(1)

                if (_la == T__1) {
                    if (true) {
                        this.state = 45
                        match(T__1)
                        this.state = 46
                        match(COLON)
                        this.state = 47
                        match(LITERAL)
                        this.state = 48
                        match(SEMICOLON)
                    }
                }
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class TermContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.term.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var states: MutableList<State>
        public var t: Term = Term()
        public fun getTermName(): TermNameContext = getRuleContext(TermNameContext::class, 0)!!
        public fun COLON(): TerminalNode = getToken(Tokens.COLON.id, 0)!!
        public fun LITERAL(): TerminalNode = getToken(Tokens.LITERAL.id, 0)!!
        public fun SEMICOLON(): TerminalNode = getToken(Tokens.SEMICOLON.id, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, states: MutableList<State>) : super(parent, invokingState) {
            this.states = states
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterTerm(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitTerm(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitTerm(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun term(states: MutableList<State>): TermContext {
        var _localctx = TermContext(context, state, states)
        enterRule(_localctx, 4, Rules.term.id)
        _localctx!!.states.add(_localctx.t)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 51
                termName()
                _localctx.t.name = _localctx.getTermName().text
                this.state = 53
                match(COLON)
                this.state = 54
                match(LITERAL)
                _localctx.t.pattern = _localctx.LITERAL().text
                this.state = 56
                match(SEMICOLON)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class TermNameContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.termName.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public fun EPS(): TerminalNode? = getToken(Tokens.EPS.id, 0)
        public fun CAPS_WORD(): TerminalNode? = getToken(Tokens.CAPS_WORD.id, 0)

        public constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState) {
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterTermName(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitTermName(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitTermName(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun termName(): TermNameContext {
        var _localctx = TermNameContext(context, state)
        enterRule(_localctx, 6, Rules.termName.id)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 58
                _la = _input.LA(1)

                if (!(_la == EPS || _la == CAPS_WORD)) {
                    errorHandler.recoverInline(this)
                }
                else {
                    if (_input.LA(1) == Tokens.EOF.id) {
                        isMatchedEOF = true
                    }

                    errorHandler.reportMatch(this)
                    consume()
                }
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class NonTermContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.nonTerm.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var states: MutableList<State>
        public var nt: NonTerm = NonTerm();
        public fun getInputWrapper(): InputWrapperContext = getRuleContext(InputWrapperContext::class, 0)!!
        public fun getNonTermName(): NonTermNameContext = getRuleContext(NonTermNameContext::class, 0)!!
        public fun RETURNS(): TerminalNode = getToken(Tokens.RETURNS.id, 0)!!
        public fun getOutputWrapper(): OutputWrapperContext = getRuleContext(OutputWrapperContext::class, 0)!!
        public fun COLON(): TerminalNode = getToken(Tokens.COLON.id, 0)!!
        public fun SEMICOLON(): TerminalNode = getToken(Tokens.SEMICOLON.id, 0)!!
        public fun getNonTermInnerWrapper(): List<NonTermInnerWrapperContext> = getRuleContexts(NonTermInnerWrapperContext::class)
        public fun getNonTermInnerWrapper(i: Int): NonTermInnerWrapperContext? = getRuleContext(NonTermInnerWrapperContext::class, i)
        public fun OR(): List<TerminalNode> = getTokens(Tokens.OR.id)
        public fun OR(i: Int): TerminalNode = getToken(Tokens.OR.id, i)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, states: MutableList<State>) : super(parent, invokingState) {
            this.states = states
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterNonTerm(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitNonTerm(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitNonTerm(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun nonTerm(states: MutableList<State>): NonTermContext {
        var _localctx = NonTermContext(context, state, states)
        enterRule(_localctx, 8, Rules.nonTerm.id)
        _localctx!!.states.add(_localctx.nt)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 60
                inputWrapper(_localctx.nt)
                this.state = 61
                nonTermName()
                _localctx.nt.name = _localctx.getNonTermName().text
                this.state = 63
                match(RETURNS)
                this.state = 64
                outputWrapper(_localctx.nt)
                this.state = 65
                match(COLON)
                if (true) {
                    this.state = 66
                    nonTermInnerWrapper(_localctx.nt)
                    this.state = 71
                    errorHandler.sync(this)
                    _la = _input.LA(1)

                    while (_la == OR) {
                        if (true) {
                            if (true) {
                                this.state = 67
                                match(OR)
                                this.state = 68
                                nonTermInnerWrapper(_localctx.nt)
                            }
                        }
                        this.state = 73
                        errorHandler.sync(this)
                        _la = _input.LA(1)
                    }
                }
                this.state = 74
                match(SEMICOLON)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class NonTermNameContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.nonTermName.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public fun NOT_CAPS_WORD(): TerminalNode = getToken(Tokens.NOT_CAPS_WORD.id, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState) {
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterNonTermName(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitNonTermName(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitNonTermName(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun nonTermName(): NonTermNameContext {
        var _localctx = NonTermNameContext(context, state)
        enterRule(_localctx, 10, Rules.nonTermName.id)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 76
                match(NOT_CAPS_WORD)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class InputWrapperContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.inputWrapper.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var nt: NonTerm
        public fun getArgs(): ArgsContext = getRuleContext(ArgsContext::class, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, nt: NonTerm) : super(parent, invokingState) {
            this.nt = nt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterInputWrapper(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitInputWrapper(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitInputWrapper(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun inputWrapper(nt: NonTerm): InputWrapperContext {
        var _localctx = InputWrapperContext(context, state, nt)
        enterRule(_localctx, 12, Rules.inputWrapper.id)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 78
                args()
                _localctx!!.nt.inputs = _localctx.getArgs().inputs
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class OutputWrapperContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.outputWrapper.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var nt: NonTerm
        public fun getArgs(): ArgsContext = getRuleContext(ArgsContext::class, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, nt: NonTerm) : super(parent, invokingState) {
            this.nt = nt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterOutputWrapper(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitOutputWrapper(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitOutputWrapper(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun outputWrapper(nt: NonTerm): OutputWrapperContext {
        var _localctx = OutputWrapperContext(context, state, nt)
        enterRule(_localctx, 14, Rules.outputWrapper.id)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 81
                args()
                _localctx!!.nt.outputs = _localctx.getArgs().inputs
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class NtTermNameContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.ntTermName.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var group: MutableList<Invoke>
        public var invoke: TermInvoke = TermInvoke()
        public fun getTermName(): TermNameContext = getRuleContext(TermNameContext::class, 0)!!
        public fun getTranslationUpdateWrapper(): TranslationUpdateWrapperContext = getRuleContext(TranslationUpdateWrapperContext::class, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, group: MutableList<Invoke>) : super(parent, invokingState) {
            this.group = group
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterNtTermName(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitNtTermName(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitNtTermName(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun ntTermName(group: MutableList<Invoke>): NtTermNameContext {
        var _localctx = NtTermNameContext(context, state, group)
        enterRule(_localctx, 16, Rules.ntTermName.id)
         _localctx!!.group.add(_localctx.invoke) 

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 84
                termName()
                _localctx.invoke.name = _localctx.getTermName().text
                this.state = 86
                translationUpdateWrapper(_localctx.invoke)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class NtNonTermNameContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.ntNonTermName.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var group: MutableList<Invoke>
        public var invoke: NonTermInvoke = NonTermInvoke()
        public fun getNonTermName(): NonTermNameContext = getRuleContext(NonTermNameContext::class, 0)!!
        public fun getTranslationWrapper(): TranslationWrapperContext = getRuleContext(TranslationWrapperContext::class, 0)!!
        public fun getTranslationUpdateWrapper(): TranslationUpdateWrapperContext = getRuleContext(TranslationUpdateWrapperContext::class, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, group: MutableList<Invoke>) : super(parent, invokingState) {
            this.group = group
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterNtNonTermName(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitNtNonTermName(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitNtNonTermName(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun ntNonTermName(group: MutableList<Invoke>): NtNonTermNameContext {
        var _localctx = NtNonTermNameContext(context, state, group)
        enterRule(_localctx, 18, Rules.ntNonTermName.id)
        _localctx!!.group.add(_localctx.invoke)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 88
                nonTermName()
                _localctx.invoke.name = _localctx.getNonTermName().NOT_CAPS_WORD().text
                this.state = 90
                translationWrapper(_localctx.invoke)
                this.state = 91
                translationUpdateWrapper(_localctx.invoke)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class NonTermInnerWrapperContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.nonTermInnerWrapper.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var nt: NonTerm
        public fun getNonTermInner(): NonTermInnerContext = getRuleContext(NonTermInnerContext::class, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, nt: NonTerm) : super(parent, invokingState) {
            this.nt = nt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterNonTermInnerWrapper(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitNonTermInnerWrapper(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitNonTermInnerWrapper(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun nonTermInnerWrapper(nt: NonTerm): NonTermInnerWrapperContext {
        var _localctx = NonTermInnerWrapperContext(context, state, nt)
        enterRule(_localctx, 20, Rules.nonTermInnerWrapper.id)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 93
                nonTermInner()
                _localctx!!.nt.transitionByNames.add(_localctx.getNonTermInner().group)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class NonTermInnerContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.nonTermInner.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var group: MutableList<Invoke> = mutableListOf()
        public fun getNtTermName(): List<NtTermNameContext> = getRuleContexts(NtTermNameContext::class)
        public fun getNtTermName(i: Int): NtTermNameContext? = getRuleContext(NtTermNameContext::class, i)
        public fun getNtNonTermName(): List<NtNonTermNameContext> = getRuleContexts(NtNonTermNameContext::class)
        public fun getNtNonTermName(i: Int): NtNonTermNameContext? = getRuleContext(NtNonTermNameContext::class, i)

        public constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState) {
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterNonTermInner(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitNonTermInner(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitNonTermInner(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun nonTermInner(): NonTermInnerContext {
        var _localctx = NonTermInnerContext(context, state)
        enterRule(_localctx, 22, Rules.nonTermInner.id)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 98 
                errorHandler.sync(this)
                _la = _input.LA(1)

                do {
                    if (true) {
                        this.state = 98
                        errorHandler.sync(this)

                        when (_input.LA(1)) {
                            EPS, CAPS_WORD -> /*LL1AltBlock*/ {
                                if (true) {
                                    this.state = 96
                                    ntTermName(_localctx.group)
                                }
                            }NOT_CAPS_WORD -> /*LL1AltBlock*/ {
                                if (true) {
                                    this.state = 97
                                    ntNonTermName(_localctx.group)
                                }
                            }
                            else -> throw NoViableAltException(this)
                        }
                    }
                    this.state = 100 
                    errorHandler.sync(this)
                    _la = _input.LA(1)
                } while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 229376L) != 0L))
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class TranslationWrapperContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.translationWrapper.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var invoke: NonTermInvoke
        public fun getArgs(): ArgsContext = getRuleContext(ArgsContext::class, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, invoke: NonTermInvoke) : super(parent, invokingState) {
            this.invoke = invoke
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterTranslationWrapper(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitTranslationWrapper(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitTranslationWrapper(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun translationWrapper(invoke: NonTermInvoke): TranslationWrapperContext {
        var _localctx = TranslationWrapperContext(context, state, invoke)
        enterRule(_localctx, 24, Rules.translationWrapper.id)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 102
                args()
                _localctx!!.invoke.inputs = _localctx.getArgs().inputs
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class TranslationUpdateWrapperContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.translationUpdateWrapper.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var invoke: Invoke
        public fun UPDATE(): TerminalNode? = getToken(Tokens.UPDATE.id, 0)

        public constructor(parent: ParserRuleContext?, invokingState: Int, invoke: Invoke) : super(parent, invokingState) {
            this.invoke = invoke
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterTranslationUpdateWrapper(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitTranslationUpdateWrapper(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitTranslationUpdateWrapper(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun translationUpdateWrapper(invoke: Invoke): TranslationUpdateWrapperContext {
        var _localctx = TranslationUpdateWrapperContext(context, state, invoke)
        enterRule(_localctx, 26, Rules.translationUpdateWrapper.id)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 106
                errorHandler.sync(this)
                _la = _input.LA(1)

                if (_la == UPDATE) {
                    if (true) {
                        this.state = 105
                        match(UPDATE)
                    }
                }
                _localctx!!.invoke.update = _localctx.UPDATE()?.text
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class ArgsContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.args.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var inputs: MutableList<String> = mutableListOf()
        public fun SOBRACKET(): TerminalNode = getToken(Tokens.SOBRACKET.id, 0)!!
        public fun SCBRACKET(): TerminalNode = getToken(Tokens.SCBRACKET.id, 0)!!
        public fun getArg(): List<ArgContext> = getRuleContexts(ArgContext::class)
        public fun getArg(i: Int): ArgContext? = getRuleContext(ArgContext::class, i)
        public fun COMMA(): List<TerminalNode> = getTokens(Tokens.COMMA.id)
        public fun COMMA(i: Int): TerminalNode = getToken(Tokens.COMMA.id, i)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState) {
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterArgs(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitArgs(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitArgs(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun args(): ArgsContext {
        var _localctx = ArgsContext(context, state)
        enterRule(_localctx, 28, Rules.args.id)
        var _la: Int

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 110
                match(SOBRACKET)
                this.state = 119
                errorHandler.sync(this)
                _la = _input.LA(1)

                if (_la == ARG) {
                    if (true) {
                        this.state = 111
                        arg(_localctx.inputs)
                        this.state = 116
                        errorHandler.sync(this)
                        _la = _input.LA(1)

                        while (_la == COMMA) {
                            if (true) {
                                if (true) {
                                    this.state = 112
                                    match(COMMA)
                                    this.state = 113
                                    arg(_localctx.inputs)
                                }
                            }
                            this.state = 118
                            errorHandler.sync(this)
                            _la = _input.LA(1)
                        }
                    }
                }
                this.state = 121
                match(SCBRACKET)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

    @Suppress("FunctionName")
    public open class ArgContext : ParserRuleContext {
        override var ruleIndex: Int
            get() = Rules.arg.id
            set(@Suppress("UNUSED_PARAMETER") value) = throw RuntimeException()

        public var inputs: MutableList<String> = mutableListOf()
        public fun ARG(): TerminalNode = getToken(Tokens.ARG.id, 0)!!

        public constructor(parent: ParserRuleContext?, invokingState: Int, inputs: MutableList<String> = mutableListOf()) : super(parent, invokingState) {
            this.inputs = inputs
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.enterArg(this)
            }
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is GGListener) {
                listener.exitArg(this)
            }
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            if (visitor is GGVisitor) {
                return visitor.visitArg(this)
            } else {
                return visitor.visitChildren(this)!!
            }
        }
    }


    public fun arg(inputs: MutableList<String> = mutableListOf()): ArgContext {
        var _localctx = ArgContext(context, state, inputs)
        enterRule(_localctx, 30, Rules.arg.id)

        try {
            enterOuterAlt(_localctx, 1)
            if (true) {
                this.state = 123
                match(ARG)
                _localctx!!.inputs.add(_localctx.ARG().text)
            }
        }
        catch (re: RecognitionException) {
            _localctx.exception = re
            errorHandler.reportError(this, re)
            errorHandler.recover(this, re)
        }
        finally {
            exitRule()
        }

        return _localctx
    }

}