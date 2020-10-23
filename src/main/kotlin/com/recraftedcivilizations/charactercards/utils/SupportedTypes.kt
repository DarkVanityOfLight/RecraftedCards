package com.recraftedcivilizations.charactercards.utils

inline fun <reified T> Any?.tryCast(block: T.() -> T) {
    if (this is T) {
        block()
    }
}

enum class SupportedTypes {

    // Numbers
    BYTE{
        override fun convert(x: Any): Byte? {
            if(x is Number){
                with(x as Number){
                    return x.toByte()
                }
            }
            return null
        }

        override fun cast(x: Any): Byte? {
            x.tryCast<Byte> {
                return x as Byte
            }
            return null
        }

        override val exampleVal : Byte = 0x0E.toByte()
    },

    SHORT{
        override fun convert(x: Any): Short? {
            if(x is Number){
                with(x as Number){
                    return x.toShort()
                }
            }
            return null
        }

        override fun cast(x: Any): Any? {
            x.tryCast<Short> {
                return x as Short
            }
            return null
        }

        override val exampleVal : Short = 5.toShort()
    },

    INT{
        override fun convert(x: Any): Int? {
            if(x is Number){
                with(x as Number){
                    return x.toInt()
                }
            }
            return null
        }

        override fun cast(x : Any): Int?{
           x.tryCast<Int> {
               return x as Int
           }
           return null
       }

        override val exampleVal: Int = 5.toInt()
    },

    LONG{
        override fun convert(x: Any): Long? {
            if(x is Number){
                with(x as Number){
                    return x.toLong()
                }
            }
            return null
        }

        override fun cast(x: Any): Long? {
            x.tryCast<Long> {
                return x as Long
            }
            return null
        }

        override val exampleVal: Long = 5.toLong()
    },

    FLOAT{
        override fun convert(x: Any): Float? {
            if(x is Number){
                with(x as Number){
                    return x.toFloat()
                }
            }
            return null
        }

        override fun cast(x: Any): Float? {
            x.tryCast<Float> {
                return x as Float
            }
            return null
        }

        override val exampleVal: Float = 3.4.toFloat()
    },

    DOUBLE{
        override fun convert(x: Any): Double? {
            if(x is Number){
                with(x as Number){
                    return x.toDouble()
                }
            }
            return null
        }
        override fun cast(x: Any): Double? {
            x.tryCast<Double> {
                return x as Double
            }
            return null
        }

        override val exampleVal: Double = 3.toDouble()
    },

    // Boolean
    BOOLEAN{
        override fun convert(x: Any): Any? {
            return null
        }
        override fun cast(x: Any): Boolean? {
            x.tryCast<Boolean> {
                return x as Boolean
            }
            return null
        }

        override val exampleVal: Boolean = true
    },

    STRING{
        override fun convert(x: Any): Any? {
            return null
        }
        override fun cast(x: Any): String? {
            x.tryCast<String> {
                return x as String
            }
            return null
        }

        override val exampleVal: String = "Foo"
    };


    abstract fun cast(x: Any) : Any?
    abstract val exampleVal : Any
    abstract fun convert(x: Any) : Any?
}