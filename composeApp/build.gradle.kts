plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    id("org.jetbrains.compose.gradle.plugin") version "1.6.10" apply false
}

@OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    wasmJs {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.compose.material3)
                implementation(libs.compose.runtime)
                implementation(libs.compose.ui)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3.adaptive)
                implementation(libs.compose.components.resources)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.compose.ui.test.junit4)
                implementation(libs.kotlinx.coroutines.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.compose.ui.platform.android)
                implementation(libs.compose.material3)
                implementation(libs.activity.compose)
                implementation(libs.lifecycle.runtime.compose)
            }
        }
        val iosX64Main by getting {
            dependencies {
                implementation(libs.compose.ui.platform.ios)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
            }
        }
        val iosArm64Main by getting {
            dependsOn(iosX64Main)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosX64Main)
        }
        val wasmJsMain by getting {
            dependencies {
                implementation(libs.compose.ui.platform.web)
                implementation(libs.compose.material3)
                implementation(libs.compose.foundation)
                implementation(libs.kotlinx.coroutines.core.js)
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.10"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}