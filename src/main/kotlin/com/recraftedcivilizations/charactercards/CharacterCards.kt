package com.recraftedcivilizations.charactercards

import com.github.darkvanityoflight.recraftedcore.ARecraftedPlugin
import com.recraftedcivilizations.charactercards.commands.RemoveCustomField
import com.recraftedcivilizations.charactercards.commands.SetCustomField
import com.recraftedcivilizations.charactercards.commands.SetField
import com.recraftedcivilizations.charactercards.commands.ShowCard
import com.recraftedcivilizations.charactercards.parser.ConfigParser
import com.recraftedcivilizations.charactercards.parser.datasources.IParseData
import com.recraftedcivilizations.charactercards.parser.datasources.YMLDataSource

class CharacterCards : ARecraftedPlugin() {
    val configParser : ConfigParser = ConfigParser(config)
    lateinit var dataParser : IParseData

    override fun onEnable() {
        super.onEnable()
        saveDefaultConfig()
        instance = this

        configParser.read()

        dataParser = when (configParser.dataSource) {
            "YML" -> {
                YMLDataSource(this.dataFolder.absolutePath + "data.yml")
            }
            "SQL" -> {
                severe("Sql datasources are not supported yet, switching to YML")
                YMLDataSource(this.dataFolder.absolutePath + "data.yml")
            }
            else -> {
                severe("An internal error occurred while choosing the datasource, please contact your dev")
                YMLDataSource(this.dataFolder.absolutePath + "data.yml")
            }
        }

        getCommand("setField")!!.setExecutor(SetField())
        getCommand("showCard")!!.setExecutor(ShowCard(dataParser))
        getCommand("addCustomField")!!.setExecutor(SetCustomField())
        getCommand("removeCustomField")!!.setExecutor(RemoveCustomField())
    }

    companion object{
        var instance : CharacterCards? = null
    }
}