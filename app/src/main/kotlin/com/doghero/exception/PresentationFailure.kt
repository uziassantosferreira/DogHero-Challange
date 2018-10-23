package com.doghero.exception

import android.support.annotation.StringRes
import com.doghero.R

sealed class PresentationFailure {
    object Network: PresentationFailure()
    object Generic: PresentationFailure()

    @StringRes
    fun getMessage(): Int {
        return when(this) {
            PresentationFailure.Network -> R.string.msg_error_network
            else -> R.string.msg_error
        }
    }
}