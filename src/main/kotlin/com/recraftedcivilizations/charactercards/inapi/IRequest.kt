package com.recraftedcivilizations.charactercards.inapi

/**
 * Describes a class that is a request
 * @author DarkVanityOfLight
 */

interface IRequest {

    /**
     * Serialize the object as String
     * @return Returns the object as String
     **/
    fun serialize(): String
}