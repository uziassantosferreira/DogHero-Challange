package com.doghero.mapper

import com.doghero.domain.rxjava.model.User
import com.doghero.model.PresentationUser
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class PresentationUserMapperTest {
    companion object {
        private const val FAKE_NAME = "Teste Name"
        private const val FAKE_URL = "http://teste.com"
    }

    private val user = User(FAKE_NAME, FAKE_URL)

    private val presentationUser = PresentationUser(FAKE_NAME, FAKE_URL)

    @Test
    fun `should be correctly transform and expected presentation`() {
        val converted = PresentationUserMapper.transformTo(user)

        converted shouldEqual presentationUser
    }

    @Test
    fun `should be return exception when transform presentation to domain`() {
        val remote = { PresentationUserMapper.transformFrom(presentationUser) }

        remote shouldThrow NotImplementedError::class
    }
}