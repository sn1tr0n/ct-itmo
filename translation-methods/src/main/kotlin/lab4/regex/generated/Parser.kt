package lab4.regex.generated

import java.lang.AssertionError
import kotlin.math.*
import lab4.*

class Parser(source: String) {
  private val lexer = LexicalAnalyzer(source)

  fun `a`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`a`)

    when (lexer.currentToken) {
      is GState.Term.`LB`,
      is GState.Term.`CHAR`,
      is GState.Term.`OR`,
      is GState.Term.`end`,
      is GState.Term.`RB` -> {
        val `b0` = `b`()
        result.addChild(`b0`)

        val `a10` = `a1`()
        result.addChild(`a10`)
      }
      else -> throw AssertionError("error while parsing `a` nonTerm")
    }

    return result
  }

  fun `a1`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`a1`)

    when (lexer.currentToken) {
      is GState.Term.`OR` -> {
        val `OR0` = lexer.currentToken as GState.Term.`OR`
        result.addChild(STNode(`OR0`, `OR0`.text))

        lexer.nextToken()
        val `b0` = `b`()
        result.addChild(`b0`)

        val `a10` = `a1`()
        result.addChild(`a10`)
      }
      is GState.Term.`end`,
      is GState.Term.`RB` -> {
        result.addChild(STNode(GState.Term.eps()))
      }
      else -> throw AssertionError("error while parsing `a1` nonTerm")
    }

    return result
  }

  fun `b`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`b`)

    when (lexer.currentToken) {
      is GState.Term.`LB`,
      is GState.Term.`CHAR` -> {
        val `c0` = `c`()
        result.addChild(`c0`)

        val `b10` = `b1`()
        result.addChild(`b10`)
      }
      is GState.Term.`OR`,
      is GState.Term.`end`,
      is GState.Term.`RB` -> {
        result.addChild(STNode(GState.Term.eps()))
      }
      else -> throw AssertionError("error while parsing `b` nonTerm")
    }

    return result
  }

  fun `b1`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`b1`)

    when (lexer.currentToken) {
      is GState.Term.`LB`,
      is GState.Term.`CHAR` -> {
        val `c0` = `c`()
        result.addChild(`c0`)

        val `b10` = `b1`()
        result.addChild(`b10`)
      }
      is GState.Term.`OR`,
      is GState.Term.`end`,
      is GState.Term.`RB` -> {
        result.addChild(STNode(GState.Term.eps()))
      }
      else -> throw AssertionError("error while parsing `b1` nonTerm")
    }

    return result
  }

  fun `c`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`c`)

    when (lexer.currentToken) {
      is GState.Term.`LB` -> {
        val `LB0` = lexer.currentToken as GState.Term.`LB`
        result.addChild(STNode(`LB0`, `LB0`.text))

        lexer.nextToken()
        val `a0` = `a`()
        result.addChild(`a0`)

        val `RB0` = lexer.currentToken as GState.Term.`RB`
        result.addChild(STNode(`RB0`, `RB0`.text))

        lexer.nextToken()
        val `d0` = `d`()
        result.addChild(`d0`)
      }
      is GState.Term.`CHAR` -> {
        val `CHAR0` = lexer.currentToken as GState.Term.`CHAR`
        result.addChild(STNode(`CHAR0`, `CHAR0`.text))

        lexer.nextToken()
        val `d0` = `d`()
        result.addChild(`d0`)
      }
      else -> throw AssertionError("error while parsing `c` nonTerm")
    }

    return result
  }

  fun `d`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`d`)

    when (lexer.currentToken) {
      is GState.Term.`MANY` -> {
        val `MANY0` = lexer.currentToken as GState.Term.`MANY`
        result.addChild(STNode(`MANY0`, `MANY0`.text))

        lexer.nextToken()
      }
      is GState.Term.`LCB` -> {
        val `LCB0` = lexer.currentToken as GState.Term.`LCB`
        result.addChild(STNode(`LCB0`, `LCB0`.text))

        lexer.nextToken()
        val `n0` = `n`()
        result.addChild(`n0`)

        val `RCB0` = lexer.currentToken as GState.Term.`RCB`
        result.addChild(STNode(`RCB0`, `RCB0`.text))

        lexer.nextToken()
      }
      is GState.Term.`LB`,
      is GState.Term.`CHAR`,
      is GState.Term.`OR`,
      is GState.Term.`end`,
      is GState.Term.`RB` -> {
        result.addChild(STNode(GState.Term.eps()))
      }
      else -> throw AssertionError("error while parsing `d` nonTerm")
    }

    return result
  }

  fun `n`(): `STNode` {
    val result = `STNode`(GState.NonTerm.`n`)

    when (lexer.currentToken) {
      is GState.Term.`NUMBER` -> {
        val `NUMBER0` = lexer.currentToken as GState.Term.`NUMBER`
        result.addChild(STNode(`NUMBER0`, `NUMBER0`.text))

        lexer.nextToken()
      }
      is GState.Term.`RCB` -> {
        result.addChild(STNode(GState.Term.eps()))
      }
      else -> throw AssertionError("error while parsing `n` nonTerm")
    }

    return result
  }

  fun parse(): `STNode` {
    val result = `a`()
    if (lexer.currentToken != GState.Term.end()) {
      throw AssertionError("expected end after parse")
    }

    return result
  }
}
