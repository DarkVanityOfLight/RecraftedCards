package com.recraftedcivilizations.charactercards.inapi

/**
 * Represents an Web request and serialize the request to json string
 * @author DarkVanityOfLight
 */

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
abstract class WebRequest : IRequest {

    /**
     * Serialize the object as an Json String
     * @return Returns the object as an Json String
     */
    override fun serialize(): String {
        return Json.encodeToString(this)
    }

    fun tosendableRequest(): Pair<String, String> {
        return Pair(createHeader(), createBody())
    }

    internal abstract fun createHeader(): String
    internal abstract fun createBody(): String

}