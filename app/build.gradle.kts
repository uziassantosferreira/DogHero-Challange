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
    implementation(Depends.Support.recyclerview)
    implementation(Depends.Libs.sectionRecyclerview)
    implementation(Depends.Libs.circleimageview)
    implementation(Depends.Libs.glide)
    kapt(Depends.Libs.glidecompiler)
    implementation(Depends.Libs.gif)
    implementation(Depends.Navigation.fragment)
    implementation(Depends.Navigation.ui)
    implementation(Depends.Rx.kotlin)
    implementation(Depends.Rx.android)
    implementation(Depends.Koin.android)
    implementation(Depends.Koin.scope)
    implementation(Depends.Koin.viewmodel)
    implementation(Depends.Lifecycle.extensions)
    kapt(Depends.Lifecycle.compiler)

    implementation(project(":domainRxJava"))
    implementation(project(":data"))

    testImplementation(Depends.Test.kluent)
    testImplementation(Depends.Test.mockito)
    testImplementation(Depends.Test.archCore)
}
