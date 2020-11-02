package com.recraftedcivilizations.charactercards.enjinapi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RequestTest{

    @Test
    fun shouldSerialize(){

        val toSerialze : Request = Request("foo", "bar")

        assertEquals( "{\"id\":\"foo\",\"methode\":\"bar\"}" ,toSerialze.serialize())
    }
}