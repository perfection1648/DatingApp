package com.example.datingapp.screens.feed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.FakeDatingRepository

class FeedStateHolder {
    private val datingRepository = FakeDatingRepository()

    var uiState by mutableStateOf(FeedUiState())
        private set

    init {
        loadProfiles()
    }

    private fun loadProfiles() {
        uiState = uiState.copy(isLoading = true)

        val profiles = datingRepository.getProfiles()

        uiState = uiState.copy(
            profiles = profiles,
            currentIndex = 0,
            isLoading = false
        )
    }

    fun onLikeClick() {
        val currentProfile = getCurrentProfile() ?: return

        val match = datingRepository.likeProfile(currentProfile.id)

        uiState = if (match != null) {
            uiState.copy(
                matchName = match.matchProfile.name,
                profiles = datingRepository.getProfiles(),
                currentIndex = 0
            )
        } else {
            uiState.copy(
                profiles = datingRepository.getProfiles(),
                currentIndex = 0
            )
        }
    }

    fun onMatchDismiss() {
        uiState = uiState.copy(matchName = null)
    }

    fun onSkipClick() {
        val currentProfile = getCurrentProfile() ?: return

        datingRepository.skipProfile(currentProfile.id)

        uiState = uiState.copy(
            profiles = datingRepository.getProfiles(),
            currentIndex = 0
        )
    }
    private fun getCurrentProfile() =  uiState.profiles.firstOrNull()
}