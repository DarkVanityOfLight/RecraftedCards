package com.recraftedcivilizations.charactercards.parser.datasources

import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.cards.CharacterCard
import org.bukkit.entity.Player

interface IParseData {

    fun getCard(player: Player): CharacterCard?
    fun setCard(player: Player, card: Card)
}