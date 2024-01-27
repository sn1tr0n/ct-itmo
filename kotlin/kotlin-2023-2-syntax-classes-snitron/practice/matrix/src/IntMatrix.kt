import java.lang.IllegalArgumentException

class IntMatrix(
    val rows: Int,
    val columns: Int
) {
    private val matrix: IntArray

    init {
        if (rows <= 0 || columns <= 0) {
            throw IllegalArgumentException("rows and columns numbers must be natural")
        }

        matrix = IntArray(rows * columns)
    }

    private fun calculateIndex(i: Int, j: Int): Int {
        if (!(i in 0..<rows && j in 0..<columns)) {
            throw IllegalArgumentException("incorrect indexes")
        }

        return i * rows + j
    }

    operator fun get(i: Int, j: Int): Int = matrix[calculateIndex(i, j)]

    operator fun set(i: Int, j: Int, value: Int) {
        matrix[calculateIndex(i, j)] = value
    }
}
