import java.time.*
import java.time.format.*
import java.time.temporal.*

private const val ONE_MILLION = 1_000_000

fun main() {
    val time = LocalDateTime.now()
    val bankAccount = BankAccount(time[ChronoField.CLOCK_HOUR_OF_DAY])

    println(
        """
            
        ========================    
        === Hello, stranger! ===
        
        Now is ${DateTimeFormatter.ISO_DATE_TIME.format(time)}, 
        and you have ${bankAccount.balance} $ on your account.
        ========================
        
        """.trimIndent(),
    )
    println("==== Let's try your luck! Calculating... ====")

    if (time[ChronoField.NANO_OF_SECOND] % 2 == 0) {
        bankAccount.deposit(ONE_MILLION)
        println("==== Congratulations! You've won 1 million $!!! ====")
    } else {
        bankAccount.withdraw(bankAccount.balance)
        println("==== Very sad, sector 'bankrupt' is on the wheel =( ====")
    }
}
