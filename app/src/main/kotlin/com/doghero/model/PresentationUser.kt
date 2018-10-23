package com.doghero.model

import com.doghero.domain.rxjava.util.InvalidData

data class PresentationUser(val firstName: String = InvalidData.UNINITIALIZED.getString(),
                            val imageUrl: String = InvalidData.UNINITIALIZED.getString())