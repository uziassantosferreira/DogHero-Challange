package com.doghero.data.mapper

import com.doghero.data.model.JsonHero
import com.doghero.data.model.JsonUser
import com.doghero.domain.rxjava.model.Address
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.model.User
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class JsonHeroMapperTest {
    companion object {
        private const val FAKE_NEIGHBORHOOD = "RUA EVARISTO"
        private const val FAKE_NAME = "Teste Name"
        private const val FAKE_URL = "http://teste.com"
        private const val FAKE_PRICE = 100L
    }

    private val hero = Hero(
        isSuperHero = true, user = User(
            firstName = FAKE_NAME,
            imageUrl = FAKE_URL
        ), address = Address(FAKE_NEIGHBORHOOD)
        , price = FAKE_PRICE
    )

    private val jsonHero = JsonHero(
        isSuperHero = true, user = JsonUser(
            firstName = FAKE_NAME,
            imageUrl = FAKE_URL
        ), addressNeighborhood = FAKE_NEIGHBORHOOD
        , price = FAKE_PRICE
    )

    @Test
    fun `should be correctly transform and expected domain`() {
        val converted = JsonHeroMapper.transformFrom(jsonHero)

        converted shouldEqual hero
    }

    @Test
    fun `should be return exception when transform domain to json`() {
        val remote = { JsonHeroMapper.transformTo(hero) }

        remote shouldThrow NotImplementedError::class
    }
}