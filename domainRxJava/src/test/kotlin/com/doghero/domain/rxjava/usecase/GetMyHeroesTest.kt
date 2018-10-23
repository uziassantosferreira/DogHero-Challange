package com.doghero.domain.rxjava.usecase

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.repository.HeroRepository
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Flowable
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMyHeroesTest {

    private val repository: HeroRepository = mock()

    private val hash = hashMapOf(Category.FAVORITES to listOf(Hero()))

    @InjectMocks
    private lateinit var useCase: GetMyHeroes

    @Before
    fun `set up mocks`() {
        When calling repository.getHeroes() itReturns Flowable.just(hash)
    }

    @Test
    fun `execute use case and expected success`() {
        useCase.run()
                .test()
                .assertValue(hash)
                .assertComplete()
                .assertNoErrors()
    }

}
