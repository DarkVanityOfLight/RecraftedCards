package com.recraftedcivilizations.charactercards.inapi.enjin

import com.recraftedcivilizations.charactercards.inapi.enjin.Request
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RequestTest {

    @Test
    fun shouldSerialize() {

        val toSerialze: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")

        assertEquals(
            "{\"id\":\"foo\",\"methode\":\"bar\",\"params\":{\"Foo\":\"Bar\"},\"jsonrpc\":\"foo\"}",
            toSerialze.serialize()
        )
    }
}