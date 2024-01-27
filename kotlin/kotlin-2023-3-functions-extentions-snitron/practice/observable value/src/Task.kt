class CancellableSubscription<T> (
    val observer: (T) -> Unit,
    private val cancelSubscription: (CancellableSubscription<T>) -> Unit
) {
    fun cancel() = cancelSubscription(this)
}

interface Value<T> {
    var value: T

    fun observe(observer: (T) -> Unit): CancellableSubscription<T>
}
class MutableValue<T>(initial: T): Value<T> {
    override var value: T = initial
        set(value) {
            field = value
            subscriptions.forEach {
                it.observer(value)
            }
        }

    private val subscriptions = hashSetOf<CancellableSubscription<T>>()

    override fun observe(observer: (T) -> Unit): CancellableSubscription<T> {
        val subscription = CancellableSubscription(observer) {
            // из-за этого класс получается не Thread-safe, но такого требования не было
            // можно либо засинхронизировать, либо заюзать ConcurrencyUtilities
            subscriptions.remove(it)
        }

        subscriptions.add(subscription)
        observer(value)

        return subscription
    }
}
