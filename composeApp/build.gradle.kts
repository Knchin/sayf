plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    androidTarget {
        withJava()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    wasmJs {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }

    listOf(
        androidTarget,
        iosX64,
        iosArm64,
        iosSimulatorArm64,
        wasmJs
    ).forEach {
        it.compilerOptions.freeCompilerArgs.add("-Xskip-metadata-version-check")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material3)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material3.adaptive)
                implementation(compose.components.resources)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(compose.ui.test.junit4)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(compose.ui.platform.android)
                implementation(compose.material3)
                implementation(activity.compose)
                implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.0")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(compose.ui.platform.ios)
                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }
        val wasmJsMain by getting {
            dependencies {
                implementation(compose.ui.platform.web)
                implementation(compose.material3)
                implementation(compose.foundation)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.8.1")
            }
        }
    }
}

android {
    namespace = "com.example.sayf"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.sayf"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.10"
    }
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    wasmJs {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

compose.desktop {
    // Desktop target not needed for this project
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}