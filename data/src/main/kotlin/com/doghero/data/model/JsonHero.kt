package com.doghero.data.model

import com.google.gson.annotations.SerializedName

data class JsonHero(@SerializedName("is_superhero") val isSuperHero: Boolean? = null,
                    val user: JsonUser? = null,
                    @SerializedName("address_neighborhood") val addressNeighborhood: String? = null,
                    val price: Long? = null)