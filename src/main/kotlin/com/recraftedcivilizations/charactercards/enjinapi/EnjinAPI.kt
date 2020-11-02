package com.recraftedcivilizations.charactercards.enjinapi

/**
 * @author DarkVanityOfLight
 */

import io.ktor.client.*
import io.ktor.client.request.*
import java.net.URL

class EnjinAPI(override val url: URL) : IProvidApplicationAccess{
    private val jsonRpc : String = "2.0"
    private val client = HttpClient()


    override suspend fun request(request: Request): Response {

        // If no jsonrpc version is defined, define it
        if(request.jsonrpc == null){
            request.jsonrpc = jsonRpc
        }

        return client.post {
            url
            body = request.serialize()
        }
    }

}