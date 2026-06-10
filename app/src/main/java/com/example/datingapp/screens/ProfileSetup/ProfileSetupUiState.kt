package com.example.datingapp.screens.ProfileSetup

data class ProfileSetupUiState(
    val name: String = "",
    val age: String = "",
    val about: String = "",
    val photoUrl: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isProfileSaved: Boolean = false
)