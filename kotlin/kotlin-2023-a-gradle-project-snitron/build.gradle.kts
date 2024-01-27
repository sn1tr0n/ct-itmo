plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.klint)
    alias(libs.plugins.detekt)
    application
}

repositories {
    mavenCentral()
}

group = "ru.snitron"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

ktlint {
    version.set(libs.versions.klint.version)
}

detekt {
    buildUponDefaultConfig = true
    config.setFrom(file("detekt-config.yml"))
}

dependencies {
    testImplementation(libs.bundles.testing)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}
