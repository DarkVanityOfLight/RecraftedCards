package com.recraftedcivilizations.charactercards.commands

import com.recraftedcivilizations.charactercards.parser.DataParser
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ShowCard(private val dataParser: DataParser): CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return if (sender is Player && sender.hasPermission("cards.display")){
            val player = Bukkit.getPlayer(args[0])
            if (player != null){
                val card = dataParser.getCard(player)
                if (card != null) {
                    card.display(player, args[1])
                }else{
                    sender.sendMessage("${ChatColor.RED}This player does not have a Character Card yet")
                }
                true
            }else{
                sender.sendMessage("${ChatColor.RED}Could not find the player ${args[0]}.")
                false
            }
        }else{
            sender.sendMessage("Sry you can't do that as console, if you need this feature talk to you dev")
            false
        }
    }
}