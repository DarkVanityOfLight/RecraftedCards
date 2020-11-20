package com.recraftedcivilizations.charactercards.utils.serializer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ValueMapSerializerTest {

    @Test
    fun shouldSerialize() {
        val map = mapOf(Pair("Foo", "Bar"), Pair("Bar", 3), Pair("FooBar", null))

        val res = ValueMapSerializer().serialize(map)
        assert(res == "{ \"Foo\" : \"Bar\", \"Bar\" : 3, \"FooBar\" : null }")

    }
}