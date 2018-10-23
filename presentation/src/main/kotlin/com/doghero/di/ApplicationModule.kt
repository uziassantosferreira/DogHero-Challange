package com.doghero.di

import com.doghero.data.datasource.HeroDatasource
import com.doghero.data.datasource.HeroDatasourceImpl
import com.doghero.data.repository.HeroRepositoryImpl
import com.doghero.domain.rxjava.repository.HeroRepository
import org.koin.dsl.module.module

val applicationModule = module {

    single<HeroRepository> { HeroRepositoryImpl(get()) }

    single<HeroDatasource> { HeroDatasourceImpl(get()) }
}