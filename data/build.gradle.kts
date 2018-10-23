
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
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
    implementation(Depends.Rx.kotlin)
    implementation(Depends.Rx.android)

    implementation(Depends.Koin.android)
    implementation(Depends.Retrofit.retrofit)
    implementation(Depends.Retrofit.adapter)
    implementation(Depends.Retrofit.gson)
    implementation(Depends.Retrofit.logginginterceptor)

    implementation(project(":domainRxJava"))

    testImplementation(Depends.Test.kluent)
    testImplementation(Depends.Test.mockito)
    testImplementation(Depends.Test.junit)
}
