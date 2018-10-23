package com.doghero.domain.rxjava.model

import com.doghero.domain.rxjava.util.InvalidData

data class Address(val neighborhood: String = InvalidData.UNINITIALIZED.getString())