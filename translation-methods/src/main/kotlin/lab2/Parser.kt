package lab2

import java.io.InputStream
import java.text.ParseException

class Parser(
    inputStream: InputStream
) {
    private val lexicalAnalyzer = LexicalAnalyzer(inputStream)

    fun A(): SyntaxTreeNode {
        val token = lexicalAnalyzer.currentToken
        when (token) {
            is Token.Term.LBracket, is Token.Term.Or, is Token.Term.Symbol -> {
                // B
                val b = B()

                // A1
                val a1 = A1()

                return SyntaxTreeNode(
                    Token.NotTerm.A,
                    listOf(
                        b,
                        a1
                    )
                )
            }

            is Token.Term.End, is Token.Term.RBracket -> {
                return SyntaxTreeNode(
                    Token.NotTerm.A,
                    listOf(
                        SyntaxTreeNode(Token.Term.Epsilon)
                    )
                )
            }

            else -> throw AssertionError("A")
        }
    }

    fun A1(): SyntaxTreeNode {
        val token = lexicalAnalyzer.currentToken
        when (token) {
            is Token.Term.Or -> {
                // |
                lexicalAnalyzer.nextToken()
                // B
                val b = B()
                // A1
                val a1 = A1()

                return SyntaxTreeNode(
                    Token.NotTerm.A1, children = listOf(
                        SyntaxTreeNode(Token.Term.Or),
                        b,
                        a1
                    )
                )
            }

            is Token.Term.End, is Token.Term.RBracket -> return SyntaxTreeNode(
                Token.NotTerm.A1, children = listOf(
                    SyntaxTreeNode(Token.Term.Epsilon)
                )
            )

            else -> throw AssertionError("A1")
        }
    }

    fun B(): SyntaxTreeNode {
        when (lexicalAnalyzer.currentToken) {
            is Token.Term.LBracket, is Token.Term.Symbol -> {
                // C
                val c = C()
                // B1
                val b1 = B1()

                return SyntaxTreeNode(
                    Token.NotTerm.B,
                    children = listOf(
                        c,
                        b1
                    )
                )
            }

            is Token.Term.End, is Token.Term.Or, is Token.Term.RBracket -> return SyntaxTreeNode(
                Token.NotTerm.B, children = listOf(
                    SyntaxTreeNode(Token.Term.Epsilon)
                )
            )

            else -> throw AssertionError("B")
        }
    }


    fun B1(): SyntaxTreeNode {
        when (lexicalAnalyzer.currentToken) {
            is Token.Term.LBracket, is Token.Term.Symbol -> {
                // C
                val c = C()
                // B1
                val b1 = B1()

                return SyntaxTreeNode(
                    Token.NotTerm.B1,
                    listOf(
                        c,
                        b1
                    )
                )
            }

            is Token.Term.RBracket, is Token.Term.Or, is Token.Term.End -> {
                return SyntaxTreeNode(
                    Token.NotTerm.B1,
                    listOf(
                        SyntaxTreeNode(Token.Term.Epsilon)
                    )
                )
            }

            else -> throw AssertionError("B1")
        }
    }

    fun C(): SyntaxTreeNode {
        when (lexicalAnalyzer.currentToken) {
            is Token.Term.LBracket -> {
                // (
                lexicalAnalyzer.nextToken()

                // A
                val a = A()

                // )
                if (lexicalAnalyzer.currentToken != Token.Term.RBracket) {
                    throw AssertionError("C ~ (A)D")
                }
                lexicalAnalyzer.nextToken()
                val d = D()

                return SyntaxTreeNode(
                    Token.NotTerm.C,
                    listOf(
                        SyntaxTreeNode(Token.Term.LBracket),
                        a,
                        SyntaxTreeNode(Token.Term.RBracket),
                        d
                    )
                )
            }

            is Token.Term.Symbol -> {
                // char
                val token = lexicalAnalyzer.currentToken
                lexicalAnalyzer.nextToken()

                // D
                val d = D()

                return SyntaxTreeNode(
                    Token.NotTerm.C,
                    listOf(
                        SyntaxTreeNode(token),
                        d
                    )
                )
            }

            else -> throw AssertionError("C")
        }
    }

    fun D(): SyntaxTreeNode {
        when (lexicalAnalyzer.currentToken) {
            is Token.Term.Kleene -> {
                // *
                lexicalAnalyzer.nextToken()
                return SyntaxTreeNode(
                    Token.NotTerm.D,
                    listOf(SyntaxTreeNode(Token.Term.Kleene))
                )
            }

            is Token.Term.LCurlBracket -> {
                // {
                lexicalAnalyzer.nextToken()

                // N
                val n = N()

                // }
                if (lexicalAnalyzer.currentToken != Token.Term.RCurlBracket) {
                    throw AssertionError("D ~ {number}")
                }
                lexicalAnalyzer.nextToken()

                return SyntaxTreeNode(Token.NotTerm.D,
                    listOf(
                        SyntaxTreeNode(Token.Term.LCurlBracket),
                        n,
                        SyntaxTreeNode(Token.Term.RCurlBracket)
                    )
                )
            }

            is Token.Term.Symbol, is Token.Term.LBracket, is Token.Term.RBracket, is Token.Term.End, is Token.Term.Or -> {
                return SyntaxTreeNode(
                    Token.NotTerm.D,
                    listOf(SyntaxTreeNode(Token.Term.Epsilon))
                )
            }

            else -> throw AssertionError("C")
        }
    }

    fun N(): SyntaxTreeNode {
        when (lexicalAnalyzer.currentToken) {
            is Token.Term.Number -> {
                val number = lexicalAnalyzer.currentToken
                lexicalAnalyzer.nextToken()
                return SyntaxTreeNode(Token.NotTerm.N,
                    listOf(
                        SyntaxTreeNode(number)
                    )
                )
            }

            is Token.Term.Symbol, is Token.Term.LBracket, is Token.Term.RCurlBracket, is Token.Term.RBracket, is Token.Term.End, is Token.Term.Or -> {
                return SyntaxTreeNode(
                    Token.NotTerm.N,
                    listOf(SyntaxTreeNode(Token.Term.Epsilon))
                )
            }

            else -> throw AssertionError("C")
        }
    }


    fun parse(): SyntaxTreeNode {
        lexicalAnalyzer.nextToken()
        val result = A()

        if (lexicalAnalyzer.currentToken != Token.Term.End) {
            throw ParseException("smth in the end", lexicalAnalyzer.currentPosition)
        }

        return result
    }
}
