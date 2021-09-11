package com.recraftedcivilizations.charactercards.cards

/**
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

interface IAmACard {
    var fields: List<String>
    var valueMap: MutableMap<String, String?>

    /**
     * @param key The key for the field you want to have
     * @return    Returns the field value or null if the field does not exist
     */
    fun getFieldValue(key : String) : String?

    /**
     * @param key The field to set
     * @param value The value to set
     */
    fun setFieldValue(key: String, value: String)

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
    fun display(player: Player, mode: String)
}