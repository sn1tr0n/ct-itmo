package lab4

import com.facebook.ktfmt.format.Formatter
import org.intellij.lang.annotations.Language
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.writeText

class Generator(
    private val grammarProcessor: GrammarProcessor,
    private val outputDir: Path,
    private val packagge: String
) {
    companion object {
        fun writeToFile(@Language(value = "kotlin") source: String, file: Path) {
            file.writeText(Formatter.format(source))
        }
    }

    init {
        writeStates()
        writeSTNode()
        writeLexer()
        writeParser()
    }

    private fun writeStates() = writeToFile(
        """
package $packagge

sealed interface GState {
    sealed interface Term: GState {
        ${
            grammarProcessor.states.filterValues { it is Term }.keys.joinToString("\n") {
                """data class `$it`(val text: String = ""): Term"""
            }
        }
    }
    
    sealed interface NonTerm: GState {
        ${
            grammarProcessor.states.filterValues { it is NonTerm }.keys.joinToString("\n") {
                "data object `$it`: NonTerm"
            }
        }
    }
}
    """.trimIndent(), outputDir.resolve("GState.kt")
    )

    private fun writeSTNode() = writeToFile(
        """
package $packagge

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
${
            grammarProcessor.states.values.filter { it is NonTerm && it.outputs.isNotEmpty() }
                .joinToString("\n\n") {
                    val token = it as NonTerm
                    """
class `STNode${it.name}`(term: GState, text: String = "", ${token.outputs.joinToString { "var $it" }}): STNode(term, text)
            """.trimIndent()
                }
        }
    """.trimIndent(), outputDir.resolve("STNode.kt")
    )

    fun parseNonTerm(nonTerm: NonTerm): String {
        val stNode = "`STNode${if (nonTerm.outputs.isEmpty()) "" else nonTerm.name}`"
        return """
fun `${nonTerm.name}`(${nonTerm.inputs.joinToString()}): $stNode {
    val result = $stNode(GState.NonTerm.`${nonTerm.name}`)
    
    when (lexer.currentToken) {
        ${
            nonTerm.transitionByNames.joinToString("\n\n") { transition ->
                """${
                    grammarProcessor.apply { println(nonTerm) }.getFullFirst(nonTerm.name, transition)
                        .joinToString { "is GState.Term.`$it`" }
                } -> {
                ${
                  run {
                      val counters = mutableMapOf<String, Int>()

                      transition.joinToString("\n") { invoke ->

                          val proceedBlock = StringBuilder()
                          val id = counters[invoke.name].run {
                              if (this == null) {
                                  counters[invoke.name] = 1
                                  return@run 0
                              } else {
                                  counters[invoke.name] = this + 1
                                  return@run this
                              }
                          }

                          when (invoke) {

                              is TermInvoke -> {

                                  if (invoke.name == "eps") {
                                      proceedBlock.append(
                                          """
                                    result.addChild(STNode(GState.Term.eps()))
                                    ${invoke.update ?: ""}
                                """.trimIndent()
                                      )
                                  } else {
                                      proceedBlock.append(
                                          """
                                val `${invoke.name}$id` = lexer.currentToken as GState.Term.`${invoke.name}`
                                result.addChild(STNode(`${invoke.name}$id`, `${invoke.name}${id}`.text))
                                ${invoke.update ?: ""}
                                lexer.nextToken()
                            """.trimIndent()
                                      )
                                  }
                              }

                              is NonTermInvoke -> {
                                  proceedBlock.append(
                                      """
                                val `${invoke.name}$id` = `${invoke.name}`(${invoke.inputs.joinToString()})
                                result.addChild(`${invoke.name}$id`)
                                ${invoke.update ?: ""}
                            """.trimIndent()
                                  )
                              }
                          }

                          proceedBlock.toString()
                      }
                  }
                }
            }
            
"""
            }
        }
            
else -> throw AssertionError("error while parsing `${nonTerm.name}` nonTerm")
    }
    
    return result
}
        """.trimIndent()
    }

    private fun writeParser() {
        val resultSTNode = (grammarProcessor.states[grammarProcessor.start] as NonTerm).run {
            "`STNode${if (outputs.isEmpty()) "" else name}`"
        }

        writeToFile("""
package $packagge

import lab4.*

import java.io.InputStream
import java.lang.AssertionError
import java.text.ParseException

import kotlin.math.*


class Parser(
   source: String
) {
    private val lexer = LexicalAnalyzer(source ${grammarProcessor.ws?.let { ", ws = Regex(\"$it\")" } ?: ""})
    
    ${
            grammarProcessor.states.values
                .asSequence()
                .filter { it is NonTerm }
                .map { parseNonTerm(it as NonTerm) }
                .joinToString("\n\n")
        }

    fun parse(): $resultSTNode {
        val result = `${grammarProcessor.start}`()
        if (lexer.currentToken != GState.Term.end()) {
            throw AssertionError("expected end after parse")
        }
        
        return result
    }
}
          
        """.trimIndent(), outputDir.resolve("Parser.kt"))
    }

    fun writeLexer() {
        writeToFile("""
package $packagge

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
        ${
            grammarProcessor.states.values.asSequence()
                .filter { it is Term }
                .joinToString("\n") {
                    val token = it as Term
                    """
                Regex("${token.pattern}").matchAt(source, currentPosition)?.apply {
                currentPosition = this.range.last + 1

                return@run GState.Term.`${token.name}`(value)
            }
            """.trimIndent()
                }
        }
            
            throw ParseException(
                "Unexpected char=${'$'}{source[currentPosition]} at pos=${'$'}{currentPosition}",
                currentPosition
            )
        }
    }
}

        """.trimIndent(), outputDir.resolve("Lexer.kt")
        )
    }

}

fun main() {
    Generator(
        GrammarProcessor(Path(".")),
        Path("/Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/kotlin/lab4/generated"),
        "lab4.generated"
    )
}