package com.recraftedcivilizations.charactercards.cards

import com.recraftedcivilizations.charactercards.cards.Card.Companion.FIELD_DOES_NOT_EXIST
import com.recraftedcivilizations.charactercards.cards.Card.Companion.FIELD_TYPE_OTHER_THEN_VALUE_TYPE
import com.recraftedcivilizations.charactercards.cards.Card.Companion.validateMaps
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CardTest{


    @Test
    fun shouldThrowFieldDoesNotExist() {

        val ret = validateMaps(mapOf(Pair("Foo", SupportedTypes.STRING)), mapOf(Pair("Bar", "Foo")))
        assert(ret == Pair(false, FIELD_DOES_NOT_EXIST))
    }

    @Test
    fun shouldThrowFieldTypeOtherThenValue() {

        val ret = validateMaps(mapOf(Pair("Foo", SupportedTypes.BOOLEAN)), mapOf(Pair("Foo", "Bar")))
        assert(ret == Pair(false, FIELD_TYPE_OTHER_THEN_VALUE_TYPE))
    }

    @Test
    fun shouldReturnTrue(){

        val ret = validateMaps(mapOf(Pair("Foo", SupportedTypes.STRING)), mapOf(Pair("Foo", "Bar")))
        assert(ret == Pair(true, null))
    }
}