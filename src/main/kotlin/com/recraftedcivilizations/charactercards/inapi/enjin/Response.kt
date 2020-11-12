package com.recraftedcivilizations.charactercards.inapi.enjin

/**
 * Represents an Api Response
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.inapi.IResponse
import kotlinx.serialization.Serializable

@Serializable
open class Response(open val id: String, override val body: String, override val header: String) : IResponse{
    override fun deserialize(): Any {
        return Unit
    }

}