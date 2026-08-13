pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.compose.gradle.plugin") {
                useModule("org.jetbrains.compose:org.jetbrains.compose.gradle.plugin:1.6.10")
            }
        }
    }
    plugins {
        id("com.android.application") version "8.4.0" apply false
        id("org.jetbrains.kotlin.multiplatform") version "2.0.0" apply false
        id("com.android.library") version "8.4.0" apply false
        id("org.jetbrains.compose.gradle.plugin") version "1.6.10" apply false
        id("com.android.kotlin.multiplatform") version "1.0.0" apply false
    }
}

rootProject.name = "sayf"
include("composeApp")