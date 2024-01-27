package lab4.calculator

import lab4.Generator
import lab4.GrammarProcessor
import kotlin.io.path.Path
import kotlin.io.path.createDirectory

fun main() {
    Generator(
        GrammarProcessor(Path("/Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/kotlin/lab4/calculator/calculator.grammar")),
        Path("/Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/kotlin/lab4/calculator/generated").apply {
            try { createDirectory() } catch (_: Exception) { }
        },
        "lab4.calculator.generated"
    )
}
