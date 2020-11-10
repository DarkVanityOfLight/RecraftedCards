package com.recraftedcivilizations.charactercards.inapi.enjin

/**
 * Represents a request that can be send to the enjin api
 * @author DarkVanityOfLight
 */

import com.recraftedcivilizations.charactercards.inapi.WebRequest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


data class Request(
    val id: String, val methode: String, val params: Map<String, String>, var jsonrpc: String?,
) : WebRequest() {

    override fun serialize(): String {
        return Json.encodeToString(this)
    }

    override fun createHeader(): String {
        return ""
    }

    override fun createBody(): String {
        return this.serialize()
    }
}