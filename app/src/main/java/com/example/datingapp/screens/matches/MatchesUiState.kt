package com.example.datingapp.screens.matches

import com.example.datingapp.models.UserProfile

data class MatchesUiState(
    val matches: List<UserProfile> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String ?= null
)