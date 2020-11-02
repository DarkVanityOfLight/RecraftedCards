package com.recraftedcivilizations.charactercards.inapi

/**
 * Describes a class that is a request
 * @author DarkVanityOfLight
 */

interface IRequest {
    var body: String
    var header: String

    /**
     * Serialize the object as String
     * @return Returns the object as String
     **/
    fun serialize(): String

}