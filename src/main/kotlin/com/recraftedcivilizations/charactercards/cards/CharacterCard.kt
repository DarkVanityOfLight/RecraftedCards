package com.recraftedcivilizations.charactercards.cards

/**
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.CharacterCards
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.util.*

class CharacterCard : Card {
    override val owner: UUID
    var GUIMode: Boolean = false


    /**
     * @param fields A list with all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(fields: List<String>, valueMap: Map<String, String?>, player: OfflinePlayer) : super(fields, valueMap) {
        this.owner = player.uniqueId
    }

    /**
     * @param fields A list with all fields the card should have
     */
    constructor(fields: List<String>, player: OfflinePlayer) : super(fields){
        this.owner = player.uniqueId
    }

    /**
     * @return Returns the output representation for the Card as String
     */
    override fun getChatOutputRepresentation(): String {

        // Check for permission nodes that should be mentioned
        val perms = Bukkit.getServer().getPlayer(owner)?.effectivePermissions
        val permsToDisplay = emptyList<String>().toMutableList()
        if (perms != null){
            for (permission in perms){
                if (permission.permission.startsWith("charcards.title.")){
                    val stripedPerm = permission.permission.removePrefix("charcards.title.").replace("_"," ")
                    permsToDisplay.add(stripedPerm)
                }
            }

        }


        var resultString = ChatColor.translateAlternateColorCodes('&',"&b========Character Card========\n")
        resultString += ChatColor.GREEN.toString() + "Title: ${permsToDisplay.joinToString(" ")}"

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