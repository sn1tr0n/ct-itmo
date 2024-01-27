import com.strumenta.antlrkotlin.gradle.AntlrKotlinTask

plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("com.strumenta.antlr-kotlin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("guru.nidi:graphviz-java:0.18.1")
    implementation("org.antlr:antlr4:4.13.1")
    implementation("com.strumenta:antlr-kotlin-runtime:0.1.0")
    implementation("com.facebook:ktfmt:0.46")
}

application {
    mainClass = "Main"
}
tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

val generateKotlinGrammarSource = tasks.register<AntlrKotlinTask>("generateKotlinGrammarSource") {
    dependsOn("cleanGenerateKotlinGrammarSource")

    // ANTLR .g4 files are under {example-project}/antlr
    // Only include *.g4 files. This allows tools (e.g., IDE plugins)
    // to generate temporary files inside the base path
    source = fileTree(layout.projectDirectory.dir("src/main/antlr")) {
        include("**/*.g4")
    }

    // We want the generated source files to have this package name
    val pkgName = "lab4.antlr"
    packageName = pkgName

    // We want visitors alongside listeners.
    // The Kotlin target language is implicit, as is the file encoding (UTF-8)
    arguments = listOf("-visitor")

    // Generated files are outputted inside build/generatedAntlr/{package-name}
    outputDirectory = layout.projectDirectory.dir("src/main/kotlin/lab4/antlr").asFile
}
