// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.com.android.tools.build.gradle)
        classpath(libs.org.jetbrains.kotlin.kotlin.gradle.plugin)
        classpath(libs.com.google.dagger.hilt.android.gradle.plugin)
        classpath(libs.com.google.gms.google.services)
        classpath(libs.com.google.firebase.firebase.crashlytics.gradle)
    }
}

plugins {
    id("com.github.ben-manes.versions") version ("0.41.0")
    id("nl.littlerobots.version-catalog-update") version "0.8.1"
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    /**
     * @see https://developer.android.com/studio/build/migrate-to-ksp?hl=zh-cn#kts
     */
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}

extra["versionCode"] = 1
extra["versionName"] = "1.0"
extra["FLAVOR"] = "default"
extra["ComposeCompilerVersion"] = "1.5.4"