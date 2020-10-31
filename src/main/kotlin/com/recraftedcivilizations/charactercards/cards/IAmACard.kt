package com.recraftedcivilizations.charactercards.cards

/**
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.io.Serializable

interface IAmACard : Serializable {
    var fieldMap: Map<String, SupportedTypes>
    var valueMap: Map<String, Any>


    /**
     * @return Returns a map with all fields and their Type
     */
    fun getFields() : Map<String, SupportedTypes>

    /**
     * @param key The key for the field you want to have
     * @return    Returns the field value or null if the field does not exist
     */
    fun getFieldValue(key : String) : Any?

    /**
     * @param key The key for the field you want to have
     * @return    Returns the type of the field or null
     */
    fun getFieldType(key : String): SupportedTypes?

    /**
     * @return Returns the output representation for the Card as String
     */
    fun getChatOutputRepresentation() : String

    /**
     * @return Returns the output representation for the Card as an Inventory GUI
     */
    fun getGUIOutputRepresentation() : Inventory

    /**
     * @param player The player the Card should be displayed to
     */
    fun display(player: Player)
}