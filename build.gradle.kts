plugins {
    id("java-library")
}

group = "ru.vens"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    sourceSets {
        main {
            java {
                setSrcDirs(listOf("src/main/java"))
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("com.codeborne:selenide:7.2.1")
    testImplementation("org.seleniumhq.selenium:selenium-devtools-v85:4.18.1")
    implementation("ch.qos.logback:logback-classic:1.4.14")
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