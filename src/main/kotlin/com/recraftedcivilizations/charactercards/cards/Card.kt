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
    final override var fields: List<String>
    final override var valueMap: MutableMap<String, String?>

    /**
     * @param fields A list containing all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(fields: List<String>, valueMap: Map<String, String?>){
            this.fields = fields
            this.valueMap = valueMap.toMutableMap()
    }

    /**
     * @param fields A list with all fields the card should have
     */
    constructor(fields: List<String>){

        val valueMap = emptyMap<String, String?>().toMutableMap()
        for(key in fields){
            valueMap[key] =  null
        }

        this.valueMap = valueMap
        this.fields = fields
    }

    /**
     * Get the field value
     * @param key The field name
     * @return Return the value or null if field does not exist
     */
    override fun getFieldValue(key: String): String? {
        return valueMap[key]
    }

    override fun setFieldValue(key: String, value: String) {
        valueMap[key] = value
    }
}