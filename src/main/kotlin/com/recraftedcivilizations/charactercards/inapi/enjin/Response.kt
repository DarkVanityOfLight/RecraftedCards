package com.recraftedcivilizations.charactercards.inapi.enjin

/**
 * Represents an Api Response
 * @author DarkVanityOfLight
 */

import com.recraftedcivilizations.charactercards.CharacterCards
import com.recraftedcivilizations.charactercards.cards.IAmACard
import com.recraftedcivilizations.charactercards.inapi.IResponse
import com.recraftedcivilizations.charactercards.utils.queryForFields
import kotlinx.serialization.Serializable

@Serializable
data class Response(val id: String, override val body: String, override val header: String) : IResponse {
    override fun deserialize(): IAmACard {
        val fieldMap = CharacterCards.instance!!.configParser.fields!!
        //val valueMap = queryForFields(fieldMap, body)
        return Any() as IAmACard
    }
}