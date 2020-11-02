package com.recraftedcivilizations.charactercards.inapi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RequestTest{

    @Test
    fun shouldSerialize(){

        val toSerialze : Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")

        assertEquals( "{\"id\":\"foo\",\"methode\":\"bar\",\"params\":{\"Foo\":\"Bar\"},\"jsonrpc\":\"foo\"}" ,toSerialze.serialize())
    }
}