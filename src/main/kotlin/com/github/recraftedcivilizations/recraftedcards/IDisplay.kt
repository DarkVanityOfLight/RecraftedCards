package com.github.recraftedcivilizations.recraftedcards

import org.bukkit.entity.Player

interface IDisplay {
    fun display(to: Player): Unit
}