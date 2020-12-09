package com.recraftedcivilizations.charactercards.inapi.enjin

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

    @Test
    fun getId() {
        val toTest: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")
        assertEquals("foo", toTest.id)
    }

    @Test
    fun getMethode() {
        val toTest: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")
        assertEquals("bar", toTest.methode)
    }

    @Test
    fun getParams() {
        val toTest: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")
        assertEquals(mapOf(Pair("Foo", "Bar")), toTest.params)
    }

    @Test
    fun getJsonrpc() {
        var toTest: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")
        assertEquals("foo", toTest.jsonrpc)
        toTest = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), null)
        assertEquals(null, toTest.jsonrpc)
    }

    @Test
    fun setJsonrpc() {
        val toTest: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")
        toTest.jsonrpc = "bar"
        assertEquals("bar", toTest.jsonrpc)
    }

    @Test
    fun shouldGenerateHeaderAndBody() {}

    @Test
    fun toSendableRequest() {
        val toTest: Request = Request("foo", "bar", mapOf(Pair("Foo", "Bar")), "foo")
        assertEquals(Pair("", "{\"id\":\"foo\",\"methode\":\"bar\",\"params\":{\"Foo\":\"Bar\"},\"jsonrpc\":\"foo\"}"), toTest.toSendableRequest())
    }

}