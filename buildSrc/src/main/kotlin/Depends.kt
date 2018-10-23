object Depends {
    object Kotlin {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }

    object Support {
        val appcompat = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
    }

    object Rx {
        val kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    }
}
