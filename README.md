# Sayf - Kotlin Multiplatform App

A Kotlin Multiplatform application targeting iOS, Android, and Progressive Web App (WasmJS) with a shared Compose Multiplatform UI.

## Features

- **iOS** - Native iOS app using Compose Multiplatform for iOS
- **Android** - Native Android app using Jetpack Compose
- **Web (PWA)** - Progressive Web App using Kotlin/Wasm and Compose for Web
- **Shared UI** - Single codebase for all platforms using Compose Multiplatform
- **Background Image** - Uses `img/1.jpg` as background across all platforms

## Project Structure

```
sayf/
├── composeApp/                 # Shared Compose Multiplatform module
│   ├── src/
│   │   ├── commonMain/         # Shared code for all platforms
│   │   │   ├── kotlin/         # Shared Kotlin code
│   │   │   ├── composeResources/ # Shared resources (images, fonts)
│   │   │   └── resources/      # Shared resources
│   │   ├── androidMain/        # Android-specific code
│   │   ├── iosMain/            # iOS-specific code
│   │   └── wasmJsMain/         # Web/Wasm-specific code
│   └── build.gradle.kts        # Compose App build configuration
├── .github/workflows/          # GitHub Actions CI/CD
│   ├── build-webapp.yml        # Build Web App
│   ├── build-ios.yml           # Build iOS
│   ├── build-android.yml       # Build Android
│   └── deploy-cloudflare.yml   # Deploy to Cloudflare Pages
├── gradle/                     # Gradle wrapper and version catalog
├── gradlew / gradlew.bat       # Gradle wrapper scripts
├── settings.gradle.kts         # Project settings
├── build.gradle.kts            # Root build configuration
└── gradle.properties           # Gradle properties
```

## Getting Started

### Prerequisites

- JDK 17+
- Android Studio / Xcode (for mobile development)
- Node.js 20+ (for web development)
- Gradle 8.8+ (included via wrapper)

### Building Locally

```bash
# Build all targets
./gradlew build

# Build Android APK
./gradlew :composeApp:assembleDebug

# Build iOS Framework
./gradlew :composeApp:linkDebugFrameworkIosSimulatorArm64

# Build Web App (WasmJS)
./gradlew :composeApp:wasmJsBrowserProductionWebpack
```

### Running the Web App

```bash
# Development mode
./gradlew :composeApp:wasmJsBrowserDevelopmentRun

# Production build
./gradlew :composeApp:wasmJsBrowserProductionWebpack
# Output in: composeApp/build/dist/wasmJs/productionExecutable/
```

## GitHub Actions CI/CD

The project includes automated workflows:

1. **Build Web App** - Builds the WasmJS production bundle
2. **Build iOS** - Builds iOS framework and XCFramework on macOS
3. **Build Android** - Builds debug and release APKs
4. **Deploy to Cloudflare Pages** - Deploys web build to Cloudflare Pages

### Required Secrets for Cloudflare Deployment

Add these secrets to your GitHub repository:

- `CLOUDFLARE_API_TOKEN` - Cloudflare API token with Pages permissions
- `CLOUDFLARE_ACCOUNT_ID` - Your Cloudflare account ID

## Cloudflare Pages Deployment

The web app is automatically deployed to Cloudflare Pages on push to main/master branch.

1. Create a Cloudflare Pages project named `sayf`
2. Connect your GitHub repository
3. Set build command: `./gradlew :composeApp:wasmJsBrowserProductionWebpack`
4. Set output directory: `composeApp/build/dist/wasmJs/productionExecutable`
5. Add the required secrets to GitHub repository settings

## License

MIT License