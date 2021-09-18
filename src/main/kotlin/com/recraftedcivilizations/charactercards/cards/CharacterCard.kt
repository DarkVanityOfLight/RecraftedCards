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
     * @param configFields A list with all fields the card should have
     * @param valueMap A map with all values to initialize the card
     */
    constructor(configFields: List<String>, valueMap: Map<String, String?>, player: OfflinePlayer) : super(configFields, valueMap) {
        this.owner = player.uniqueId
    }

    /**
     * @param configFields A list with all fields the card should have
     */
    constructor(configFields: List<String>, player: OfflinePlayer) : super(configFields){
        this.owner = player.uniqueId
    }

    /**
     * @return Returns the output representation for the Card as String
     */
    override fun getChatOutputRepresentation(): String {

        // Check for permission nodes that should be mentioned
        val perms = Bukkit.getServer().getPlayer(owner)?.effectivePermissions
        val permsToDisplay = emptyMap<String, String>().toMutableMap()
        if (perms != null){
            for (permission in perms){
                if (permission.permission.startsWith("charcards.custom")){
                    val perm = permission.permission.removePrefix("charcards.custom.")
                    val splited = perm.split(".")

                    permsToDisplay[splited[0].replace("_", " ")] = splited[1].replace("_", " ")

                }
            }

        }


        var resultString = ChatColor.translateAlternateColorCodes('&',"&b========Character Card========\n")

        for (key in permsToDisplay.keys){
            resultString += "${ChatColor.GREEN}$key: ${permsToDisplay[key]}"
        }

        for(key in valueMap.keys){
            if(key in configFields){
                resultString += if(valueMap[key] == null){
                    ChatColor.GREEN.toString()  + "$key: Unknown\n"
                }else{
                    ChatColor.GREEN.toString() + "$key: ${valueMap[key]}\n"
                }
            }else{
                 if(valueMap[key] != null){
                     resultString += "${ChatColor.GREEN}$key: Unknown\n"
                }
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