package com.doghero.data.repository

import com.doghero.data.datasource.HeroDatasource
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
class HeroRepositoryImplTest {

    private val dataSource: HeroDatasource = mock()

    @InjectMocks
    private lateinit var repository: HeroRepositoryImpl

    @Before
    fun `set up mocks`() {
        When calling dataSource.getHeroes() itReturns Flowable.just(hashMapOf())
    }

    @Test
    fun `should be call data source when get heroes and expected empty hash map`() {
        repository.getHeroes()
            .test()
            .assertValue(hashMapOf())
            .assertComplete()
            .assertNoErrors()
    }
}