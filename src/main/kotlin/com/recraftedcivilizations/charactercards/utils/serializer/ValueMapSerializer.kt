package com.recraftedcivilizations.charactercards.utils.serializer

/**
 * @author DarkVanityOfLight
 */

class ValueMapSerializer {

    /**
     * @param valueMap The map you want to serialize as a String
     * @return         The serialized map as String
     */
    fun serialize(valueMap : Map<String, Any?>) : String{

        var valueSerialization = emptySequence<String>()
        for(key in valueMap.keys){
            val value = valueMap[key]

            valueSerialization = valueSerialization.plus("\"$key\"")
            valueSerialization = valueSerialization.plus(":")

            if(value is Number) valueSerialization = valueSerialization.plus(value.toString())
            else valueSerialization = valueSerialization.plus("\"${value}\",")

        }
        var string : String= valueSerialization.joinToString(" ")
        string = string.removeSuffix(",")
        return "{ $string }"
    }

}