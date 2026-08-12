pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.4.0" apply false
        id("org.jetbrains.kotlin.multiplatform") version "2.0.0" apply false
        id("com.android.library") version "8.4.0" apply false
        id("org.jetbrains.compose.multiplatform") version "1.6.10" apply false
        id("com.android.kotlin.multiplatform") version "1.0.0" apply false
    }
}

rootProject.name = "sayf"