package com.recraftedcivilizations.charactercards.parser.datasources

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.File

internal class YMLDataSourceTest {
    private val testFieldMap = mapOf(Pair("toBeString", SupportedTypes.STRING), Pair("toBeInt", SupportedTypes.INT), Pair("toBeNull", SupportedTypes.STRING))
    private val testValueMap = mapOf(Pair("toBeString", "foo"), Pair("toBeInt", 3))
    private val dataURI = "./data.yml"

    @BeforeEach
    fun setUp() {
        File(dataURI).createNewFile()
    }

    @Test
    fun getCard() {
    }

    @Test
    fun setCard() {
        val mockPlayer = mock<Player> {
            on { getName() } doReturn "Foo"
        }

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