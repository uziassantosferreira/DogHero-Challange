package com.doghero.domain.rxjava.usecase

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.repository.HeroRepository
import com.doghero.domain.rxjava.requestvalue.RequestValues
import io.reactivex.Flowable

class GetMyHeroes(private val repository: HeroRepository): UseCase<RequestValues, HashMap<Category, List<Hero>>>() {
    override fun executeUseCase(requestValues: RequestValues?): Flowable<HashMap<Category, List<Hero>>> =
        repository.getHeroes()
}