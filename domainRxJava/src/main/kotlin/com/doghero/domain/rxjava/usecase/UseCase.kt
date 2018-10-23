package com.doghero.domain.rxjava.usecase

import com.doghero.domain.rxjava.requestvalue.RequestValues
import io.reactivex.Flowable

abstract class UseCase<in RV : RequestValues, T> {

    private var requestValue: RV? = null

    fun setRequestValues(requestValues: RV?) {
        this.requestValue = requestValues
    }

    fun run(): Flowable<T> {
        return executeUseCase(requestValue)
    }

    abstract fun executeUseCase(requestValues: RV? = null): Flowable<T>
}