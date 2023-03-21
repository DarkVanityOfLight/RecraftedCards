plugins {
    kotlin("jvm") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    application
}

group = "com.github.recraftedcivilizations.recraftedcards"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/public/")
}

dependencies {
    shadow("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0")
    shadow("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    implementation("org.spigotmc:spigot-api:1.19-R0.1-SNAPSHOT")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.4")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}


application {
    mainClass.set("MainKt")
}
