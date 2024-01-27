class BankAccount(
    amount: Int,
) {

    var balance = when {
        amount <= 0 -> throw IllegalArgumentException("amount must be positive")
        else -> amount
    }
        private set(value) {
            logTransaction(field, value)
            field = value
        }

    fun deposit(delta: Int) {
        require(delta > 0) { "deposit amount must be positive" }

        balance += delta
    }

    fun withdraw(delta: Int) {
        require(delta in 1..balance) { "withdrawal amount must be in 1..balance" }

        balance -= delta
    }
}
