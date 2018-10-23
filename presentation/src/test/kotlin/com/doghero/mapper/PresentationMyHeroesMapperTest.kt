package com.doghero.mapper

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationMyHeroesMapperTest {

    private val myHeroes = hashMapOf(Category.FAVORITES to listOf(Hero()))

    private val presentationMyHeroes = hashMapOf(PresentationCategory.FAVORITES to listOf(PresentationHero()))

    @Test
    fun `should be correctly transform and expected presentation`() {
        val converted = PresentationMyHeroesMapper.transformTo(myHeroes)

        converted shouldEqual presentationMyHeroes
    }

    @Test
    fun `should be return exception when transform presentation to domain`() {
        val remote = { PresentationMyHeroesMapper.transformFrom(presentationMyHeroes) }

        remote shouldThrow NotImplementedError::class
    }
}