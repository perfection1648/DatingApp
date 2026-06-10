package com.example.datingapp.screens.feed

import com.example.datingapp.models.UserProfile

data class FeedUiState(
    val profiles: List<UserProfile> = emptyList(),
    val currentIndex: Int = 0,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

