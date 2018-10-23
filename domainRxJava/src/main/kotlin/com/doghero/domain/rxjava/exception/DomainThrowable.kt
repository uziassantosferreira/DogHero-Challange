package com.doghero.domain.rxjava.exception

class DomainThrowable(val failure: Failure = Failure.Generic): Throwable()