package com.doghero.features.myheroes

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import com.doghero.fake.FakeHeroRepository
import com.doghero.fake.FakeStatus
import com.doghero.features.menu.MenuActivity
import org.junit.Rule
import org.junit.Test

class MyHeroesFragmentTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(MenuActivity::class.java, true, false)

    private val screen = TestMyHeroes()

    @Test
    fun shouldBeShowList() {
        FakeHeroRepository.fakeStatus = FakeStatus.SUCCESS
        rule.launchActivity(getIntent())
        screen {
            recyclerView {
                isVisible()
                lastChild<TestMyHeroes.Item> {
                    title {
                        hasText("Test")
                    }
                }
            }
        }
    }

    @Test
    fun shouldBeShowLoading() {
        FakeHeroRepository.fakeStatus = FakeStatus.LOADING
        rule.launchActivity(getIntent())
        screen {
            loading {
                isVisible()
            }
        }
    }

    @Test
    fun shouldBeShowError() {
        FakeHeroRepository.fakeStatus = FakeStatus.FAILURE
        rule.launchActivity(getIntent())
        screen {
            emptyView {
                isVisible()
            }
        }
    }

    private fun getIntent(): Intent {
        val targetContext = InstrumentationRegistry.getInstrumentation()
            .targetContext
        return Intent(targetContext, MenuActivity::class.java)
    }
}