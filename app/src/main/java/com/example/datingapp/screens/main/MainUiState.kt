package com.example.datingapp.screens.main

import com.example.datingapp.navigation.MainDestination
import com.example.datingapp.navigation.MainTab

data class MainUiState(
    val currentDestination: MainDestination = MainDestination.Profile,
    val chatMatchId: String = ""
) {
    val selectedTab: MainTab
        get() = when(currentDestination) {
            MainDestination.Feed -> MainTab.Feed
            MainDestination.Matches -> MainTab.Matches

            MainDestination.Chat -> MainTab.Chat
            MainDestination.Conversation -> MainTab.Chat

            MainDestination.Profile -> MainTab.Profile

            MainDestination.ProfileSetup -> MainTab.Profile
            MainDestination.Settings -> MainTab.Profile
        }
}