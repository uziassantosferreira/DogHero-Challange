package com.doghero.mapper

import com.doghero.domain.rxjava.exception.Failure
import com.doghero.exception.PresentationFailure
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationFailureMapperTest {
    private val failures = hashMapOf(
        Pair(PresentationFailure.Generic, Failure.Generic),
        Pair(PresentationFailure.Network, Failure.Network))

    @Test
    fun `should be correctly transform and expected presentation`() {
        failures.forEach { presentation, domain ->
            correctlyTransform(presentation, domain)
        }
    }

    @Test
    fun `should be return exception when transform presentation to domain`() {
        failures.forEach { presentation, domain ->
            correctlyThrow(presentation)
        }
    }

    private fun correctlyTransform(
        expected: PresentationFailure,
        current: Failure
    ) {
        val remote = PresentationFailureMapper.transformTo(current)

        remote shouldEqual expected
    }

    private fun correctlyThrow(current: PresentationFailure) {
        val remote = { PresentationFailureMapper.transformFrom(current) }

        remote shouldThrow NotImplementedError::class
    }
}