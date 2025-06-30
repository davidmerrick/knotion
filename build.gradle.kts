group = "io.github.davidmerrick.knotion"

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.9.23"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.23")

    // Ktor HTTP client core + CIO engine
    implementation("io.ktor:ktor-client-core:2.3.5")
    implementation("io.ktor:ktor-client-cio:2.3.5")

    // Jackson for JSON serialization
    implementation("io.ktor:ktor-serialization-jackson:2.3.5")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.5")

    // Logging plugin (optional but useful)
    implementation("io.ktor:ktor-client-logging:2.3.5")

    // Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")

    // Logging
    implementation("io.github.microutils:kotlin-logging:3.0.4")
    implementation("org.slf4j:slf4j-api:2.0.3")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("com.natpryce:hamkrest:1.8.0.1")
    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("ch.qos.logback:logback-core:1.4.4")
    implementation("com.googlecode.libphonenumber:libphonenumber:8.13.33")

    testImplementation("org.testng:testng:7.7.1")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = "io.github.davidmerrick"
            artifactId = "knotion"
            version = project.version.toString()
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/davidmerrick/knotion")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}


tasks.withType<Test> {
    useTestNG()
}
