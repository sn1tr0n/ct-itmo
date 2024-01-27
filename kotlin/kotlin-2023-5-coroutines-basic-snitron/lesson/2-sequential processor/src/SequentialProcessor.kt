import kotlinx.coroutines.*

class SequentialProcessor(private val handler: (String) -> String) : TaskProcessor {
    private val processorScope = CoroutineScope(newSingleThreadContext("sequential-processor"))

    override suspend fun process(argument: String): String =
        processorScope.async {
            handler(argument)
        }.await()
}
