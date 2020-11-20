package com.recraftedcivilizations.charactercards.inapi.enjin

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ResponseTest {

    @Test
    fun deserialize() {
        val response = Response("fooBar", "FOOBarFOO", "Foobarfoo")
        assertEquals(Unit, response.deserialize())
    }

    @Test
    fun getId() {
        val response = Response("fooBar", "FOOBarFOO", "Foobarfoo")
        assertEquals("fooBar", response.id)
    }

    @Test
    fun getBody() {
        val response = Response("fooBar", "FOOBarFOO", "Foobarfoo")
        assertEquals("FOOBarFOO", response.body)
    }

    @Test
    fun getHeader() {
        val response = Response("fooBar", "FOOBarFOO", "Foobarfoo")
        assertEquals("Foobarfoo", response.header)
    }
}