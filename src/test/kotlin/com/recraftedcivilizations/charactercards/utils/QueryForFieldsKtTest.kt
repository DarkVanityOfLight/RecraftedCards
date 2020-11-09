package com.recraftedcivilizations.charactercards.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.opentest4j.AssertionFailedError
import java.util.function.Supplier

fun assertEquals(expected: Map<String, Any>, actual: Map<String, Any>, messageSupplier: Supplier<String>) {
    if (expected != actual) {
        fail(messageSupplier.get(), expected, actual)
    }
}

fun fail(message: String?, expected: Any?, actual: Any?) {
    throw AssertionFailedError(message, expected, actual)
}

internal class QueryForFieldsKtTest {

    @Test
    fun shouldQueryForFields() {
        val text = "Name: FooBar\nBar Foo\n"
        val fieldMap = mapOf(
            Pair("Name", SupportedTypes.STRING),
            Pair("Bar", SupportedTypes.STRING),
            Pair("FooBarBar", SupportedTypes.STRING)
        )
        val result = queryForFields(fieldMap, text)
        assertEquals(mapOf(Pair("Name", "FooBar"), Pair("Bar", "Foo"), Pair("FooBarBar", null)), result)
    }
}