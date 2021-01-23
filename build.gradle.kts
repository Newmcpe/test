plugins {
    kotlin("jvm") version "1.4.21"
}

group = "ru.newmcpe"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/exposed")
    maven("http://repo.dmulloy2.net/content/groups/public/")
}

dependencies {
    val exposedVersion: String by project
    val spigotVersion: String by project
    val postgresqlVersion: String by project

    implementation(kotlin("stdlib"))

    api("org.jetbrains.exposed", "exposed-java-time", exposedVersion)
    api("org.jetbrains.exposed", "exposed-core", exposedVersion)
    api("org.jetbrains.exposed", "exposed-dao", exposedVersion)
    api("org.jetbrains.exposed", "exposed-jdbc", exposedVersion)

    api("org.postgresql", "postgresql", postgresqlVersion)
    api("org.spigotmc","spigot", spigotVersion)

    api("com.comphenix.protocol", "ProtocolLib", "4.5.0")
}
