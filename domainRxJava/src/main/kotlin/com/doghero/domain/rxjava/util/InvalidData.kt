package com.doghero.domain.rxjava.util

enum class InvalidData {

    UNINITIALIZED;

    fun getString() = ARG_INVALID_STRING
    fun getLong() = ARG_INVALID_LONG
    fun getBoolean() = ARG_INVALID_BOOLEAN

    companion object {
        private const val ARG_INVALID_STRING = ""
        private const val ARG_INVALID_LONG = -33L
        private const val ARG_INVALID_BOOLEAN = false

        fun isInvalid(data: Any): Boolean =
            when (data) {
                is String -> data == ARG_INVALID_STRING
                is Long -> data == ARG_INVALID_LONG
                is Boolean -> data == ARG_INVALID_BOOLEAN
                else -> false
            }
    }
}

