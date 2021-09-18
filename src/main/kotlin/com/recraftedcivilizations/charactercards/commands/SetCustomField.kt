package com.recraftedcivilizations.charactercards.commands

import com.recraftedcivilizations.charactercards.CharacterCards
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class SetCustomField: CommandExecutor{

    /**
     * Executes the given command, returning its success.
     * <br></br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender Source of the command
     * @param command Command which was executed
     * @param label Alias of the command which was used
     * @param args Passed command arguments
     * @return true if a valid command, otherwise false
     */
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (args.size < 3){
            return false
        }

        val player = Bukkit.getPlayer(args[0])

        if (player == null){ sender.sendMessage("${ChatColor.RED}The player ${args[0]} doesn't exist"); return true }

        val cardToModify = CharacterCards.instance!!.dataParser.getCard(player as OfflinePlayer, CharacterCards.instance!!.configParser.configFields)

        //Remove the first two arguments and join the other ones together as value to add to the list
        val m = args.toMutableList()
        m.removeAt(0)
        m.removeAt(0)
        val argVal = m.joinToString()

        // If there is already smth set on the field we add our new value behind a comma
        val currentVal = cardToModify.valueMap[args[1]]
        val toSet: String = if (currentVal != null){
            "$currentVal, $argVal"
        }else{
            argVal
        }

        cardToModify.valueMap[args[1]] = toSet
        CharacterCards.instance!!.dataParser.setCard(cardToModify)

        return true

    }


}