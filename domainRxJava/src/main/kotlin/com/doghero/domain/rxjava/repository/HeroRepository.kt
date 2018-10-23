package com.doghero.domain.rxjava.repository

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import io.reactivex.Flowable

interface HeroRepository {
    fun getHeroes(): Flowable<HashMap<Category, List<Hero>>>
}