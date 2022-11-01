plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"
}

android {
    namespace = "com.example.kmmcoinapp.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.kmmcoinapp.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    with(ComposeDestination){

        implementation(composeDestination)
        ksp(composeDestinationPlugin)
    }
    with(Material3){
        implementation(material3)
        implementation(window)
    }
    with(Accompanist){
        implementation(coil)
        implementation(webview)
    }
    with(Compose){
        implementation(util){

        }
        implementation(composeActivity) {
            because("We are not using  xml its better to use compose activity ")
        }


        implementation(composeToolingDebug){
            because("Supports preview of composables")
        }

        debugImplementation(composeToolingDebug) {

            because("Supports previews and other tooling stuff." )
        }
        implementation(composeUI) {
            because("Supports compose ")
        }
    }

    implementation(Koin.koinAndroid)
}