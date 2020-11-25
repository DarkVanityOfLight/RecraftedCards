package com.recraftedcivilizations.charactercards

import com.github.darkvanityoflight.recraftedcore.ARecraftedPlugin
import com.github.darkvanityoflight.recraftedcore.configparser.ARecraftedConfigParser
import com.recraftedcivilizations.charactercards.parser.ConfigParser
import com.recraftedcivilizations.charactercards.parser.DataParser

class CharacterCards : ARecraftedPlugin() {
    val configParser : ConfigParser = ConfigParser(config)
    val dataParser : DataParser = DataParser()

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