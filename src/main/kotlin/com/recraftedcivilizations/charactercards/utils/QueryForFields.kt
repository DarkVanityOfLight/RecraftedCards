package com.recraftedcivilizations.charactercards.utils

/**
 * Query for all given fields in a given text
 * @param fieldMap A map containing all searched fields and there type
 * @param text The text to query
 * @return     A Map containing all given fielfs, if theire type did not match the requested one
 *             or they couldn't be found in the text the value will be null
 */
fun queryForFields(fieldMap: Map<String, SupportedTypes>, text: String): Map<String, Any?> {
    val result: MutableMap<String, Any?> = emptyMap<String, Any>().toMutableMap()
    var text = text
    for (key in fieldMap.keys) {
        val firstOccurrence = text.indexOf(key, 0, true)

        if (firstOccurrence != -1) {
            // Extract the line
            var line : String = ""
            var endIndex = 0
            for((index, char) in text.subSequence(firstOccurrence, text.length).withIndex()){
                if (char == '\n') {
                    endIndex = index
                    break
                }else {
                    line += char
                }
            }
            if (line == "") { result[key] = null; break }
            text = text.removeRange(firstOccurrence, endIndex)
            val value = line.removePrefix(key).removePrefix(":").removeSuffix("\n").removePrefix(" ").removeSuffix(" ")
            // TODO Check for type
            result[key] = value

        }else{
            result[key] = null
        }

    }

    return result
}