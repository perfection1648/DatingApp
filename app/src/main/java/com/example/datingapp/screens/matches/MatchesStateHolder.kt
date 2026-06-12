package com.example.datingapp.screens.matches

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.FakeDatingRepository

class MatchesStateHolder {
    private val datingRepository = FakeDatingRepository()

    var uiState by mutableStateOf(MatchesUiState())
        private set

    init {
        loadMatches()
    }

    private fun loadMatches() {
        uiState = uiState.copy(isLoading = true)

        val matches = datingRepository.getMatches()

        uiState = uiState.copy(
            matches = matches,
            isLoading = false
        )
    }
}