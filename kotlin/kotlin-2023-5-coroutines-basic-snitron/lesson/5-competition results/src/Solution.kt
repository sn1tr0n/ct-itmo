import kotlin.time.Duration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.runningFold

fun Flow<Cutoff>.resultsFlow(): Flow<Results> =
    runningFold(mutableMapOf<String, Duration>()) { lastResults, cutoff ->
        lastResults.apply {
            this[cutoff.number] = cutoff.time
        }
    }.drop(1).map { Results(it) }
