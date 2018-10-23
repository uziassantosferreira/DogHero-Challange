

object Depends {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }

    object Support {
        const val appcompat = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
        const val design = "com.android.support:design:${Versions.supportLibrary}"
        const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
        const val recyclerview = "com.android.support:recyclerview-v7:${Versions.supportLibrary}"
    }

    object Lifecycle {
        const val extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
        const val compiler = "android.arch.lifecycle:compiler:${Versions.lifecycle}"
    }
    object Libs {
        const val sectionRecyclerview = "io.github.luizgrp.sectionedrecyclerviewadapter:sectionedrecyclerviewadapter:${Versions.sectionedRecyclerview}"
        const val circleimageview = "de.hdodenhof:circleimageview:${Versions.circleimageview}"

        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glidecompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val gif = "pl.droidsonroids.gif:android-gif-drawable:${Versions.gif}"
    }

    object Koin {
        const val android = "org.koin:koin-android:${Versions.koin}"
        const val scope =  "org.koin:koin-android-scope:${Versions.koin}"
        const val viewmodel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val logginginterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging}"
    }

    object Navigation {
        const val fragment = "android.arch.navigation:navigation-fragment:${Versions.navigationVersion}"
        const val ui = "android.arch.navigation:navigation-ui:${Versions.navigationVersion}"
    }

    object Rx {
        const val kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
        const val android = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    }

    object Test {
        const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
        const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
        const val archCore = "android.arch.core:core-testing:${Versions.lifecycle}"
        const val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"
        const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
        const val junit = "junit:junit:${Versions.junit}"
        const val mockwebserver = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"
        const val koin = "org.koin:koin-test:${Versions.koin}"
    }
}
