package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object CardTable: Table(){
    val player: Column<String> = varchar("player", 100)

}

/**
 * Represents a sql datasource to read and write cards
 * @constructor Requires a password and an username for the database
 * @author DarkVanityOfLight
 * @property password The password for the database
 * @property username The username for the database
 */
class SQLDataSource(private val password: String, private val username: String) : IParseData {
    private val database: Database =
        Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = username, password = password)

    /**
     * Get a values according to a field map from the database
     * @param fieldMap A map with all names and their type
     * @param playerName The name of the card owner
     * @return A map with all fields and their value or null
     */
    private fun getFieldsFromDB(fieldMap: Map<String, SupportedTypes>, playerName: String): Map<String, Any?>{
        val valueMap = emptyMap<String, Any?>().toMutableMap()
        // Query database for all fields that are passed through
        transaction(database){
            exec("select * from CardTable where exists (Select * from CardTable where player = '${playerName}')"){rs ->
                for (field in fieldMap.keys){
                    valueMap[field] = rs.getString(field)
                }
            }
        }

        // Check the returned values for their type
        for (key in valueMap.keys){
            val value = valueMap[key]
            val fieldType = fieldMap[key] ?: error("Wrong specified key, internal error, contact your dev")
            if (value == ""){ valueMap[key] = null; continue }
            if (value == null){ continue }
            if(fieldType.convert(value) == null && fieldType.cast(value) == null){ valueMap[key] = null; continue }
        }
        return valueMap
    }

    /**
     * Store a value map to the database
     * @param valueMap A map with all values that should be stored
     * @param playerName The player name
     */
    private fun setFieldsInDB(valueMap: Map<String, Any?>, playerName: String){
        TODO("Not yet implemented")
    }

    override fun getCard(player: Player, fieldMap: Map<String, SupportedTypes>): CharacterCard? {
        val valueMap = getFieldsFromDB(fieldMap, player.name)
        return CharacterCard(fieldMap, valueMap, player)
    }

    override fun setCard(player: Player, card: Card) {
        val fields = card.getFields()
        setFieldsInDB(card.valueMap, player.name)
    }
}