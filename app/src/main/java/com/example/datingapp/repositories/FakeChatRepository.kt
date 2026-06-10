package com.example.datingapp.repositories

import com.example.datingapp.models.ChatMessage
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FakeChatRepository : ChatRepository {
    private val messagesByMatchId = mutableMapOf<String, MutableList<ChatMessage>>(
        "match_profile_1" to mutableListOf(
            ChatMessage(
                id = "message_1",
                matchId = "match_profile_1",
                text = "Привет!",
                isMine = false,
                createdAt = "10:15"
            ),
            ChatMessage(
                id = "message_2",
                matchId = "match_profile_1",
                text = "Привет! Как дела?",
                isMine = true,
                createdAt = "10:16"
            ),
            ChatMessage(
                id = "message_3",
                matchId = "match_profile_1",
                text = "Хорошо, гуляю по городу. А ты?",
                isMine = false,
                createdAt = "10:18"
            )
        ),

        "match_profile_3" to mutableListOf(
            ChatMessage(
                id = "message_4",
                matchId = "match_profile_3",
                text = "Привет, рада мэтчу :)",
                isMine = false,
                createdAt = "12:30"
            ),
            ChatMessage(
                id = "message_5",
                matchId = "match_profile_3",
                text = "И я тоже!",
                isMine = true,
                createdAt = "12:31"
            )
        ),

        "match_profile_5" to mutableListOf(
            ChatMessage(
                id = "message_6",
                matchId = "match_profile_5",
                text = "Привет! Видела, ты тоже любишь поездки?",
                isMine = false,
                createdAt = "18:45"
            )
        )
    )

    override fun getMessages(matchId: String): List<ChatMessage> {
        return messagesByMatchId[matchId] ?: emptyList()
    }

    override fun sendMessage(
        matchId: String,
        text: String
    ): ChatMessage {
        val message = ChatMessage(
            id = "message_${System.currentTimeMillis()}",
            matchId = matchId,
            text = text,
            isMine = true,
            createdAt = getCurrentTime()

        )

        val messages = messagesByMatchId.getOrPut(matchId) {
            mutableListOf()
        }

        messages.add(message)

        return message
    }

    override fun clearChat(matchId: String) {
        messagesByMatchId[matchId]?.clear()
    }

    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("HH:mm",Locale.getDefault())
        return formatter.format(Date())
    }
}