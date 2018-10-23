package com.doghero.data.datasource

import com.doghero.data.api.HeroService
import com.doghero.data.model.JsonMyHeroes
import com.doghero.domain.rxjava.model.Category
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
class HeroDatasourceImplTest {

    private val service: HeroService = mock()

    @InjectMocks
    private lateinit var dataSource: HeroDatasourceImpl

    @Before
    fun `set up mocks`() {
        When calling service.getHeroes() itReturns Flowable.just(JsonMyHeroes(recents = listOf(), favorites = listOf()))
    }

    @Test
    fun `should be call service when get heroes and expected empty hash map`() {
        dataSource.getHeroes()
            .test()
            .assertValue(hashMapOf(Category.RECENTS to listOf(),
                Category.FAVORITES to listOf()))
            .assertComplete()
            .assertNoErrors()
    }
}