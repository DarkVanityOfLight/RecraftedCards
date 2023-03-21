package com.github.recraftedcivilizations.recraftedcards

import io.mockk.*
import org.bukkit.entity.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.UUID

class ChatCardTest{

    @Test
    fun doesDisplay(){
        val map = mapOf<String, String>(Pair("foo", "bar"), Pair("bar", "")).toMutableMap()
        val uuid: UUID = mockk()
        val card = ChatCard(map, uuid, "CoolName")

        val recvr = mockk<Player>()
        every { recvr.sendMessage(any<String>()) } just runs
        card.display(recvr)
        verify { recvr.sendMessage("§a========CoolName========\n§afoo: bar\n§abar: Unkown\n§a========================") }
    }
}