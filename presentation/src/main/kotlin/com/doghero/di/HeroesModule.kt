package com.doghero.di

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.requestvalue.RequestValues
import com.doghero.domain.rxjava.usecase.GetMyHeroes
import com.doghero.domain.rxjava.usecase.UseCase
import com.doghero.features.myheroes.GetHeroesViewModel
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val heroesModule = module {

    single<UseCase<RequestValues,
            HashMap<Category, List<Hero>>>> { GetMyHeroes(get()) }

    factory { SectionedRecyclerViewAdapter() }

    viewModel { GetHeroesViewModel(get()) }
}