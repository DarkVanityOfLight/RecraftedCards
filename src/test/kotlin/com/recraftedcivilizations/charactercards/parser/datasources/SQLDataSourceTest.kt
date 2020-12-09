package com.recraftedcivilizations.charactercards.parser.datasources

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled

internal class SQLDataSourceTest {
    private val testFieldMap = mapOf(Pair("toBeString", SupportedTypes.STRING), Pair("toBeInt", SupportedTypes.INT), Pair("toBeNull", SupportedTypes.STRING))
    private val testValueMap = mapOf(Pair("toBeString", "foo"), Pair("toBeInt", 3))

    @BeforeEach
    fun setUp() {
        val database: Database = Database.connect("jdbc:pgsql://localhost:5432", "org.postgresql.Driver", "test", "test")
        //SchemaUtils.createMissingTablesAndColumns(CardTable)
    }

    @AfterEach
    fun tearDown() {
        val database: Database = Database.connect("jdbc:pgsql://localhost:5432", "org.postgresql.Driver", "test", "test")
        SchemaUtils.drop(CardTable)
    }

    @Disabled
    @Test
    fun getCard() {
        val dataParser: SQLDataSource = SQLDataSource("test", "test", "jdbc:pgsql://localhost:5432")

    }

    //@Disabled
    @Test
    fun setCard() {
        val dataParser: SQLDataSource = SQLDataSource("test", "test", "jdbc:pgsql://localhost:5432")
        val mockPlayer = mock<Player> {
            on{ getName() } doReturn "Foo"
        }
        val card = CharacterCard(testFieldMap, testValueMap, mockPlayer)

        dataParser.setCard(mockPlayer, card)
    }
}