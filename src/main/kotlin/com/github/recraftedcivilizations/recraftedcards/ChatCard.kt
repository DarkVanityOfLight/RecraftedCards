package com.github.recraftedcivilizations.recraftedcards

import org.bukkit.entity.Player
import java.util.UUID

/**
 * A CharacterCard that can be displayed in the chat
 */
class ChatCard(valueMap: MutableMap<String, String>, owner: UUID) : Card(valueMap, owner) {

    override fun display(to: Player) {
        TODO("Not yet implemented")
    }

}