package com.example.datingapp.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.AppRepositories
import com.example.datingapp.repositories.fake.FakeUserRepository

class ProfileStateHolder  {
    private val userRepository = AppRepositories.userRepository

    var uiState by mutableStateOf(ProfileUiState())
        private set

    init {
        loadProfile()
    }

    private fun loadProfile() {
        uiState = uiState.copy(isLoading = true)

        val profile = userRepository.getCurrentUserProfile()

        uiState = uiState.copy(
            profile = profile,
            isLoading = false
        )
    }


}