package com.doghero.data.api.request

import com.doghero.data.api.HeroService
import com.doghero.data.api.helper.JsonObjectConverter
import com.doghero.data.api.helper.MockRestApi
import com.doghero.data.api.helper.fileFromResource
import com.doghero.data.model.JsonMyHeroes
import org.junit.Test
import org.koin.standalone.inject

class GetHeroes: MockRestApi() {
    override val resource: String = "GetMyHeroes.json"

    private lateinit var myHeroes: JsonMyHeroes

    private val service by inject<HeroService>()

    override fun setUp() {
        super.setUp()

        val heroesString = fileFromResource(resource, javaClass)
        myHeroes =
                JsonObjectConverter.convertFromJson(heroesString, JsonMyHeroes::class.java)
    }

    @Test
    fun getHeroesAndExpectedSuccess() {
        service.getHeroes()
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue(myHeroes)
    }
}