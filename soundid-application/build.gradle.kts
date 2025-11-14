plugins {
    id("java-library")
    groovy
    alias(libs.plugins.integration.test)
    `java-test-fixtures`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":soundid-domain"))
    api(libs.jspecify)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testImplementation(libs.groovy)
    testImplementation(libs.spock.core)
    testImplementation(testFixtures(project(":soundid-domain")))
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
