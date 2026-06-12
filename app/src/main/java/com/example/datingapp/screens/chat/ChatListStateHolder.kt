package com.example.datingapp.screens.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.FakeChatRepository
import com.example.datingapp.repositories.FakeDatingRepository

class ChatListStateHolder{
    private val chatRepository = FakeChatRepository()
    private val datingRepository = FakeDatingRepository()

    var uiState by mutableStateOf(ChatUiState())
        private set

    init {
        loadChats()
    }

    private fun loadChats() {
        uiState = uiState.copy(isLoading = true)

        val matches = datingRepository.getMatches()

        val matchesWithLastMessage = matches.map { match ->
            val messages = chatRepository.getMessages(match.id)
            val lastMessage = messages.lastOrNull()
            match.copy(
                lastMessage = lastMessage?.text,
                lastMessageTime = lastMessage?.createdAt
            )
        }

        uiState = uiState.copy(
            matches = matchesWithLastMessage,
            isLoading = false
        )
    }
}