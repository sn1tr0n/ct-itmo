package lab4

sealed class State(var name: String = "")

private fun unbrace(lBrace: String, rBrace: String, s: String) = if (s.startsWith(lBrace) && s.endsWith(rBrace)) {
    s.slice(lBrace.length..<s.length - rBrace.length)
} else {
    s
}

private fun unbrace(brace: String, s: String) = unbrace(brace, brace, s)

class Term(name: String = "") : State(name) {
    override fun toString(): String = "Term($name){$pattern}"
    var pattern: String = name
        get() = unbrace("$", field)
}

class NonTerm(
    name: String = "",
    val transitionByNames: MutableList<List<Invoke>> = mutableListOf()
) : State(name) {
    var inputs: List<String> = listOf()
        get() = field.map { unbrace("\'", it) }
    var outputs: List<String> = listOf()
        get() = field.map { unbrace("\'", it) }

    override fun toString(): String = "NonTerm($name){t=$transitionByNames, i=$inputs, o=$outputs}"
}

sealed class Invoke(var name: String = "") {
    var update: String? = null
        get() = field?.let { unbrace("<", ">", unbrace("<\'", "\'>", it)) }
}

class TermInvoke(name: String = "") : Invoke(name) {
    override fun toString(): String = "TI($name)"
}

class NonTermInvoke(name: String = "") : Invoke(name) {
    var inputs: List<String> = listOf()
        get() = field.map { unbrace("\'", it) }

    override fun toString(): String = "NTI($name){input=$inputs, update=\"$update\"}"
}
