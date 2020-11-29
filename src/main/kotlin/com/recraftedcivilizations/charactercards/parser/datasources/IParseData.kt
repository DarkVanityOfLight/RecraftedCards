package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import org.bukkit.entity.Player

/**
 * A data source which can read and write cards
 * @author DarkVanityOfLight
 */
interface IParseData {

    /**
     * Get a card from the data source
     * @param player The Player which owns the card
     * @return returns a character card or null if none is found
     */
    fun getCard(player: Player): CharacterCard?

    /**
     * Set a card for a player
     * @param player The owner of the card
     * @param card The card to set
     */
    fun setCard(player: Player, card: Card)
}