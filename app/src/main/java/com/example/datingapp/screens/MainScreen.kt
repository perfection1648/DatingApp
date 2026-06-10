package com.example.datingapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.datingapp.components.AppMainScreen
import com.example.datingapp.navigation.MainDestination
import com.example.datingapp.navigation.MainTab
@Composable
fun MainScreen(){
    var currentDestination by remember {
        mutableStateOf(MainDestination.Profile)
    }

    val selectedTab = when (currentDestination) {
        MainDestination.Feed -> MainTab.Feed
        MainDestination.Matches -> MainTab.Matches
        MainDestination.Chat -> MainTab.Chat
        MainDestination.Profile -> MainTab.Profile

        MainDestination.ProfileSetup -> MainTab.Profile
        MainDestination.Settings -> MainTab.Profile
    }

    AppMainScreen(
        selectedTab = selectedTab,
        onTabClick = {
            tab -> currentDestination = when(tab) {
                MainTab.Feed -> MainDestination.Feed
                MainTab.Matches -> MainDestination.Matches
                MainTab.Chat -> MainDestination.Chat
                MainTab.Profile -> MainDestination.Profile
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            when(currentDestination){
                MainDestination.Feed -> {
                    FeedScreen(
                        onMatchesClick = {
                            currentDestination = MainDestination.Matches
                        },
                        onProfileClick = {
                            currentDestination = MainDestination.Profile
                        }
                    )
                }

                MainDestination.Matches -> {
                    MatchesScreen(
                        onChatClick = {
                            currentDestination = MainDestination.Chat
                        }
                    )
                }

                MainDestination.Chat -> {
                    ChatScreen()
                }

                MainDestination.Profile -> {
                    ProfileScreen(
                        onEditProfileClick = {
                            currentDestination = MainDestination.ProfileSetup
                        },
                        onSettingsClick = {
                            currentDestination = MainDestination.Settings
                        }
                    )
                }

                MainDestination.ProfileSetup -> {
                    ProfileSetupScreen(
                        onBackClick = {
                            currentDestination = MainDestination.Profile
                        }
                    )
                }

                MainDestination.Settings -> {
                    SettingsScreen(
                        onBackClick = {
                            currentDestination = MainDestination.Profile
                        }
                    )
                }
            }
        }

    }
}