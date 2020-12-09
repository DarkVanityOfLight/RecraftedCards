package com.recraftedcivilizations.charactercards.inapi

/**
 * Represent a response retrieved by an api
 * @author DarkVanityOfLight
 */

interface IResponse {
    val body: String
    val header: String

    /**
     * Deserialize to an other object
     * @return
     */
    fun deserialize() : Any
}