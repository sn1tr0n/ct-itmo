sealed interface Result<out S, out E> {
    class Ok<out S>(val value: S): Result<S, Nothing>
    class Error<out E>(val error: E): Result<Nothing, E>
}

