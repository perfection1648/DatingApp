package com.example.datingapp.screens.chat


import com.example.datingapp.models.Match

data class ChatListUiState(
    val matches: List<Match> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
