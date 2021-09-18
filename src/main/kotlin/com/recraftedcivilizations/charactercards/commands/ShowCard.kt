package com.recraftedcivilizations.charactercards.commands

import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.parser.datasources.IParseData
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ShowCard(private val dataParser: IParseData): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        var mode = CharacterCards.instance!!.configParser.defaultMode
        if(args.size > 1){
            mode = args[1]
        }

        return if (sender is Player){
            val player = Bukkit.getPlayer(args[0])

            if (player != null){
                val card = dataParser.getCard(player, CharacterCards.instance!!.configParser.configFields)
                card.display(sender, mode)
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