package com.doghero.exception

sealed class PresentationFailure {
    object Network: PresentationFailure()
}