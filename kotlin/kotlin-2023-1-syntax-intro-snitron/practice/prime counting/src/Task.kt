import kotlin.math.sqrt

fun isPrime(n: Int): Boolean {
    if (n <= 1) {
        return false
    }

    for (i in 2 until sqrt(n.toDouble()).toInt() + 1) {
        if (n % i == 0) {
            return false
        }
    }

    return true
}

fun piFunction(x: Double): Int {
    var count = 0

    for (i in 2 until x.toInt() + 1) {
        count += if (isPrime(i)) 1 else 0
    }

    return count
}
