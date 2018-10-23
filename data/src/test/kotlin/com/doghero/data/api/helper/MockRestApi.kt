package com.doghero.data.api.helper

import com.doghero.data.di.Network.API_URL
import com.doghero.data.di.networkModule
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.test.KoinTest
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class MockRestApi: KoinTest {
    private lateinit var server: MockWebServer

    private lateinit var file: String
    lateinit var endpoint: String
    abstract val resource: String

    @Before
    open fun setUp() {
        setupReadFile()
        setupServer()
        startKoin(listOf(networkModule))
    }

    private fun setupReadFile() {
        file = fileFromResource(resource, javaClass)
    }

    private fun setupServer() {
        server = MockWebServer()
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(file)
        )
        server.start()
        endpoint = server.url(API_URL).toString()
    }

    @After
    fun tearDown() {
        server.shutdown()
        stopKoin()
    }

}

