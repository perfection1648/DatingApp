package com.example.datingapp.screens.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.AppRepositories

class ChatListStateHolder{
    private val chatRepository = AppRepositories.chatRepository
    private val datingRepository = AppRepositories.datingRepository

    var uiState by mutableStateOf(ChatListUiState())
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