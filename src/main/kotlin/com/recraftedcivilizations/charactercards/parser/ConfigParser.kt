package com.recraftedcivilizations.charactercards.parser

import com.github.darkvanityoflight.recraftedcore.configparser.ARecraftedConfigParser
import org.bukkit.configuration.file.FileConfiguration


operator fun Regex.contains(text: CharSequence): Boolean = this.matches(text)

class ConfigParser(config: FileConfiguration) : ARecraftedConfigParser(config) {
    var fields: List<String> = emptyList()
    var defaultMode: String = "TEXT"
    var dataSource: String = "YML"

    override fun read() {
        fields = config.getStringList("fields")

        val dMode = config.getString("defaultMode")
        if (dMode != null && (dMode.toUpperCase() == "GUI" || dMode.toUpperCase() == "TEXT")) {
            defaultMode = dMode
        }

        val dSource = config.getString("dataMode")
        if (dSource != null && (dSource.toUpperCase() == "YML" || dSource.toUpperCase() == "SQL")) {
            dataSource = dSource.toUpperCase()
        }

    }
}