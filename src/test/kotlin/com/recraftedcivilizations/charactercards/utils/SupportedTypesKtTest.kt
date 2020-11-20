package com.recraftedcivilizations.charactercards.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class SupportedTypesKtTest{

    internal open class A {
        val foo = "Bar"
    }

    internal class B : A() {
        val bar = "Foo"
    }

    internal class C{
        val bar="FooBar"
    }

    @Test
    fun shouldTryCast(){
        val start = B()

        start.tryCast<A> {
            start as A
        }
    }

    @Test
    fun shouldFailTryCast(){
        val start = C()
        start.tryCast<A> { start as A }
    }
}