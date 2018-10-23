package com.doghero.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.doghero.exception.PresentationFailure
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    var failure: MutableLiveData<PresentationFailure> = MutableLiveData()

    val compositeDisposable = CompositeDisposable()


    protected fun handleFailure(failure: PresentationFailure) {
        this.failure.value = failure
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}