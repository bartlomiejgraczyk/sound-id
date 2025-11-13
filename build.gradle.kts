repositories {
    mavenCentral()
}

plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(platform(libs.spring.boot.dependencies))
    implementation(libs.spring.boot)
    implementation(libs.spring.boot.autoconfigure)
}

application {
    mainClass.set("com.soundid.SoundIdApplicationKt")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
