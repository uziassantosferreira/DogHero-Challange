package com.doghero.domain.rxjava.exception

sealed class Failure {
    object Network: Failure()
    object Generic: Failure()
}