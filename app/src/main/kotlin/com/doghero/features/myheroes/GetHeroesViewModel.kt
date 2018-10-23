package com.doghero.features.myheroes

import android.arch.lifecycle.MutableLiveData
import com.doghero.base.BaseViewModel
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.requestvalue.RequestValues
import com.doghero.domain.rxjava.usecase.UseCase
import com.doghero.mapper.PresentationExceptionMapper
import com.doghero.mapper.PresentationMyHeroesMapper
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero
import com.doghero.util.UseCaseHandler
import io.reactivex.rxkotlin.subscribeBy

class GetHeroesViewModel(private val getMyHeroes: UseCase<RequestValues,
        HashMap<Category, List<Hero>>>
) : BaseViewModel() {

    val heroes: MutableLiveData<HashMap<PresentationCategory,
            List<PresentationHero>>> = MutableLiveData()

    fun loadHeroes() {
        compositeDisposable.add(
            UseCaseHandler.execute(getMyHeroes)
                .map(PresentationMyHeroesMapper::transformTo)
                .subscribeBy(
                    onError = {
                        handleFailure(PresentationExceptionMapper.transformTo(it))
                    },
                    onNext = {
                        heroes.value = it
                    }
                )
        )
    }
}