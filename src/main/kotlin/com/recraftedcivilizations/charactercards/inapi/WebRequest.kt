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
    abstract override fun serialize(): String

    /**
     * @return A Pair of Strings representing Header and Body as String
     */
    fun toSendableRequest(): Pair<String, String> {
        return Pair(createHeader(), createBody())
    }

    /**
     * @return  The Header as String for this request
     * */
    internal abstract fun createHeader(): String

    /**
     * @return The body as String for this request
     */
    internal abstract fun createBody(): String

}