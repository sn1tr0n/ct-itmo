import java.io.BufferedReader
import java.nio.charset.Charset
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Config(
    config: String,
    charset: Charset = Charsets.UTF_8
): PropertyDelegateProvider<Any?, ReadOnlyProperty<Any?, String>> {
    private val properties: Map<String, String>

    init {
        val inputStream = getResource(config) ?: throw IllegalArgumentException("resource is not available")

        properties = inputStream.bufferedReader(charset).use {
            extractProperties(it)
        }
    }

    private fun extractProperties(bufferedReader: BufferedReader): Map<String, String> {
        val values = mutableMapOf<String, String>()

        bufferedReader.forEachLine { s ->
            val split = s.split('=')

            if (split.size == 2) {
                values[split[0].trim()] = split[1].trim()
            }
        }

        return values
    }

    override fun provideDelegate(thisRef: Any?, property: KProperty<*>): ReadOnlyProperty<Any?, String> {
        if (property.name !in properties) {
            throw IllegalArgumentException("${property.name} does not exists")
        }

        val value = properties[property.name]

        return ReadOnlyProperty { _, _ ->
            value ?: throw IllegalArgumentException("${property.name} does not exists")
        }
    }

}
