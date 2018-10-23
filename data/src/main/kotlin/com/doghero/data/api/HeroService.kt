package com.doghero.data.api

import com.doghero.data.model.JsonMyHeroes
import io.reactivex.Flowable
import retrofit2.http.GET

interface HeroService {

    @GET("myheroes")
    fun getHeroes(): Flowable<JsonMyHeroes>
}