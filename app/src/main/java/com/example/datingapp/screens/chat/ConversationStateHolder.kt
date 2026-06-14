package com.example.datingapp.screens.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.AppRepositories

class ConversationStateHolder(
    private val matchId: String
) {
    private val chatRepository = AppRepositories.chatRepository
    private val datingRepository = AppRepositories.datingRepository

    var uiState by mutableStateOf(ConversationUiState())
        private set

    init {
        loadConversation()
    }

    private fun loadConversation() {
        uiState = uiState.copy(isLoading = true)

        val match = datingRepository.getMatchById(matchId)
        val messages = chatRepository.getMessages(matchId)

        uiState = uiState.copy(
            match = match,
            messages = messages,
            isLoading = false
        )
    }

    fun onMessageTextChange(text: String) {
        uiState = uiState.copy(messageText =  text)
    }

    fun onSendClick() {
        val text = uiState.messageText.trim()
        if (text.isBlank()) return

        val newMessage = chatRepository.sendMessage(
            matchId = matchId,
            text = text
        )

        uiState = uiState.copy(
            messages = uiState.messages + newMessage,
            messageText = ""
        )
    }
}