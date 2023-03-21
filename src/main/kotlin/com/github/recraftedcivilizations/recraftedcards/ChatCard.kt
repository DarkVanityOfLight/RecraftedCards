package com.github.recraftedcivilizations.recraftedcards

import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.util.UUID

/**
 * A CharacterCard that can be displayed in the chat
 */
class ChatCard(valueMap: MutableMap<String, String>, owner: UUID, ownerDisplayName: String) : Card(valueMap, owner, ownerDisplayName) {

    override fun display(to: Player) {
        to.sendMessage(getChatOutputRepresentation())
    }

    /**
     * Get the Card as pretty text output
     * @return The Card in text format
     */
    private fun getChatOutputRepresentation() : String {
        var result = ChatColor.GREEN.toString() + "========${this.ownerDisplayName}========\n"

        // Iterate over the map and add each field to the output string
        this.valueMap.forEach {
            entry ->  result += ChatColor.GREEN.toString() + "${entry.key}: "+ if (entry.value == "") {"Unkown"} else {entry.value}
        }

        result += ChatColor.GREEN.toString() + "========${"=".repeat(this.ownerDisplayName.length)}========"
        return result
    }

}