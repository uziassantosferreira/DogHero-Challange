package com.doghero.mapper

import com.doghero.domain.rxjava.model.Address
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.model.User
import com.doghero.model.PresentationAddress
import com.doghero.model.PresentationHero
import com.doghero.model.PresentationUser
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationHeroMapperTest {
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

    private val presentationHero = PresentationHero(
        isSuperHero = true, user = PresentationUser(
            firstName = FAKE_NAME,
            imageUrl = FAKE_URL
        ), address = PresentationAddress(FAKE_NEIGHBORHOOD)
        , price = FAKE_PRICE
    )

    @Test
    fun `should be correctly transform and expected presentation`() {
        val converted = PresentationHeroMapper.transformTo(hero)

        converted shouldEqual presentationHero
    }

    @Test
    fun `should be return exception when transform presentation to domain`() {
        val remote = { PresentationHeroMapper.transformFrom(presentationHero) }

        remote shouldThrow NotImplementedError::class
    }
}