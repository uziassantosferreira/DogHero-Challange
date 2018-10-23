package com.doghero.model

import com.doghero.domain.rxjava.util.InvalidData

data class PresentationAddress(val neighborhood: String = InvalidData.UNINITIALIZED.getString())