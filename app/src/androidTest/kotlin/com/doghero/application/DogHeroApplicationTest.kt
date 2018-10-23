package com.doghero.application

import android.app.Application
import com.doghero.di.heroesModule
import com.doghero.domain.rxjava.repository.HeroRepository
import com.doghero.fake.FakeHeroRepository
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class DogHeroApplicationTest: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule, heroesModule))
    }
}

val applicationModule = module {

    single<HeroRepository> { FakeHeroRepository() }

}