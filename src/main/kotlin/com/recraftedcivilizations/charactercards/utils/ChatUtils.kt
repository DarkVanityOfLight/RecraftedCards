package com.recraftedcivilizations.charactercards.utils

import org.bukkit.entity.Player

fun sendMultiLineMessage(player: Player, message: String) {

    val messageArray = message.split("\n")

    for(m in messageArray){
        player.sendMessage(m)
    }

}