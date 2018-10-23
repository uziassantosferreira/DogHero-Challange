package com.doghero.features.myheroes

import android.arch.lifecycle.MutableLiveData
import com.doghero.base.BaseViewModel
import com.doghero.domain.rxjava.usecase.GetMyHeroes
import com.doghero.exception.PresentationFailure
import com.doghero.mapper.PresentationMyHeroesMapper
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero
import com.doghero.util.UseCaseHandler
import io.reactivex.rxkotlin.subscribeBy

class GetHeroesViewModel(private val getMyHeroes: GetMyHeroes) : BaseViewModel() {

    val heroes: MutableLiveData<HashMap<PresentationCategory,
            List<PresentationHero>>> = MutableLiveData()

    fun loadHeroes() {
        compositeDisposable.add(
            UseCaseHandler.execute(getMyHeroes)
                .map(PresentationMyHeroesMapper::transformTo)
                .subscribeBy(
                    onError = {
                        handleFailure(PresentationFailure.Network)
                    },
                    onNext = {
                        heroes.value = it
                    }
                )
        )
    }
}