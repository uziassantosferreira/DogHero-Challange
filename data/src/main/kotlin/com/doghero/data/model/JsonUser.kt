package com.doghero.data.model

import com.google.gson.annotations.SerializedName

data class JsonUser(@SerializedName("first_name") val firstName: String? = null,
                    @SerializedName("image_url") val imageUrl: String? = null)