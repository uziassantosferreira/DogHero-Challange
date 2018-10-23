package com.doghero.domain.rxjava.model

import com.doghero.domain.rxjava.util.InvalidData

data class User(val firstName: String = InvalidData.UNINITIALIZED.getString(),
                val imageUrl: String = InvalidData.UNINITIALIZED.getString())