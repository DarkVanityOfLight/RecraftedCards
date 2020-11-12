package com.recraftedcivilizations.charactercards.inapi.enjin

import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.cards.Card
import com.recraftedcivilizations.charactercards.utils.queryForFields

data class CharacterPostResponse(override val id: String, override val body: String, override val header: String) : Response(id, body, header) {


    override fun deserialize(): Any {
        val fieldMap = CharacterCards.instance!!.configParser.fields!!
        // TODO Extract post from body
        val valueMap = queryForFields(fieldMap, body)
        // TODO Return as character card
        return Any() as Card
    }
}