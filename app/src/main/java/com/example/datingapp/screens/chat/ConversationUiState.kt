package com.example.datingapp.screens.chat

import com.example.datingapp.models.ChatMessage
import com.example.datingapp.models.Match

data class ConversationUiState(
    val match: Match? = null,
    val messages: List<ChatMessage> = emptyList(),
    val messageText: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
    )