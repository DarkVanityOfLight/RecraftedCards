package com.recraftedcivilizations.charactercards.parser.datasources

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.File

internal class YMLDataSourceTest {
    private val testFieldMap = mapOf(Pair("toBeString", SupportedTypes.STRING), Pair("toBeInt", SupportedTypes.INT), Pair("toBeNull", SupportedTypes.STRING))
    private val testValueMap = mapOf(Pair("toBeString", "foo"), Pair("toBeInt", 3), Pair("toBeNull", null))
    private val dataURI = "./data.yml"
    val mockPlayer = mock<Player> {
        on { getName() } doReturn "Foo"
    }

    @BeforeEach
    fun setUp() {
        File(dataURI).createNewFile()
    }

    @Test
    fun getCard() {
        val dataFile = YamlConfiguration()
        val section = dataFile.createSection("cards.${mockPlayer.name}", testValueMap)
        dataFile.save(File(dataURI))

        val dataParser: IParseData = YMLDataSource(dataURI)
        val card = dataParser.getCard(mockPlayer, testFieldMap)
        card!!
        assertEquals(testFieldMap, card.fieldMap)
        assertEquals(testValueMap.toString(), card.valueMap.toString())
        assertEquals(mockPlayer, card.owner)
    }

    @Test
    fun setCard() {
        val card = CharacterCard(testFieldMap, testValueMap, mockPlayer)
        val dataParser: IParseData = YMLDataSource("./data.yml")

        dataParser.setCard(mockPlayer, card)

        val dataFile = YamlConfiguration.loadConfiguration(File(dataURI))
        assertEquals(dataFile.createSection("cards.${mockPlayer.name}", testValueMap),
            dataFile.getConfigurationSection("cards.${mockPlayer.name}"))
    }

    @AfterEach
    fun tearDown() {
        File(dataURI).delete()
    }
}