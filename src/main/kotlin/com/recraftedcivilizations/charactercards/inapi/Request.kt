package com.recraftedcivilizations.charactercards.inapi

/**
 * Represents a request that can be send to an api
 * @author DarkVanityOfLight
 */

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Request(val id: String, val methode: String, val params: Map<String, String>, var jsonrpc: String?){

    /**
     * Serialize the object to an json object as String
     * @return Returns the object as Json String
     */
    fun serialize(): String {
        return Json.encodeToString(this)
    }
}