package com.recraftedcivilizations.charactercards.parser

import com.github.darkvanityoflight.recraftedcore.configparser.ARecraftedConfigParser
import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration


operator fun Regex.contains(text: CharSequence): Boolean = this.matches(text)

class ConfigParser(config: FileConfiguration) : ARecraftedConfigParser(config) {
    var fields: Map<String, SupportedTypes>? = null
    var defaultMode: String = "TEXT"
    var dataSource: String = "YML"

    override fun read() {
        val fieldsSection = config.getConfigurationSection("fields")
        if (fieldsSection == null) {
            CharacterCards.instance!!.severe("You didn't specify any fields for your character cards")
            Bukkit.getPluginManager().disablePlugin(CharacterCards.instance!!)
            return
        }
        fields = parseFields(fieldsSection)


        val dMode = config.getString("defaultMode")
        if(dMode != null && (dMode.toUpperCase() == "GUI" || dMode.toUpperCase() == "TEXT")){
            defaultMode = dMode
        }
        val dSource = config.getString("dataMode")
        if (dSource != null && (dSource.toUpperCase() == "YML" || dSource.toUpperCase() == "SQL")){
            dataSource = dSource.toUpperCase()
        }

    }


    private fun parseFields(configSection: ConfigurationSection): Map<String, SupportedTypes> {
        val parsedFields: MutableMap<String, SupportedTypes> = emptyMap<String, SupportedTypes>().toMutableMap()

        for (key in configSection.getKeys(false)) {
            if (configSection.getString(key) != null) {
                val type = configSection.getString(key)
                try {
                    if (type != null) parsedFields[key] = SupportedTypes.valueOf(type.toUpperCase())
                    else CharacterCards.instance?.warning("Could not parse type of field $key")
                } catch (e: IllegalArgumentException){
                    CharacterCards.instance?.warning("Type $key is not supported")
                }


            } else {
                continue
            }
        }

        return parsedFields
    }
}