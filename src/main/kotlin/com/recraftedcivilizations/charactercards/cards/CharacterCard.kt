package com.recraftedcivilizations.charactercards.cards

/**
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class CharacterCard : Card {
    val owner: Player


    /**
     * @param fieldMap A map with all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(fieldMap: Map<String, SupportedTypes>, valueMap: Map<String, Any>, player: Player) : super(fieldMap, valueMap) {
        this.owner = player
    }

    /**
     * @param fieldMap A map with all fields the card should have
     */
    constructor(fieldMap: Map<String, SupportedTypes>, player: Player) : super(fieldMap){
        this.owner = player
    }

    /**
     * @return Returns the output representation for the Card as String
     */
    override fun getChatOutputRepresentation(): String {
        var resultString = ChatColor.translateAlternateColorCodes('&',"&b========Character Card========\n")
        for(key in fieldMap.keys){
            resultString += if(valueMap[key] == null){
                ChatColor.GREEN.toString()  + "$key: Unknown\n"
            }else{
                ChatColor.GREEN.toString() + "$key: ${valueMap[key].toString()}\n"
            }
        }
        resultString += "&b=============================="
        return resultString
    }

    /**
     * @return Returns the output representation for the Card as an Inventory GUI
     */
    override fun getGUIOutputRepresentation(): Inventory {
        TODO("Not yet implemented")
    }

    /**
     * @param player The player the Card should be displayed to
     */
    override fun display(player: Player) {
        TODO("Not yet implemented")
    }
}