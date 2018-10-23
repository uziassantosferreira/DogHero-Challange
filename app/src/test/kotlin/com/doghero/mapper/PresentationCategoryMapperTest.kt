package com.doghero.mapper

import com.doghero.domain.rxjava.model.Category
import com.doghero.model.PresentationCategory
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationCategoryMapperTest {

    private val categories = hashMapOf(
        Pair(PresentationCategory.FAVORITES, Category.FAVORITES),
        Pair(PresentationCategory.RECENTS, Category.RECENTS))

    @Test
    fun `should be correctly transform and expected presentation`() {
        categories.forEach { presentation, domain ->
            correctlyTransform(presentation, domain)
        }
    }

    @Test
    fun `should be return exception when transform presentation to domain`() {
        categories.forEach { presentation, _ ->
            correctlyThrow(presentation)
        }
    }

    private fun correctlyTransform(
        expected: PresentationCategory,
        current: Category) {
        val remote = PresentationCategoryMapper.transformTo(current)

        remote shouldEqual expected
    }

    private fun correctlyThrow(current: PresentationCategory) {
        val remote = { PresentationCategoryMapper.transformFrom(current) }

        remote shouldThrow NotImplementedError::class
    }
}