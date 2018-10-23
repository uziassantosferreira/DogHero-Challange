

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

    object Libs {
        const val sectionRecyclerview = "io.github.luizgrp.sectionedrecyclerviewadapter:sectionedrecyclerviewadapter:${Versions.sectionedRecyclerview}"
        const val circleimageview = "de.hdodenhof:circleimageview:${Versions.circleimageview}"
    }

    object Navigation {
        const val fragment = "android.arch.navigation:navigation-fragment:${Versions.navigationVersion}"
        const val ui = "android.arch.navigation:navigation-ui:${Versions.navigationVersion}"
    }

    object Rx {
        const val kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    }

    object Test {
        const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
        const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
    }
}
