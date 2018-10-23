package com.doghero.data.repository

import com.doghero.data.datasource.HeroDatasource
import com.doghero.domain.rxjava.model.Address
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.model.User
import com.doghero.domain.rxjava.repository.HeroRepository
import io.reactivex.Flowable
import java.util.*
import java.util.concurrent.TimeUnit

class HeroRepositoryImpl(
    private val heroDatasource: HeroDatasource): HeroRepository {

    override fun getHeroes(): Flowable<HashMap<Category, List<Hero>>> = heroDatasource.getHeroes()
}