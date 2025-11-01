repositories {
    mavenCentral()
}

plugins {
    groovy
    alias(libs.plugins.integration.test)
}

dependencies {
    implementation(libs.spring.boot.starter.web)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
