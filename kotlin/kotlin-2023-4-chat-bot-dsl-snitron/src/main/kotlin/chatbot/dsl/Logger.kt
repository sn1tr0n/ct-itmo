package chatbot.dsl

import chatbot.api.LogLevel
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class Logger(private val logLevel: LogLevel) {
    private fun log(
        prefix: String,
        message: String,
    ) {
        println("${DateTimeFormatter.ISO_DATE_TIME.format(ZonedDateTime.now())} $prefix:\t$message")
    }

    fun info(message: String) {
        if (logLevel == LogLevel.INFO) {
            log("INFO", message)
        }
    }

    fun error(message: String) {
        log("ERROR", message)
    }
}
