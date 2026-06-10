package com.example.datingapp.repositories

import com.example.datingapp.models.ChatMessage

interface ChatRepository {

    fun getMessages(matchId: String): List<ChatMessage>

    fun sendMessage(
        matchId: String,
        text: String
    ): ChatMessage

    fun clearChat(matchId: String)
}