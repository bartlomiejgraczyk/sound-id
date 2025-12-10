plugins {
    alias(libs.plugins.git.version)
    `maven-publish`
}

val gitVersion: groovy.lang.Closure<String> by extra
val projectVersion: String = gitVersion().removePrefix("v")

allprojects {
    group = "com.soundid"
    version = projectVersion
}
