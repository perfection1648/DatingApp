package com.example.datingapp.screens.chat

import com.example.datingapp.models.ChatMessage
import com.example.datingapp.models.UserProfile

data class ChatUiState(
    val match: UserProfile? = null,
    val messages: List<ChatMessage> = emptyList(),
    val messageText: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
