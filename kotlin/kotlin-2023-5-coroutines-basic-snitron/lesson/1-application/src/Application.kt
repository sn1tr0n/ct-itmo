import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun CoroutineScope.runApplication(
    runUI: suspend () -> Unit,
    runApi: suspend () -> Unit,
) {
    suspend fun runApiJob() {
        try {
            runApi()
        } catch (ce: CancellationException) {
            return
        } catch (_: Exception) {
            delay(1.seconds)
            launch {
                runApiJob()
            }
        }
    }

    val apiJob = launch { runApiJob() }

    launch {
        try {
            runUI()
        } catch (e: Exception) {
            apiJob.cancel()
            throw e
        }
    }
}
