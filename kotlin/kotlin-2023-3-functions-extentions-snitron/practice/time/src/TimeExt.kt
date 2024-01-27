const val SECONDS_IN_MINUTE = 60L
const val SECONDS_IN_HOUR = SECONDS_IN_MINUTE * 60L

fun fromMilliseconds(milliseconds: Long): Time = Time(
    seconds = milliseconds / 1000L,
    milliseconds = (milliseconds % 1000L).toInt()
)

val Int.milliseconds: Time
    get() = fromMilliseconds(this.toLong())
val Long.milliseconds: Time
    get() = fromMilliseconds(this)

val Int.seconds: Time
    get() = Time(this.toLong(), 0)
val Long.seconds: Time
    get() = Time(this, 0)

val Int.minutes: Time
    get() = Time(this * SECONDS_IN_MINUTE, 0)
val Long.minutes: Time
    get() = Time(this * SECONDS_IN_MINUTE, 0)

val Int.hours: Time
    get() = Time(this * SECONDS_IN_HOUR, 0)
val Long.hours: Time
    get() = Time(this * SECONDS_IN_HOUR, 0)

fun Time.inMilliseconds(): Long = seconds * 1000L + milliseconds


operator fun Time.plus(other: Time): Time
    = fromMilliseconds(inMilliseconds() + other.inMilliseconds())

operator fun Time.minus(other: Time): Time
    = fromMilliseconds(inMilliseconds() - other.inMilliseconds())

operator fun Time.times(int: Int): Time
    = fromMilliseconds(inMilliseconds() * int)
