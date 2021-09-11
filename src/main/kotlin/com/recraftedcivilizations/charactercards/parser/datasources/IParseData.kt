package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import org.bukkit.OfflinePlayer

/**
 * A data source which can read and write cards
 * @author DarkVanityOfLight
 */
interface IParseData {
    val dataURI: String
    /**
     * Get a card from the data source
     * @param player The Player which owns the card
     * @param fields A list with all required fields and the type of the field
     * @return returns a character card or null if none is found
     */
    fun getCard(player: OfflinePlayer, fields: List<String>): CharacterCard

    /**
     * Set a card for a player
     * @param card The card to set
     */
    fun setCard(card: Card)
}