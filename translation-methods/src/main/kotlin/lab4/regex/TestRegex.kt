package lab4.regex

import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.model.Factory
import lab4.regex.generated.Parser
import java.io.File

fun main() {
    val p = Parser("(a{1}|b{2}|c{3})*|a{1}")
    val a = p.parse()
    println(a)
    Graphviz.fromGraph(Factory.graph().with(a.drawGraph()))
        .scale(3.0)
        .render(Format.PNG)
        .toFile(File("/Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/kotlin/lab4/regex/test_regex.png"))
}