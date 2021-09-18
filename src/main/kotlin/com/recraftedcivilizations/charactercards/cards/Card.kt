package com.recraftedcivilizations.charactercards.cards


/**
 * Represents a simple card with fields and values
 * @author DarkVanityOfLight
 * @constructor Initialize a card using given fields and values, checks the values for their field types
 * @constructor Initialize a card using given fields, null all values
 * @property configFields A list with all field names and their type
 * @property valueMap A map with all field names and their value
 */
abstract class Card : IAmACard{
    final override var configFields: List<String>
    final override var valueMap: MutableMap<String, String?>

    /**
     * @param fields A list containing all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(configFields: List<String>, valueMap: Map<String, String?>){
            this.configFields = configFields
            this.valueMap = valueMap.toMutableMap()
    }

    /**
     * @param fields A list with all fields the card should have
     */
    constructor(configFields: List<String>){

        val valueMap = emptyMap<String, String?>().toMutableMap()
        for(key in configFields){
            valueMap[key] =  null
        }

        this.valueMap = valueMap
        this.configFields = configFields
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