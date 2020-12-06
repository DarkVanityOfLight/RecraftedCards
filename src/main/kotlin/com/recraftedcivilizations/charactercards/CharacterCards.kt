package com.recraftedcivilizations.charactercards

import com.github.darkvanityoflight.recraftedcore.ARecraftedPlugin
import com.recraftedcivilizations.charactercards.parser.ConfigParser
import com.recraftedcivilizations.charactercards.parser.DataParser
import com.recraftedcivilizations.charactercards.parser.datasources.IParseData
import com.recraftedcivilizations.charactercards.parser.datasources.SQLDataSource

class CharacterCards : ARecraftedPlugin() {
    val configParser : ConfigParser = ConfigParser(config)
    val dataParser : IParseData = SQLDataSource("foo", "bar", "foobar")

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