package lab4

import lab4.antlr.GGLexer
import lab4.antlr.GGParser
import org.antlr.v4.kotlinruntime.CharStreams
import org.antlr.v4.kotlinruntime.CommonTokenStream
import java.nio.file.Path
import kotlin.io.path.readText


class GrammarProcessor(grammarPath: Path) {
    companion object {
        private const val EPS = "eps"
        private const val END = "end"
    }

    private fun collectSet(
        grammar: Map<String, State>,
        first: Map<String, Set<String>>,
        initial: Set<String>,
        invokes: List<Invoke>,
        additionalSet: Set<String>
    ): Set<String> {
        val set = initial.toMutableSet()

        for (index in invokes.indices) {
            when (invokes[index]) {
                is NonTermInvoke -> {
                    set += first[invokes[index].name]!!.filter { it != EPS }

                    if (EPS in first[invokes[index].name]!!) {
                        if (index != invokes.size - 1) {
                            continue
                        }

                        set += additionalSet
                    }
                }

                is TermInvoke -> {
                    println("${invokes[index].name} = ${grammar[invokes[index].name]!!.run { (this as Term).pattern }}")
                    set.add(invokes[index].name)
                }
            }

            break
        }

        return set
    }

    private fun first(statesByNames: Map<String, State>): Map<String, Set<String>> {
        var changed: Boolean
        val first = mutableMapOf<String, Set<String>>()
            .apply { statesByNames.filterValues { it is NonTerm }.keys.forEach { this[it] = setOf() } }

        do {
            changed = false

            statesByNames
                .filterValues { it is NonTerm }
                .map { entry ->
                    (entry.value as NonTerm).transitionByNames.map { t -> entry.key to t }
                }
                .flatten()
                .forEach { (name, transitions) ->
                    val set = first[name]!!.toMutableSet()
                    set += collectSet(statesByNames, first, set, transitions, setOf(EPS))

                    if (first[name]!!.size != set.size) {
                        first[name] = set
                        changed = true
                    }
                }
        } while (changed)

        return first
    }

    private fun follow(first: Map<String, Set<String>>, tokensByNames: Map<String, State>): Map<String, Set<String>> {
        var changed: Boolean
        val follow = mutableMapOf<String, Set<String>>()
            .apply {
                tokensByNames.filterValues { it is NonTerm }.keys
                    .forEachIndexed { index, name -> this[name] = if (name == start) setOf(END) else setOf() }
            }

        do {
            changed = false

            tokensByNames
                .filterValues { it is NonTerm }
                .map { entry ->
                    (entry.value as NonTerm).transitionByNames.map { t -> entry.key to t }
                }
                .flatten()
                .forEach { (name, transitions) ->
                    transitions.forEachIndexed { index, invoke ->
                        if (invoke !is NonTermInvoke) {
                            return@forEachIndexed
                        }

                        val set = follow[invoke.name]!!.toMutableSet()
                        set += if (index + 1 < transitions.size) {
                            collectSet(
                                tokensByNames,
                                first,
                                set,
                                transitions.subList(index + 1, transitions.size),
                                follow[name]!!
                            )
                        } else {
                            follow[name]!!
                        }

                        if (follow[invoke.name]!!.size != set.size) {
                            follow[invoke.name] = set
                            changed = true
                        }
                    }
                }
        } while (changed)

        return follow
    }

    val start: String
    val states: Map<String, State>
    val ws: String?
    private val first: Map<String, Set<String>>
    private val follow: Map<String, Set<String>>

    init {
        val lexer = GGLexer(
            CharStreams.fromString(
                grammarPath.readText().apply { println(this) }
            )
        )
        val parser = GGParser(CommonTokenStream(lexer))
        val g = parser.g()
        start = g.getInit().NOT_CAPS_WORD().text
        ws = g.getInit().LITERAL()?.run { text.substring(1..<text.length - 1) }

        states = g.states.groupBy { it.name }.flatMap {
            it.value.apply {
                if (size > 1) {
                    throw AssertionError("duplicated token!")
                }
            }
        }.associateBy { it.name }
            .toMutableMap()
            .apply {
                this[EPS] = Term(EPS).apply { pattern = "" }
                this[END] = Term(END).apply { pattern = "" }
            }

        first = first(states)
        follow = follow(first, states)

        println("first: $first")
        println("follow: $follow")
    }

    fun getFirst(transition: List<Invoke>): Set<String> {
        if (transition.isEmpty()) {
            return setOf(EPS)
        }

        if (transition[0] is TermInvoke) {
            return setOf(transition[0].name)
        }

        return first[transition[0].name]!!.let {
            if (EPS in it) {
                (it - EPS) + getFirst(transition.drop(1))
            } else {
                it
            }
        }
    }

    fun getFullFirst(name: String, transition: List<Invoke>): Set<String> = getFirst(transition)
        .let {
            println(name)
            if (EPS in it) {
                it + follow[name]!! - EPS
            } else {
                it
            }
        }
}