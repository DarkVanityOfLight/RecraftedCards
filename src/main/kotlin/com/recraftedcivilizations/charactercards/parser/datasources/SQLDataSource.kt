package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.parser.ConfigParser
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object CardTable: Table(){
    val player: Column<String> = varchar("player", 100)

}

class SQLDataSource(private val password: String, private val username: String) : IParseData {
    private val database: Database =
        Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = username, password = password)

    private fun getFieldsFromDB(fieldMap: Map<String, SupportedTypes>, playerName: String): Map<String, Any>{
        val valueMap = emptyMap<String, Any>().toMutableMap()
        transaction(database){
            exec("select * from CardTable where exists (Select * from CardTable where player = '${playerName}')"){rs ->
                for (field in fieldMap.keys){
                    valueMap[field] = rs.getString(field)
                }
            }
        }
        return valueMap
    }

    override fun getCard(player: Player): CharacterCard {
        TODO("Not yet implemented")
    }

    override fun setCard(player: Player, card: Card) {
        TODO("Not yet implemented")
    }
}