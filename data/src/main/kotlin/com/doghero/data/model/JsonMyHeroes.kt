package com.doghero.data.model

data class JsonMyHeroes(val recents: List<JsonHero>? = null,
                        val favorites: List<JsonHero>? = null)