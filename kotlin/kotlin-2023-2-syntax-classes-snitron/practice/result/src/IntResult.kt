import java.lang.Exception
import java.util.NoSuchElementException

class NoResultProvided(message: String): NoSuchElementException(message)

sealed interface IntResult {
    data class Ok(val value: Int): IntResult

    data class Error(val reason: String): IntResult

    private inline fun getOr(defaultProvider: (String) -> Int?): Int? = when (this) {
        is Ok -> value
        is Error -> defaultProvider(reason)
    }

    fun getOrDefault(defaultValue: Int): Int = getOr { defaultValue }!!

    fun getOrNull(): Int? = getOr { null }

    fun getStrict(): Int = getOr { throw NoResultProvided(it) }!!
}

fun safeRun(action: () -> Int): IntResult {
    return try {
        IntResult.Ok(action())
    } catch (e: Exception) {
        IntResult.Error(e.message ?: "no reason provided")
    }
}
