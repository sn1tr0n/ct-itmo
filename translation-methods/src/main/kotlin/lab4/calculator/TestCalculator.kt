package lab4.calculator

import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.model.Factory
import lab4.calculator.generated.Parser
import java.io.File

fun main() {
    val p = Parser("[5+5,3]")
    val e = p.parse()
    println(e)
    Graphviz.fromGraph(Factory.graph().with(e.drawGraph()))
        .scale(3.0)
        .render(Format.PNG)
        .toFile(File("/Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/kotlin/lab4/calculator/test_arithm.png"))

    e.res
}
