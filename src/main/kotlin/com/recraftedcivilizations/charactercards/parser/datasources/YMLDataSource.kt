package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File


class YMLDataSource(override val dataURI: String) : IParseData {
   private val dataFile: YamlConfiguration = YamlConfiguration.loadConfiguration(File(dataURI))

    override fun getCard(player: Player, fields: List<String>): CharacterCard {
        val valueMap = mapOf<String, String?>().toMutableMap()
        val cardSection = dataFile.getConfigurationSection("cards.${player.uniqueId}") ?: return CharacterCard(fields, player)

        for (key in fields){
            valueMap[key] = cardSection.getString(key)
        }

        return CharacterCard(fields, valueMap, player)
    }

    override fun setCard(card: Card) {
        val cardSection = dataFile.createSection("cards.${card.owner.uniqueId}", card.valueMap)
        dataFile.save(File(dataURI))

    }
}