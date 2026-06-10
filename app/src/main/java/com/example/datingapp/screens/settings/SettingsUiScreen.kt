package com.example.datingapp.screens.settings

data class SettingsUiScreen(
    val notificationsEnabled: Boolean = true,
    val appVersion: String = "1.0.0",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoggedOut: Boolean = false
)