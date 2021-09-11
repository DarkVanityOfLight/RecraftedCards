package com.recraftedcivilizations.charactercards.cards

/**
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class CharacterCard : Card {
    override val owner: Player
    var GUIMode: Boolean = false


    /**
     * @param fields A list with all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(fields: List<String>, valueMap: Map<String, String?>, player: Player) : super(fields, valueMap) {
        this.owner = player
    }

    /**
     * @param fields A list with all fields the card should have
     */
    constructor(fields: List<String>, player: Player) : super(fields){
        this.owner = player
    }

    /**
     * @return Returns the output representation for the Card as String
     */
    override fun getChatOutputRepresentation(): String {
        var resultString = ChatColor.translateAlternateColorCodes('&',"&b========Character Card========\n")
        for(key in fields){
            resultString += if(valueMap[key] == null){
                ChatColor.GREEN.toString()  + "$key: Unknown\n"
            }else{
                ChatColor.GREEN.toString() + "$key: ${valueMap[key]}\n"
            }
        }
        resultString += ChatColor.translateAlternateColorCodes('&',"&b==============================")
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
    override fun display(player: Player, mode: String) {
        if(GUIMode && mode.toUpperCase() == "GUI" || GUIMode && CharacterCards.instance!!.configParser.defaultMode.toUpperCase() == "GUI"){
            player.openInventory(getGUIOutputRepresentation())
        }else{
            player.sendMessage(getChatOutputRepresentation())
        }
    }
}