package com.recraftedcivilizations.charactercards.inapi.enjin

/**
 * @author DarkVanityOfLight
 */

import com.recraftedcivilizations.charactercards.inapi.IProvidApplicationAccess
import com.recraftedcivilizations.charactercards.inapi.Request
import com.recraftedcivilizations.charactercards.inapi.Response
import io.ktor.client.*
import io.ktor.client.request.*
import java.net.URL

class EnjinAPI(override val url: URL) : IProvidApplicationAccess {
    private val jsonRpc : String = "2.0"
    private val client = HttpClient()


    override suspend fun request(request: Request): Response {

        // If no jsonrpc version is defined, define it
        if(request.jsonrpc == null){
            request.jsonrpc = jsonRpc
        }

        val response: Response = client.post {
            url
            body = request.serialize()
        }

        if(response.id != request.id){
            throw VerifyError("The response does not match the Request")
        }

        return response
    }

}