package com.doghero.mapper

import com.doghero.domain.rxjava.exception.DomainThrowable
import com.doghero.domain.rxjava.exception.Failure
import com.doghero.exception.PresentationFailure
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationExceptionMapperTest {
    private val exceptions = hashMapOf(
        Pair(DomainThrowable(Failure.Network), PresentationFailure.Network),
        Pair(Throwable(), PresentationFailure.Generic))

    @Test
    fun `should be correctly transform and expected presentation`() {
        exceptions.forEach { remote, domain ->
            correctlyTransform(domain, remote)
        }
    }

    @Test
    fun `should be return exception when transform domain to any exception`() {
        exceptions.forEach { _, domain ->
            correctlyThrow(domain)
        }
    }

    private fun correctlyTransform(
        expected: PresentationFailure,
        current: Throwable
    ) {
        val remote = PresentationExceptionMapper.transformTo(current)

        remote shouldEqual expected
    }

    private fun correctlyThrow(current: PresentationFailure) {
        val remote = { PresentationExceptionMapper.transformFrom(current) }

        remote shouldThrow NotImplementedError::class
    }
}