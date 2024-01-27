package lab2

import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.attribute.Label
import guru.nidi.graphviz.model.Factory.mutNode
import guru.nidi.graphviz.model.MutableNode
import java.util.concurrent.atomic.AtomicInteger
import kotlin.text.StringBuilder


sealed interface Token {
    sealed interface Term: Token {
        data object LBracket : Term {
            override fun toString(): String = "("
        }
        data object RBracket : Term {
            override fun toString(): String = ")"
        }

        data object LCurlBracket : Term {
            override fun toString(): String = "{"
        }

        data object RCurlBracket : Term {
            override fun toString(): String = "}"
        }

        @JvmInline
        value class Symbol(private val value: Char) : Term {
            override fun toString(): String = "$value"
        }

        @JvmInline
        value class Number(private val value: Int) : Term {
            override fun toString(): String = value.toString()
        }

        data object Or : Term {
            override fun toString(): String = "|"
        }
        data object Kleene : Term {
            override fun toString(): String = "*"
        }

        data object Epsilon : Term {
            override fun toString(): String = "ε"
        }
        data object End : Term {
            override fun toString(): String = "end"
        }
    }

    sealed interface NotTerm: Token {
        data object A: NotTerm
        data object A1: NotTerm

        data object B: NotTerm
        data object B1: NotTerm

        data object C: NotTerm

        data object D: NotTerm
        data object N: NotTerm
    }
}

private val counter = AtomicInteger()


data class SyntaxTreeNode(val term: Token, val children: List<SyntaxTreeNode>? = null) {
    fun drawGraph(): MutableNode {
        val node = mutNode(counter.incrementAndGet().toString())

        node.add(Label.of(term.toString()))

        if (children != null) {
            for (c in children) {
                node.addLink(c.drawGraph())
            }
        } else {
            node.add(Color.GREEN1)
        }

        return node
    }

    private fun print(sb: StringBuilder = StringBuilder()): StringBuilder {
        if (children == null) {
            sb.append(if (term == Token.Term.Epsilon) "" else term.toString())
        } else {
            for (c in children) {
                c.print(sb)
            }
        }

        return sb
    }

    override fun toString() = print().toString()
}
