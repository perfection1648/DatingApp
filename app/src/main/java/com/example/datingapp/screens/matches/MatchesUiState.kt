package com.example.datingapp.screens.matches

import com.example.datingapp.models.Match

data class MatchesUiState(
    val matches: List<Match> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String ?= null
)