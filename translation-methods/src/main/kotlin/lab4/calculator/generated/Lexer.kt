package lab4.calculator.generated

import java.text.ParseException

class LexicalAnalyzer(s: String, ws: Regex = Regex("\\s+")) {
  private var currentPosition = 0

  var currentToken: GState = GState.Term.`eps`()
    private set

  private val source: String

  init {
    source = s.replace(ws, "")
    nextToken()
  }

  fun nextToken() {
    if (currentPosition >= source.length) {
      currentToken = GState.Term.`end`()
      return
    }

    currentToken = run {
      Regex("\\+").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`PLUS`(value)
      }
      Regex("-").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`MINUS`(value)
      }
      Regex("\\*").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`MUL`(value)
      }
      Regex("/").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`DIV`(value)
      }
      Regex("\\(").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`LB`(value)
      }
      Regex("\\)").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`RB`(value)
      }
      Regex("\\[").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`SLB`(value)
      }
      Regex("\\]").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`SRB`(value)
      }
      Regex(",").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`COMMA`(value)
      }
      Regex("[0-9]+").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`NUMBER`(value)
      }
      Regex("").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`eps`(value)
      }
      Regex("").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`end`(value)
      }

      throw ParseException(
          "Unexpected char=${source[currentPosition]} at pos=${currentPosition}", currentPosition)
    }
  }
}
