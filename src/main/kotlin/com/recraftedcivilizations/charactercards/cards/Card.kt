package com.recraftedcivilizations.charactercards.cards

import com.recraftedcivilizations.charactercards.utils.SupportedTypes

/**
 * Represents a simple card with fields and values
 * @author DarkVanityOfLight
 * @constructor Initialize a card using given fields and values, checks the values for their field types
 * @constructor Initialize a card using given fields, null all values
 * @property fieldMap A map with all field names and their type
 * @property valueMap A map with all field names and their value
 */
abstract class Card : IAmACard{
    final override var fieldMap: Map<String, SupportedTypes>
    final override var valueMap: MutableMap<String, Any?>

    /**
     * @param fieldMap A map with all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(fieldMap: Map<String, SupportedTypes>, valueMap: Map<String, Any?>){
        val res = validateMaps(fieldMap, valueMap)
        if(!res.first){
            throw IllegalArgumentException(res.second)
        }else{
            this.fieldMap = fieldMap
            this.valueMap = valueMap.toMutableMap()
        }
    }

    /**
     * @param fieldMap A map with all fields the card should have
     */
    constructor(fieldMap: Map<String, SupportedTypes>){

        val valueMap = emptyMap<String, Any?>().toMutableMap()
        for(key in fieldMap.keys){
            valueMap[key] =  null
        }

        val res = validateMaps(fieldMap, valueMap)
        if(!res.first){
            throw IllegalArgumentException(res.second)
        }else{
            this.fieldMap = fieldMap
            this.valueMap = valueMap
        }


    }

    /**
     * Get the type for a given field
     * @param key The field name to get the type from
     * @return Returns the Type or null if the field does not exist
     * @see SupportedTypes
     */
    override fun getFieldType(key: String): SupportedTypes?{
        return fieldMap[key]
    }

    /**
     * Get the field value
     * @param key The field name
     * @return Return the value or null if field does not exist
     */
    override fun getFieldValue(key: String): Any? {
        return valueMap[key]
    }

    /**
     * Get the field map
     * @return Returns a map of <String, SupportedTypes> representing all fields#
     * @see SupportedTypes
     */
    override fun getFields(): Map<String, SupportedTypes> {
        return fieldMap
    }

    /**
     * Set a value in the value map
     * @param key The field name to set the value
     * @param value The value to set
     */
    override fun setFieldValue(key: String, value: Any) {
        if(key in fieldMap.keys){
            if(fieldMap[key]!!.cast(value) != null || fieldMap[key]!!.convert(value) != null){
                valueMap[key] = value
            }
        }
    }

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
                        val currentType = SupportedTypes.valueOf(value::class.simpleName!!.toUpperCase())
                        if (currentType != type){
                            if(type.convert(value) != null){
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