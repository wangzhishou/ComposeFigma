plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.relay") version ("0.3.02")
}

android {
    namespace = "com.shifenmiao.figma"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose =  true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["ComposeCompilerVersion"] as String
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)


    //AndroidX
    implementation(libs.androidx.activity.activity.compose)
    implementation(libs.androidx.core.core.splashscreen)
    implementation(libs.androidx.exifinterface)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.documentfile)
    implementation(libs.androidx.datastore.datastore.preferences.android)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.compose)

    //Navigation
    implementation(libs.dev.olshevski.navigation.reimagined)
    implementation(libs.dev.olshevski.navigation.reimagined.hilt)

    //Konfetti
    implementation(libs.nl.dionsegijn.konfetti.compose)

    //Compose
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.material3.window.size.clazz)
    implementation(libs.androidx.compose.material.material.icons.extended)
    implementation(libs.androidx.compose.material)

    //Coil
    implementation(libs.io.coil.kt.coil)
    implementation(libs.io.coil.kt.coil.compose)
    implementation(libs.io.coil.kt.coil.gif)
    implementation(libs.io.coil.kt.coil.svg)

    //MMKV
    implementation(libs.com.tencent.mmkv)

    //preview
    implementation(libs.androidx.compose.ui.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.ui.tooling.preview.android)
    debugImplementation(libs.androidx.ui.tooling)
}