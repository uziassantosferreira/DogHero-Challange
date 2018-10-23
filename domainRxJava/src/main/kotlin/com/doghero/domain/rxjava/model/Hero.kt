package com.doghero.domain.rxjava.model

import com.doghero.domain.rxjava.util.InvalidData

data class Hero(val isSuperHero: Boolean = InvalidData.UNINITIALIZED.getBoolean(),
                val user: User = User(),
                val address: Address = Address(),
                val price: Long = InvalidData.UNINITIALIZED.getLong())