package com.recraftedcivilizations.charactercards.inapi.enjin

/**
 * Represents a request that can be send to the enjin api
 * @author DarkVanityOfLight
 */

import com.recraftedcivilizations.charactercards.inapi.WebRequest
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Request(
    val id: String, val methode: String, val params: Map<String, String>, var jsonrpc: String?,
    override var body: String,
    override var header: String
) : WebRequest() {

    override fun serialize(): String {
        return Json.encodeToString(this)
    }
}