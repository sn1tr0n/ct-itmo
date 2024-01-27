package lab4.regex.generated

sealed interface GState {
  sealed interface Term : GState {
    data class `OR`(val text: String = "") : Term

    data class `LB`(val text: String = "") : Term

    data class `RB`(val text: String = "") : Term

    data class `CHAR`(val text: String = "") : Term

    data class `MANY`(val text: String = "") : Term

    data class `LCB`(val text: String = "") : Term

    data class `RCB`(val text: String = "") : Term

    data class `NUMBER`(val text: String = "") : Term

    data class `eps`(val text: String = "") : Term

    data class `end`(val text: String = "") : Term
  }

  sealed interface NonTerm : GState {
    data object `a` : NonTerm

    data object `a1` : NonTerm

    data object `b` : NonTerm

    data object `b1` : NonTerm

    data object `c` : NonTerm

    data object `d` : NonTerm

    data object `n` : NonTerm
  }
}
