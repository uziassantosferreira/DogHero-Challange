package com.doghero.data.mapper

import com.doghero.domain.rxjava.exception.DomainThrowable
import com.doghero.domain.rxjava.exception.Failure
import com.doghero.domain.rxjava.model.Category
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test
import java.net.UnknownHostException

class ExceptionMapperTest {
    private val categories = hashMapOf(
        Pair(UnknownHostException(), DomainThrowable(Failure.Network)),
        Pair(Exception(), DomainThrowable()))

    @Test
    fun `should be correctly transform and expected domain`() {
        categories.forEach { remote, domain ->
            correctlyTransform(domain, remote)
        }
    }

    @Test
    fun `should be return exception when transform domain to any exception`() {
        categories.forEach { _, domain ->
            correctlyThrow(domain)
        }
    }

    private fun correctlyTransform(
        expected: DomainThrowable,
        current: Throwable
    ) {
        val remote = ExceptionMapper.transformTo(current)

        remote.failure shouldEqual expected.failure
    }

    private fun correctlyThrow(current: DomainThrowable) {
        val remote = { ExceptionMapper.transformFrom(current) }

        remote shouldThrow NotImplementedError::class
    }
}