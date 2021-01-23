plugins {
    kotlin("jvm") version "1.4.21"
}

group = "ru.newmcpe"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/exposed")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    val exposedVersion: String by project
    val paperVersion: String by project
    val postgresqlVersion: String by project

    implementation(kotlin("stdlib"))

    api("org.jetbrains.exposed", "exposed-java-time", exposedVersion)
    api("org.jetbrains.exposed", "exposed-core", exposedVersion)
    api("org.jetbrains.exposed", "exposed-dao", exposedVersion)
    api("org.jetbrains.exposed", "exposed-jdbc", exposedVersion)

    api("org.postgresql", "postgresql", postgresqlVersion)
    api("com.destroystokyo.paper","paper-api", paperVersion)
}
