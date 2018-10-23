package com.doghero.mapper

import com.doghero.domain.rxjava.model.Address
import com.doghero.model.PresentationAddress
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationAddressMapperTest {
    companion object {
        private const val FAKE_NEIGHBORHOOD = "RUA EVARISTO"
    }

    private val address = Address(FAKE_NEIGHBORHOOD)

    private val presentationAddress = PresentationAddress(FAKE_NEIGHBORHOOD)

    @Test
    fun `should be correctly transform and expected presentation`() {
        val converted = PresentationAddressMapper.transformTo(address)

        converted shouldEqual presentationAddress
    }

    @Test
    fun `should be return exception when transform presentation to domain`() {
        val remote = { PresentationAddressMapper.transformFrom(presentationAddress) }

        remote shouldThrow NotImplementedError::class
    }
}