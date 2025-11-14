plugins {
    application
    id("org.springframework.boot") version libs.versions.spring.boot
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.soundid.SoundIdApplication")
}

dependencies {
    implementation(project(":soundid-application"))
    implementation(project(":soundid-infrastructure"))
    implementation(platform(libs.spring.boot.dependencies))
    implementation(libs.spring.boot)
    implementation(libs.spring.boot.autoconfigure)
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