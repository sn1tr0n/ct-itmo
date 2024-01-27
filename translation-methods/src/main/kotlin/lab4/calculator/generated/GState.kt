package lab4.calculator.generated

sealed interface GState {
  sealed interface Term : GState {
    data class `PLUS`(val text: String = "") : Term

    data class `MINUS`(val text: String = "") : Term

    data class `MUL`(val text: String = "") : Term

    data class `DIV`(val text: String = "") : Term

    data class `LB`(val text: String = "") : Term

    data class `RB`(val text: String = "") : Term

    data class `SLB`(val text: String = "") : Term

    data class `SRB`(val text: String = "") : Term

    data class `COMMA`(val text: String = "") : Term

    data class `NUMBER`(val text: String = "") : Term

    data class `eps`(val text: String = "") : Term

    data class `end`(val text: String = "") : Term
  }

  sealed interface NonTerm : GState {
    data object `e` : NonTerm

    data object `ePrime` : NonTerm

    data object `t` : NonTerm

    data object `tPrime` : NonTerm

    data object `f` : NonTerm
  }
}
