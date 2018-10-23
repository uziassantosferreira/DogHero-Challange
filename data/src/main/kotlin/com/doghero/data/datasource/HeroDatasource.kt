package com.doghero.data.datasource

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import io.reactivex.Flowable

interface HeroDatasource {
    fun getHeroes(): Flowable<HashMap<Category, List<Hero>>>
}