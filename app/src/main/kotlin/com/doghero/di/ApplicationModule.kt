package com.doghero.di

import com.doghero.data.HeroRepositoryImpl
import com.doghero.domain.rxjava.repository.HeroRepository
import org.koin.dsl.module.module

val applicationModule = module {

    single<HeroRepository> { HeroRepositoryImpl() }

}