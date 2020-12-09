package com.recraftedcivilizations.charactercards.inapi.enjin

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import java.net.URL

internal class EnjinAPITest {

    @Test
    fun request() {
        // TODO Test the implementation at the mocked api
    }

    @Test
    fun getUrl() {
        val api = EnjinAPI(URL("https://foo.bar"))
        assertEquals("https://foo.bar", api.url.toString())

    }

    @BeforeEach
    fun setUp() {
        // TODO Mock Enjin API and test requests
    }

    @AfterEach
    fun tearDown() {
        // TODO Stop mocked Enjin API
    }
}