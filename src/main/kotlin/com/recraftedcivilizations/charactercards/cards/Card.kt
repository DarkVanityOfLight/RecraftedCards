package com.recraftedcivilizations.charactercards.cards

import com.recraftedcivilizations.charactercards.utils.SupportedTypes


abstract class Card : IAmACard{

    constructor(fieldMap: Map<String, SupportedTypes>, valueMap: Map<String, Any>){
        val res = validateMaps(fieldMap, valueMap)
        if(!res.first){
            throw IllegalArgumentException(res.second)
        }else{
            this.fieldMap = fieldMap
            this.valueMap = valueMap
        }
    }

    constructor(fieldMap: Map<String, SupportedTypes>)


    companion object{
        const val FIELD_DOES_NOT_EXIST = "A field parsed is not declared in the config"
        const val FIELD_TYPE_OTHER_THEN_VALUE_TYPE = "A parsed value differs from the expected field type and could not be converted"


        /**
         * @param fieldMap A map that shows the Type for a field in the valueMap
         * @param valueMap Stores the fields from the character card
         * @return         A Pair of a boolean that indicates if the map is valid and an error message if the map is not
         */
        fun validateMaps(fieldMap: Map<String, SupportedTypes>, valueMap: Map<String, Any?>) : Pair<Boolean, String?>{
            for(key in valueMap.keys){
                val type: SupportedTypes = fieldMap[key] ?: return Pair(false, FIELD_DOES_NOT_EXIST)
                val value = valueMap[key]

                if (value != null){
                    try{
                        val supportedType = SupportedTypes.valueOf(value::class.simpleName!!.toUpperCase())
                        if (supportedType != type){
                            if(type.convert(supportedType) != null){
                                continue
                            }else{
                                return Pair(false, FIELD_TYPE_OTHER_THEN_VALUE_TYPE)
                            }
                        }
                    }catch (e: IllegalArgumentException){
                        return Pair(false, FIELD_TYPE_OTHER_THEN_VALUE_TYPE)
                    }
                }else continue
            }

            return Pair(true, null)
        }
    }
}