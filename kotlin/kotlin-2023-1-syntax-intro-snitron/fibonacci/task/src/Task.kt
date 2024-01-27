import java.lang.IllegalArgumentException

fun assertNatural(n: Int) {
    if (n < 0) {
        throw IllegalArgumentException("the index must be a natural number (i.e. >= 0), got n=$n")
    }
}

fun fibonacciFor(n: Int): Int {
    assertNatural(n)

    var f1 = 0
    var f2 = 1
    for (i in 0 until n) {
        val tmp = f1 + f2
        f1 = f2
        f2 = tmp
    }

    return f1
}

fun fibonacciIf(n: Int): Int {
    assertNatural(n)

    return if (n <= 1) {
        n
    } else {
        fibonacciIf(n - 1) + fibonacciIf(n - 2)
    }
}

fun fibonacciWhen(n: Int): Int {
    assertNatural(n)

    return when (n) {
        0, 1 -> n
        else -> fibonacciWhen(n - 1) + fibonacciWhen(n - 2)
    }
}
