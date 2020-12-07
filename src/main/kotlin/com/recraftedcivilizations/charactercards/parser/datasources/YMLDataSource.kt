package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

class YMLDataSource(override val dataURI: String) : IParseData {
   private val dataFile: YamlConfiguration

    init {
        dataFile = YamlConfiguration.loadConfiguration(File(dataURI))
    }

    override fun getCard(player: Player, fieldMap: Map<String, SupportedTypes>): CharacterCard? {
        TODO("Not yet implemented")
    }

    override fun setCard(player: Player, card: Card) {
        val cardSection = dataFile.createSection("cards.${player.name}", card.valueMap)
        dataFile.save(File(dataURI))

    }
}