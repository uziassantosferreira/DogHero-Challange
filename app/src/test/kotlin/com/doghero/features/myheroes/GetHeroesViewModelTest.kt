package com.doghero.features.myheroes

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.requestvalue.RequestValues
import com.doghero.domain.rxjava.usecase.UseCase
import com.doghero.exception.PresentationFailure
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero
import com.doghero.util.RxImmediateSchedulerRule
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Flowable
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetHeroesViewModelTest {

    private var getMyHeroes: UseCase<RequestValues,
            HashMap<Category, List<Hero>>> = mock()

    @InjectMocks
    private lateinit var viewModel: GetHeroesViewModel

    @Rule
    @JvmField
    var rxSchedulersOverrideRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun `set up mocks`() {
        When calling getMyHeroes.executeUseCase() itReturns Flowable.just(hashMapOf())
    }

    @Test
    fun `should get my heroes and expected success`() {
        val expectedResult = MutableLiveData<HashMap<PresentationCategory,
                List<PresentationHero>>>()

        expectedResult.value = hashMapOf()

        viewModel.loadHeroes()

        expectedResult.value shouldEqual viewModel.heroes.value
    }

    @Test
    fun `should get my heroes and expected failure`() {
        When calling getMyHeroes.executeUseCase() itReturns Flowable.error(Throwable())

        val expectedResult = MutableLiveData<PresentationFailure>()

        expectedResult.value = PresentationFailure.Generic

        viewModel.loadHeroes()

        expectedResult.value shouldEqual viewModel.failure.value
    }
}