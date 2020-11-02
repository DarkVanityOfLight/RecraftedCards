package com.recraftedcivilizations.charactercards.enjinapi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RequestTest{

    @Test
    fun shouldSerialize(){

        val toSerialze : Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")))

        assertEquals( "{\"id\":\"foo\",\"methode\":\"bar\",\"params\":{\"Foo\":\"Bar\"}}" ,toSerialze.serialize())
    }
}