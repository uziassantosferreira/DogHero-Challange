package com.doghero.data.mapper

import com.doghero.data.model.JsonUser
import com.doghero.domain.rxjava.model.User
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import org.junit.Test

class JsonUserMapperTest {
    companion object {
        private const val FAKE_NAME = "Teste Name"
        private const val FAKE_URL = "http://teste.com"
    }

    private val user = User(FAKE_NAME, FAKE_URL)

    private val jsonUser = JsonUser(FAKE_NAME, FAKE_URL)

    @Test
    fun `should be correctly transform and expected domain`() {
        val converted = JsonUserMapper.transformFrom(jsonUser)

        converted shouldEqual user
    }

    @Test
    fun `should be return exception when transform domain to json`() {
        val remote = { JsonUserMapper.transformTo(user) }

        remote shouldThrow NotImplementedError::class
    }
}