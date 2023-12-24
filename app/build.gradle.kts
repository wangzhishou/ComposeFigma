plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.shifenmiao.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.shifenmiao.app"
        minSdk = 21
        targetSdk = 34
        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["ComposeCompilerVersion"] as String
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
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

    //Di
    implementation(libs.com.google.dagger.hilt.android)
    kapt(libs.com.google.dagger.hilt.compiler)

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


    implementation(project(":figma"))
}