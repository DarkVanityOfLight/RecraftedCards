package com.recraftedcivilizations.charactercards.utils.serializer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ValueMapSerializerTest {

    @Test
    fun serialize() {
        val map = mapOf(Pair("Foo", "Bar"), Pair("Bar", 3))

        val res = ValueMapSerializer().serialize(map)
        println(res)
        assert(res == "{ \"Foo\" : \"Bar\", \"Bar\" : 3 }")

    }
}