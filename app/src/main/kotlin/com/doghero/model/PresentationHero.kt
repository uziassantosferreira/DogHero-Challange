package com.doghero.model

import com.doghero.domain.rxjava.util.InvalidData
import java.text.NumberFormat

data class PresentationHero(val isSuperHero: Boolean = InvalidData.UNINITIALIZED.getBoolean(),
                            val user: PresentationUser = PresentationUser(),
                            val address: PresentationAddress = PresentationAddress(),
                            val price: Long = InvalidData.UNINITIALIZED.getLong()) {

    fun getPriceFormatted(): String {
        val format = NumberFormat.getCurrencyInstance()
        return format.format(price)
    }
}