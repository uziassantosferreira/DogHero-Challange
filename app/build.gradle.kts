import org.jetbrains.kotlin.cli.jvm.main
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = "com.doghero"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }
}

dependencies {
    implementation(Depends.Kotlin.stdlib)
    implementation(Depends.Support.appcompat)
    implementation(Depends.Support.design)
    implementation(Depends.Support.constraintLayout)

    implementation(Depends.Navigation.fragment)
    implementation(Depends.Navigation.ui)

    implementation(project(":domainRxJava"))
}
