package com.doghero.mapper

import com.doghero.base.BaseMapper
import com.doghero.domain.rxjava.exception.Failure
import com.doghero.exception.PresentationFailure

object PresentationFailureMapper: BaseMapper<Failure, PresentationFailure>() {
    override fun transformFrom(source: PresentationFailure): Failure {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: Failure): PresentationFailure =
        when(source) {
            Failure.Network -> PresentationFailure.Network
            Failure.Generic -> PresentationFailure.Generic
        }
}