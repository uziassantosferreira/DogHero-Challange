package com.doghero.application

import android.app.Application
import com.doghero.data.di.networkModule
import com.doghero.di.applicationModule
import com.doghero.di.heroesModule
import org.koin.android.ext.android.startKoin

class DogHeroApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(applicationModule, heroesModule, networkModule))
    }
}