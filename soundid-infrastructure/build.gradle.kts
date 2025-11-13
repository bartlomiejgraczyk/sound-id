plugins {
    id("java")
    groovy
    alias(libs.plugins.integration.test)
}

group = "com.soundid"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":soundid-domain"))
    implementation(platform(libs.spring.boot.dependencies))
    implementation(libs.spring.context)
    implementation(libs.jspecify)
    testImplementation(libs.groovy)
    testImplementation(libs.spock.core)
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<GroovyCompile> {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}
