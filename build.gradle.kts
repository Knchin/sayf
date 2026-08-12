plugins {
    id("org.jetbrains.kotlin.multiplatform") version "2.0.0" apply false
    id("org.jetbrains.compose.multiplatform") version "1.6.10" apply false
    id("com.android.application") version "8.4.0" apply false
    id("com.android.library") version "8.4.0" apply false
}

allprojects {
    group = "com.example.sayf"
    version = "1.0.0"
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}