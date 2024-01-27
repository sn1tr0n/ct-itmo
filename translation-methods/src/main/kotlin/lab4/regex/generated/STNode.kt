package lab4.regex.generated

import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.attribute.Label
import guru.nidi.graphviz.model.Factory
import guru.nidi.graphviz.model.MutableNode
import java.util.concurrent.atomic.AtomicInteger

val counter = AtomicInteger()

open class STNode(
    val term: GState,
    var text: String = "",
    private val children: MutableList<STNode> = mutableListOf()
) {
  fun addChild(child: STNode) = children.add(child)

  fun drawGraph(): MutableNode {
    val node = Factory.mutNode(counter.incrementAndGet().toString())

    node.add(Label.of(term.toString()))

    if (children.isNotEmpty()) {
      for (c in children) {
        node.addLink(c.drawGraph())
      }
    } else {
      node.add(Color.GREEN1)
    }

    return node
  }

  private fun print(sb: StringBuilder = StringBuilder()): StringBuilder {
    if (children.isEmpty()) {
      sb.append(if (term == GState.Term.eps()) "" else text)
    } else {
      for (c in children) {
        c.print(sb)
      }
    }

    return sb
  }

  override fun toString() = print().toString()
}
