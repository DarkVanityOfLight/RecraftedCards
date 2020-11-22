package com.recraftedcivilizations.charactercards.commands

import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.parser.DataParser
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

/**
 * @author DarkVanityOfLight
 * The command to set a specific field of the Character Card
 */
class SetField: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        var playerName = args[0]
        if (playerName == ""){ playerName = sender.name }

        val field = args[1]
        val value = args[2]

        val player = Bukkit.getPlayer(playerName)
        if(player == null){ sender.sendMessage("${ChatColor.RED}There is no such player please try again with a valid player"); return false }

        val cardToModify = CharacterCards.instance!!.dataParser.getCard(player)
        if(cardToModify == null){ sender.sendMessage("${ChatColor.RED}This player does not have a Character card yet"); return false }

        if (sender.hasPermission("cards.modify" ) || sender == cardToModify.owner){
            // Make sure the arguments fit our needs
            // Check that the field to set is in our field map
            if(field !in cardToModify.fieldMap.keys){ sender.sendMessage("${ChatColor.RED}There is no such field in the Character Cards"); return false }
            // Check that there is a value to be set
            if (value == ""){ sender.sendMessage("${ChatColor.RED}Please specify a value to be set"); return false }


            // Get the field type to set and throw an error if the field does not exist
            val fieldToSetType = cardToModify.fieldMap[field] ?: error("Field passed check but is not in fieldMap, please contact your dev")
            when {
                fieldToSetType.convert(value) != null -> { val toSetValue = fieldToSetType.convert(value) }
                fieldToSetType.cast(value) != null -> { val toSetValue = fieldToSetType.cast(value) }
                else -> { sender.sendMessage("${ChatColor.RED}The specified value is not the same type as this field requires, you need to specify a ${fieldToSetType.name} for example ${fieldToSetType.exampleVal}"); return false }
            }

            cardToModify.setFieldValue(field, value)
            CharacterCards.instance!!.dataParser.setCard(cardToModify.owner, cardToModify)
            return true
        }else{
            sender.sendMessage("Sry console man you can't do that, if you need this feature contact your dev")
            return false
        }
    }
}