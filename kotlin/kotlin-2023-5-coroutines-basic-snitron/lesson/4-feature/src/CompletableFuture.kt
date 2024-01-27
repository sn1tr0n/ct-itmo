import kotlin.coroutines.resume
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine

/**
 * Interface for the result of asynchronous calculations
 */
interface CompletableFuture<T> {
    /**
     * @return true if calculations already done
     */
    val isDone: Boolean

    /**
     * @return true if calculations is cancelled
     */
    val isCancelled: Boolean

    /**
     * @return value of feature
     * @throws IllegalArgumentException if calculations isn't done
     */
    val value: T

    /**
     * cancel calculation if result of feature not needed
     */
    fun cancel()

    /**
     * adds a handler that will be called after the calculation is completed
     * or call handler immediately if calculation already done
     */
    fun handle(handler: ContinuationHandler<T>)
}

class ContinuationHandler<T>(
    @Volatile @JvmField
    var cont: CancellableContinuation<T>?,
) {
    fun invoke(result: T) {
        val cont = this.cont ?: return
        cont.resume(result)
    }

    fun cancel() {
        val localCont = cont
        cont = null
        localCont?.cancel()
    }
}

suspend fun <T> CompletableFuture<T>.await(): T =
    suspendCancellableCoroutine { continuation ->
        if (isDone) {
            continuation.resumeWith(Result.success(value))
            return@suspendCancellableCoroutine
        }

        continuation.invokeOnCancellation { cancel() }
        handle(ContinuationHandler(continuation))
    }
