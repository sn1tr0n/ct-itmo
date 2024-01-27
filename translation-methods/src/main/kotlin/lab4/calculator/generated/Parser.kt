package lab4.calculator.generated

import java.lang.AssertionError
import kotlin.math.*
import lab4.*

class Parser(source: String) {
  private val lexer = LexicalAnalyzer(source, ws = Regex("[ \n\t\r]+"))

  fun `e`(): `STNodee` {
    val result = `STNodee`(GState.NonTerm.`e`)

    when (lexer.currentToken) {
      is GState.Term.`NUMBER`,
      is GState.Term.`LB`,
      is GState.Term.`SLB`,
      is GState.Term.`MINUS` -> {
        val `t0` = `t`()
        result.addChild(`t0`)

        val `ePrime0` = `ePrime`(t0.res)
        result.addChild(`ePrime0`)
        result.res = ePrime0.res
      }
      else -> throw AssertionError("error while parsing `e` nonTerm")
    }

    return result
  }

  fun `ePrime`(acc: Int): `STNodeePrime` {
    val result = `STNodeePrime`(GState.NonTerm.`ePrime`)

    when (lexer.currentToken) {
      is GState.Term.`PLUS` -> {
        val `PLUS0` = lexer.currentToken as GState.Term.`PLUS`
        result.addChild(STNode(`PLUS0`, `PLUS0`.text))

        lexer.nextToken()
        val `t0` = `t`()
        result.addChild(`t0`)

        val `ePrime0` = `ePrime`(acc + t0.res)
        result.addChild(`ePrime0`)
        result.res = ePrime0.res
      }
      is GState.Term.`MINUS` -> {
        val `MINUS0` = lexer.currentToken as GState.Term.`MINUS`
        result.addChild(STNode(`MINUS0`, `MINUS0`.text))

        lexer.nextToken()
        val `t0` = `t`()
        result.addChild(`t0`)

        val `ePrime0` = `ePrime`(acc - t0.res)
        result.addChild(`ePrime0`)
        result.res = ePrime0.res
      }
      is GState.Term.`end`,
      is GState.Term.`RB`,
      is GState.Term.`COMMA`,
      is GState.Term.`SRB` -> {
        result.addChild(STNode(GState.Term.eps()))
        result.res = acc
      }
      else -> throw AssertionError("error while parsing `ePrime` nonTerm")
    }

    return result
  }

  fun `t`(): `STNodet` {
    val result = `STNodet`(GState.NonTerm.`t`)

    when (lexer.currentToken) {
      is GState.Term.`NUMBER`,
      is GState.Term.`LB`,
      is GState.Term.`SLB`,
      is GState.Term.`MINUS` -> {
        val `f0` = `f`()
        result.addChild(`f0`)

        val `tPrime0` = `tPrime`(f0.res)
        result.addChild(`tPrime0`)
        result.res = tPrime0.res
      }
      else -> throw AssertionError("error while parsing `t` nonTerm")
    }

    return result
  }

  fun `tPrime`(acc: Int): `STNodetPrime` {
    val result = `STNodetPrime`(GState.NonTerm.`tPrime`)

    when (lexer.currentToken) {
      is GState.Term.`MUL` -> {
        val `MUL0` = lexer.currentToken as GState.Term.`MUL`
        result.addChild(STNode(`MUL0`, `MUL0`.text))

        lexer.nextToken()
        val `f0` = `f`()
        result.addChild(`f0`)

        val `tPrime0` = `tPrime`(acc * f0.res)
        result.addChild(`tPrime0`)
        result.res = tPrime0.res
      }
      is GState.Term.`DIV` -> {
        val `DIV0` = lexer.currentToken as GState.Term.`DIV`
        result.addChild(STNode(`DIV0`, `DIV0`.text))

        lexer.nextToken()
        val `f0` = `f`()
        result.addChild(`f0`)

        val `tPrime0` = `tPrime`(acc / f0.res)
        result.addChild(`tPrime0`)
        result.res = tPrime0.res
      }
      is GState.Term.`PLUS`,
      is GState.Term.`MINUS`,
      is GState.Term.`end`,
      is GState.Term.`RB`,
      is GState.Term.`COMMA`,
      is GState.Term.`SRB` -> {
        result.addChild(STNode(GState.Term.eps()))
        result.res = acc
      }
      else -> throw AssertionError("error while parsing `tPrime` nonTerm")
    }

    return result
  }

  fun `f`(): `STNodef` {
    val result = `STNodef`(GState.NonTerm.`f`)

    when (lexer.currentToken) {
      is GState.Term.`NUMBER` -> {
        val `NUMBER0` = lexer.currentToken as GState.Term.`NUMBER`
        result.addChild(STNode(`NUMBER0`, `NUMBER0`.text))
        result.res = NUMBER0.text.toInt()
        lexer.nextToken()
      }
      is GState.Term.`LB` -> {
        val `LB0` = lexer.currentToken as GState.Term.`LB`
        result.addChild(STNode(`LB0`, `LB0`.text))

        lexer.nextToken()
        val `e0` = `e`()
        result.addChild(`e0`)
        result.res = e0.res
        val `RB0` = lexer.currentToken as GState.Term.`RB`
        result.addChild(STNode(`RB0`, `RB0`.text))

        lexer.nextToken()
      }
      is GState.Term.`SLB` -> {
        val `SLB0` = lexer.currentToken as GState.Term.`SLB`
        result.addChild(STNode(`SLB0`, `SLB0`.text))

        lexer.nextToken()
        val `e0` = `e`()
        result.addChild(`e0`)

        val `COMMA0` = lexer.currentToken as GState.Term.`COMMA`
        result.addChild(STNode(`COMMA0`, `COMMA0`.text))

        lexer.nextToken()
        val `e1` = `e`()
        result.addChild(`e1`)

        val `SRB0` = lexer.currentToken as GState.Term.`SRB`
        result.addChild(STNode(`SRB0`, `SRB0`.text))
        result.res = com.google.common.math.BigIntegerMath.binomial(e0.res, e1.res).toInt()
        lexer.nextToken()
      }
      is GState.Term.`MINUS` -> {
        val `MINUS0` = lexer.currentToken as GState.Term.`MINUS`
        result.addChild(STNode(`MINUS0`, `MINUS0`.text))

        lexer.nextToken()
        val `f0` = `f`()
        result.addChild(`f0`)
        result.res = -f0.res
      }
      else -> throw AssertionError("error while parsing `f` nonTerm")
    }

    return result
  }

  fun parse(): `STNodee` {
    val result = `e`()
    if (lexer.currentToken != GState.Term.end()) {
      throw AssertionError("expected end after parse")
    }

    return result
  }
}
