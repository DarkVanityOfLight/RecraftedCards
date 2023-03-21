package com.github.recraftedcivilizations.recraftedcards

import java.util.*

abstract class Card(protected val valueMap: MutableMap<String, String>, private val owner: UUID, protected val ownerDisplayName: String) : IDisplay {
}