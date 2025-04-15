plugins {
    id("java-library")
}

group = "ru.vens"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.0")
    testImplementation("com.codeborne:selenide:6.19.1")
}

tasks.test {
    useJUnitPlatform()
}