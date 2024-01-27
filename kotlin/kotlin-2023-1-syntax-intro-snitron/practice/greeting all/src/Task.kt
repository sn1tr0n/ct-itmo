fun greet(name: String) = "Hello, $name!"

fun main(args: Array<String>) = if (args.isEmpty()) {
    println(greet(readlnOrNull() ?: "Anonymous"))
} else {
    args.forEach { println(greet(it)) }
}
