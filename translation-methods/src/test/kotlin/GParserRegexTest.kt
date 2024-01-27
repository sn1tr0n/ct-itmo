import lab4.regex.generated.Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith
class GParserRegexTest {

    private fun parserForString(s: String) = Parser(s)

    private fun assertSuccess(s: String, expected: String = s) {
        assertDoesNotThrow {
            val result = parserForString(s).parse()
            assertEquals(expected, result.toString())
        }
    }

    private fun assertFailure(s: String) {
        assertThrows<Throwable> {
            parserForString(s).parse()
        }
    }

    @Test
    fun positive_blankString() {
        assertSuccess("")
    }

    @Test
    fun positive_blankStringWithSpaces() {
        assertSuccess("          ", "")
    }

    @Test
    fun positive_symbols() {
        assertSuccess("abcd")
    }

    @Test
    fun негативный_буквы() {
        assertFailure("абвгд")
    }

    @Test
    fun mixed_singleOperators() {
        assertSuccess("|")
        assertSuccess("()")

        assertFailure("*")

        assertSuccess("|||||||||||")
        assertSuccess("(((((())))))*")
    }

    @Test
    fun positive_allAtOnce() {
        assertSuccess("aa|bb")
        assertSuccess("aa*bb")
        assertSuccess("a*b*c")
        assertSuccess("a*b*c*")
        assertSuccess("a*")
        assertSuccess("((a)*)*")
        assertSuccess("((a*)*|(b*)*|(c*)*)*")
    }

    @Test
    fun negative_allAtOnce() {
        assertFailure("aa|*bb")
        assertFailure("*b")
        assertFailure(")(a*b*c")
        assertFailure("a*(*b)*c*")
        assertFailure("|*")
        assertFailure("((a)*){}*")
        assertFailure("((a**|(b*)*|(c*)*)")
    }

    @Test
    fun positive_modification() {
        assertSuccess("a{1}")
        assertSuccess("(a){1}")
        assertSuccess("(a{1}b{2}c{3})*")
        assertSuccess("(a{1}|b{2}|c{3})*|a{1}")
    }

    @Test
    fun negative_modification() {
        assertFailure("a{1*}")
        assertFailure("(a)*{1}")
        assertFailure("(a{1}*b{2}*c{3})*")
        assertFailure("(a{1}|b{2}*|c{3})*|a{1}")
    }
}