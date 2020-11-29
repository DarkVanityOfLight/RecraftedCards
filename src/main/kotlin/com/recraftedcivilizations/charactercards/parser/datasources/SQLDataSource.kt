package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.parser.ConfigParser
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*

object CardTable: Table(){
    val player: Column<String> = varchar("valueMap", 100)

}

class SQLDataSource(private val password: String, private val username: String) : IParseData {
    private val configParser: ConfigParser
    private val database: Database

    init {
        database = Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = username, password = password)
        this.configParser = CharacterCards.instance!!.configParser
    }

    override fun getCard(player: Player): CharacterCard {
        TODO("Not yet implemented")
    }

    override fun setCard(player: Player, card: Card) {
        TODO("Not yet implemented")
    }
}