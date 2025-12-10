rootProject.name = "sound-id"

include(
    "soundid-boot",
    "soundid-application",
    "soundid-infrastructure",
    "soundid-domain"
)

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
