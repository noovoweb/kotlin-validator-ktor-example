plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.serialization") version "2.1.0"
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    application
}

group = "com.noovoweb"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Ktor with kotlin-validator"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // Ktor server
    implementation("io.ktor:ktor-server-core:2.3.12")
    implementation("io.ktor:ktor-server-netty:2.3.12")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.12")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // Logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.3")
    implementation("ch.qos.logback:logback-classic:1.5.15")

    // Validator
    implementation("com.noovoweb:kotlin-validator-annotations:0.1.1")
    implementation("com.noovoweb:kotlin-validator-runtime:0.1.1")
    implementation("com.noovoweb:kotlin-validator-ktor:0.1.1")
    ksp("com.noovoweb:kotlin-validator-ksp:0.1.1")

    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("io.ktor:ktor-server-test-host:2.3.12")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("com.noovoweb.project.ApplicationKt")
}
