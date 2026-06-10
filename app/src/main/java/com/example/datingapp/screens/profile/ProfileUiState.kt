package com.example.datingapp.screens.profile

import com.example.datingapp.models.UserProfile

data class ProfileUiState(
    val profile: UserProfile? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoggedOut: Boolean = false
)