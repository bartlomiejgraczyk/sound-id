plugins {
    id("java")
    groovy
    alias(libs.plugins.integration.test)
    `java-test-fixtures`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.jspecify)
    testImplementation(libs.groovy)
    testImplementation(libs.spock.core)
    testFixturesImplementation(libs.groovy)
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
