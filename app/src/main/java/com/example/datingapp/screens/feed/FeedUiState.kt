package com.example.datingapp.screens.feed

import com.example.datingapp.models.DatingProfile

data class FeedUiState(
    val profiles: List<DatingProfile> = emptyList(),
    val currentIndex: Int = 0,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val matchName: String? = null
)

