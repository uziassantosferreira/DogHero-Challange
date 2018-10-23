package com.doghero.data.api.helper

import com.google.gson.GsonBuilder

object JsonObjectConverter {

    private val gson = GsonBuilder()
        .create()

    fun <T> convertFromJson(json: String, jsonObjectClass: Class<T>): T {
        return gson.fromJson(json, jsonObjectClass)
    }

}