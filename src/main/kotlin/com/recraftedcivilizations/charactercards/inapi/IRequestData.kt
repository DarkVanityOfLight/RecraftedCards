package com.recraftedcivilizations.charactercards.inapi


/**
 * Represents an object that can request data
 * @author DarkVanityOfLight
 */


interface IRequestData {

    /**
     * Send an request to the defined url
     * @param request The Request object to be sent
     * @return An Response object containing the info
     */
    suspend fun request(request: Request): Response
}