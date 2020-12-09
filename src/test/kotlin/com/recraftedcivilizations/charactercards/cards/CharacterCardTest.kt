package com.recraftedcivilizations.charactercards.cards

import com.nhaarman.mockitokotlin2.*
import com.recraftedcivilizations.charactercards.utils.SupportedTypes
import org.bukkit.entity.Player
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test


import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import org.mockito.invocation.InvocationOnMock
import java.lang.Exception

fun testResultFromMock(){

}

internal class CharacterCardTest {
    private var helperSendMessageRightMessage = false
    private val testFieldMap = mapOf(Pair("toBeString", SupportedTypes.STRING), Pair("toBeInt", SupportedTypes.INT), Pair("toBeNull", SupportedTypes.STRING))
    private val testValueMap = mapOf(Pair("toBeString", "foo"), Pair("toBeInt", 3))

    @AfterEach
    fun tearDown(){
        helperSendMessageRightMessage = false
    }

    @Test
    fun getOwner() {
        val mockPlayer = mock<Player> {}

        val card = CharacterCard(testFieldMap, mockPlayer)
        assertEquals(mockPlayer, card.owner)

    }

    @Test
    fun getGUIMode() {
        val mockPlayer = mock<Player> {}

        val card = CharacterCard(testFieldMap, mockPlayer)
        assertEquals(false, card.GUIMode)
        card.GUIMode = true
        assertEquals(true, card.GUIMode)

    }

    @Test
    fun getChatOutputRepresentation() {
        val mockPlayer = mock<Player> {
        }

        val card = CharacterCard(testFieldMap, testValueMap, mockPlayer)
        val output = card.getChatOutputRepresentation()
        assertEquals("§b========Character Card========\n" +
                "§atoBeString: foo\n" +
                "§atoBeInt: 3\n" +
                "§atoBeNull: Unknown\n" +
                "§b==============================", output)
    }

    @Test
    fun displayChat() {
        val mockPlayer = mock<Player> {}

        val card = CharacterCard(testFieldMap, testValueMap, mockPlayer)
        card.GUIMode = false

        val mockPlayerToSendTo = mock<Player> {
            on { sendMessage(card.getChatOutputRepresentation()) } doAnswer { invocationOnMock: InvocationOnMock ->
                val args = invocationOnMock.arguments
                if (args[0] != getChatOutputRepresentation()){ doThrow(RuntimeException()) }
            }
        }

        card.display(mockPlayerToSendTo, "TEXT")

    }
}

