package com.doghero.model

import android.support.annotation.StringRes
import com.doghero.R

enum class PresentationCategory {
    RECENTS, FAVORITES;

    @StringRes
    fun getTitle(): Int =
        when(this){
            RECENTS -> R.string.title_heroes_recents
            FAVORITES -> R.string.title_heroes_favorites
        }
}