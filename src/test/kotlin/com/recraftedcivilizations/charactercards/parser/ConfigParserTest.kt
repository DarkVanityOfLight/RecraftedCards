package com.recraftedcivilizations.charactercards.parser


import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.configuration.file.YamlConfiguration
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

internal class ConfigParserTest {
    var configFile = File("config.yml")

    @BeforeEach
    fun setUp() {
        val fields = mapOf(Pair("Foo", "STRING"))
        val yamlConfiguration = YamlConfiguration()
        yamlConfiguration.createSection("fields", fields)
        yamlConfiguration.save(configFile)


    }

    @AfterEach
    fun tearDown() {
        configFile.delete()
    }

    @Test
    fun modifyFields() {
        val config = YamlConfiguration()
        config.load(configFile)

        val parser = ConfigParser(config)
        parser.fields = null

        assertEquals(null, parser.fields)
    }

    @Test
    fun read() {
        val config = YamlConfiguration()
        config.load(configFile)

        val parser = ConfigParser(config)
        parser.read()

        assertEquals(mapOf(Pair("Foo", SupportedTypes.STRING)), parser.fields)

    }

    @Test
    fun readNull(){
        configFile.delete()
        val config = YamlConfiguration()
        config.createSection("Foo", mapOf(Pair("Bar", "foo")))

        val parser = ConfigParser(config)
        parser.read()

        assertEquals(null, parser.fields)

    }
}