package com.recraftedcivilizations.charactercards.commands

import com.recraftedcivilizations.charactercards.CharacterCards
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author DarkVanityOfLight
 * The command to set a specific field of the Character Card
 */
class SetField: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player){ sender.sendMessage("Uga buga console man!!"); return true }

        val field = args[0]
        val args = args.toMutableList()
        args.removeFirst()

        val value = args.joinToString(" ")

        val cardToModify = CharacterCards.instance!!.dataParser.getCard(sender, CharacterCards.instance!!.configParser.configFields)


        if (field !in cardToModify.configFields){ sender.sendMessage("${ChatColor.RED}There is no such field as $field in the Character Cards"); return false }

        cardToModify.setFieldValue(field, value)
        CharacterCards.instance!!.dataParser.setCard(cardToModify)

        return true
    }
}