package lab2

import java.io.IOException
import java.io.InputStream
import java.text.ParseException

class LexicalAnalyzer(
    private val inputStream: InputStream
) {
    var currentPosition = 0
        private set
    var currentChar = 0
        private set
    var currentToken: Token = Token.Term.Epsilon
        private set
    private var skipNextGetting = false

    private fun nextChar() {
        if (skipNextGetting) {
            skipNextGetting = false
            return
        }

        currentPosition++
        try {
            currentChar = inputStream.read()
        } catch (ioe: IOException) {
            throw ParseException("Error while parsing pos=$currentPosition", currentPosition)
        }
    }

    private fun isCurrentBlank() = currentChar != -1 && currentChar.toChar().isWhitespace()
    private fun isCurrentDigit() = currentChar != -1 && currentChar.toChar().isDigit()

    fun nextToken() {
        nextChar()

        while (isCurrentBlank()) {
            nextChar()
        }

        if (currentChar == -1) {
            currentToken = Token.Term.End
            return
        }

        currentToken = when (currentChar.toChar()) {
            '(' -> Token.Term.LBracket
            ')' -> Token.Term.RBracket
            '{' -> Token.Term.LCurlBracket
            '}' -> Token.Term.RCurlBracket
            '|' -> Token.Term.Or
            '*' -> Token.Term.Kleene
            in 'a'..'z' -> Token.Term.Symbol(currentChar.toChar())
            in '0'..'9' -> {
                var number = 0

                while (isCurrentDigit()) {
                    number *= 10
                    number += currentChar - '0'.code
                    nextChar()
                }

                skipNextGetting = true

                Token.Term.Number(number)
            }
            else -> throw ParseException("Unexpected char=${currentChar.toChar()} at pos=$currentPosition", currentPosition)
        }
    }

}