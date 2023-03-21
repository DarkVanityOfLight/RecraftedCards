package com.github.recraftedcivilizations.recraftedcards

import java.util.*

abstract class Card(private val valueMap: MutableMap<String, String>, private val owner: UUID) : IDisplay {
}