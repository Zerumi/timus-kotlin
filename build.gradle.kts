plugins {
    kotlin("jvm") version "1.9.23"
}

group = "io.github.zerumi"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}