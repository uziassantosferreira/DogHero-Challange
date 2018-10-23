package com.doghero.data.mapper

import com.doghero.domain.rxjava.exception.DomainThrowable
import com.doghero.domain.rxjava.exception.Failure
import java.net.UnknownHostException

object ExceptionMapper: BaseMapper<Throwable, DomainThrowable>() {

    override fun transformFrom(source: DomainThrowable): Exception {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: Throwable): DomainThrowable {
        return when (source) {
            is UnknownHostException -> DomainThrowable(Failure.Network)
            else -> DomainThrowable()
        }
    }


}