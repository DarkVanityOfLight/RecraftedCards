package com.recraftedcivilizations.charactercards.utils

import jdk.nashorn.internal.ir.annotations.Ignore
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory


internal class SupportedTypesTest{

    fun returnAsAny(x: Any) : Any{
        return x
    }

    @TestFactory
    fun castSuccessFactory() : Collection<DynamicTest>{
        val mutableSet: MutableSet<DynamicTest> = emptySet<DynamicTest>().toMutableSet()

        for(type in SupportedTypes.values()){
            val test = DynamicTest.dynamicTest(
                "shouldCastTo${type.name.toLowerCase().capitalize()}"
            ) {
                val anyType = type.cast(returnAsAny(type.exampleVal))
                assert(anyType == type.exampleVal)
            }
            mutableSet.add(test)
        }
        return mutableSet
    }

    @Ignore
    @TestFactory
    fun convertTestFactory(): Collection<DynamicTest>{
        val mutableSet: MutableSet<DynamicTest> = emptySet<DynamicTest>().toMutableSet()

        for (type in SupportedTypes.values()){
            //TODO Add test
        }

        return mutableSet
    }
}