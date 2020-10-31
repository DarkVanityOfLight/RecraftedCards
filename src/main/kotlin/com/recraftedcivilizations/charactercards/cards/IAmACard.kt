package com.recraftedcivilizations.charactercards.cards

import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.io.Serializable

interface IAmACard : Serializable {
    var fieldMap: Map<String, SupportedTypes>
    var valueMap: Map<String, Any>


    fun getFields() : Map<String, SupportedTypes>
    fun getFieldValue(key : String) : Any?
    fun getFieldType(key : SupportedTypes)
    fun getChatOutputRepresentation() : String
    fun getGUIOutputRepresentation() : Inventory
    fun display(player: Player)
}