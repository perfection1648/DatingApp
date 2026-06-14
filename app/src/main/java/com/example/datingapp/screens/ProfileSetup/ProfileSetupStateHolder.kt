package com.example.datingapp.screens.ProfileSetup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.models.UserProfile
import com.example.datingapp.repositories.AppRepositories
import java.util.UUID

class ProfileSetupStateHolder  {
    private val userRepository = AppRepositories.userRepository

    var uiState by mutableStateOf(ProfileSetupUiState())
        private set

    init {
        loadExistingProfile()
    }
    private fun loadExistingProfile() {
        val profile = userRepository.getCurrentUserProfile() ?: return
        uiState = uiState.copy(
            name = profile.name,
            age = profile.age.toString(),
            city = profile.city,
            about = profile.about
        )
    }
    fun onNameChange(name : String) {
        uiState = uiState.copy(
            name = name,
            errorMessage = null
        )
    }

    fun onAgeChange(age: String) {
        uiState = uiState.copy(
            age = age,
            errorMessage = null
        )
    }

    fun onCityChange(city: String) {
        uiState = uiState.copy(
            city = city,
            errorMessage = null
        )
    }
    fun onAboutChange(about: String) {
        uiState = uiState.copy(
            about = about,
            errorMessage = null
        )
    }

    fun onSaveClick() {
        if (uiState.name.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите имя")
            return
        }

        if (uiState.age.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите возраст")
            return
        }

        val ageInt = uiState.age.toIntOrNull()
        if (ageInt == null || ageInt < 18 || ageInt > 100) {
            uiState = uiState.copy(errorMessage = "Введите корректный возраст")
            return
        }

        if (uiState.city.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите город")
            return
        }

        if (uiState.about.isBlank()) {
            uiState = uiState.copy(errorMessage = "Расскажите о себе")
            return
        }

        uiState = uiState.copy(isLoading = true)

        val profile = UserProfile(
            id = UUID.randomUUID().toString(),
            name = uiState.name,
            age = ageInt,
            city = uiState.city,
            about = uiState.about
        )

        userRepository.saveCurrentUserProfile(profile)

        uiState = uiState.copy(
            isLoading = false,
            isProfileSaved = true
        )
    }
}