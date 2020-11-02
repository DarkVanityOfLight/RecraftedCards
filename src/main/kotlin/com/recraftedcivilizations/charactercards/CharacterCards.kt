package com.recraftedcivilizations.charactercards

import com.github.darkvanityoflight.recraftedcore.ARecraftedPlugin
import com.github.darkvanityoflight.recraftedcore.configparser.ARecraftedConfigParser
import com.recraftedcivilizations.charactercards.parser.ConfigParser

class CharacterCards : ARecraftedPlugin() {
    val configParser : ConfigParser = ConfigParser(config)

    override fun onEnable() {
        super.onEnable()
        saveDefaultConfig()
        instance = this

        configParser.read()
    }

    companion object{
        var instance : CharacterCards? = null
    }
}