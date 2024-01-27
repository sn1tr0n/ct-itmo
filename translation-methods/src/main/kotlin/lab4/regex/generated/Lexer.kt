package lab4.regex.generated

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
      Regex("\\|").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`OR`(value)
      }
      Regex("\\(").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`LB`(value)
      }
      Regex("\\)").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`RB`(value)
      }
      Regex("[a-zA-Z]+").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`CHAR`(value)
      }
      Regex("\\*").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`MANY`(value)
      }
      Regex("\\{").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`LCB`(value)
      }
      Regex("\\}").matchAt(source, currentPosition)?.apply {
        currentPosition = this.range.last + 1

        return@run GState.Term.`RCB`(value)
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
