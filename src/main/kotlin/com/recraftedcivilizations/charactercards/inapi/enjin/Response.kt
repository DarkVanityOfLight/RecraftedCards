package com.recraftedcivilizations.charactercards.inapi.enjin

/**
 * Represents an Api Response
 * @author DarkVanityOfLight
 */


import com.recraftedcivilizations.charactercards.inapi.IResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
open class Response(open val id: String, override val body: String, override val header: String) : IResponse{
    override fun deserialize(): Any {
        return Json.decodeFromString(body)
    }

}