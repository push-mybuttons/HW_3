plugins {
    id("java-library")
}

group = "ru.vens"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.0")
    testImplementation("com.codeborne:selenide:6.19.1")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
    reports {
        html.required.set(true)
        junitXml.required.set(true)
    }
    classpath += sourceSets.test.get().output + sourceSets.test.get().resources
}

tasks.processTestResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}