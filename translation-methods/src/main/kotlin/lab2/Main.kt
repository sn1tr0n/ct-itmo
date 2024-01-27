package lab2

import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.model.Factory.graph
import java.io.File

fun main() {
    val result = Parser("(abc{123123123})c*".byteInputStream()).parse()
    print(result)
    Graphviz.fromGraph(graph().with(result.drawGraph()))
        .scale(3.0)
        .render(Format.PNG)
        .toFile(File("test.png"))
}