package com.recraftedcivilizations.charactercards.cards

import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import java.io.Serializable

interface IAmACard : Serializable {
    var fieldMap: Map<String, SupportedTypes>
    var valueMap: Map<String, Any>


    fun getFields() : Map<String, SupportedTypes>
    fun getFieldValue(key : String) : Any?
    fun getOutputRepresentation() : Any
    fun display(player: Player)
}