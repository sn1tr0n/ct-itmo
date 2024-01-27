import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.*

class ParallelEvaluator {
    suspend fun run(
        task: Task,
        n: Int,
        context: CoroutineContext,
    ) {
        val scope = CoroutineScope(context)

        val asyncJobs =
            (0..<n).map { i ->
                scope.async {
                    task.run(i)
                }
            }

        try {
            asyncJobs.forEach { it.await() }
        } catch (e: Exception) {
            throw TaskEvaluationException(e)
        }
    }
}
