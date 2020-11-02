package com.recraftedcivilizations.charactercards.inapi

import com.recraftedcivilizations.charactercards.inapi.enjin.Request
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RequestTest {

    @Test
    fun shouldSerialize() {

        val toSerialze: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo", "Foo", "Bar")

        assertEquals(
            "{\"id\":\"foo\",\"methode\":\"bar\",\"params\":{\"Foo\":\"Bar\"},\"jsonrpc\":\"foo\",\"body\":\"Foo\",\"header\":\"Bar\"}",
            toSerialze.serialize()
        )
    }
}