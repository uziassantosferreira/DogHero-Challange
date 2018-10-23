package com.doghero.mapper

import com.doghero.data.mapper.BaseMapper
import com.doghero.domain.rxjava.exception.DomainThrowable
import com.doghero.exception.PresentationFailure

object PresentationExceptionMapper: BaseMapper<Throwable, PresentationFailure>() {

    override fun transformFrom(source: PresentationFailure): Exception {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: Throwable): PresentationFailure {
        return when (source) {
            is DomainThrowable -> PresentationFailureMapper.transformTo(source.failure)
            else -> PresentationFailure.Generic
        }
    }


}