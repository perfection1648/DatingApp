package com.example.datingapp.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.datingapp.components.AppMainScreen
import com.example.datingapp.navigation.MainDestination
import com.example.datingapp.navigation.MainTab
import com.example.datingapp.screens.ProfileSetup.ProfileSetupScreen
import com.example.datingapp.screens.settings.SettingsScreen
import com.example.datingapp.screens.chat.ChatScreen
import com.example.datingapp.screens.chat.ConversationScreen
import com.example.datingapp.screens.feed.FeedScreen
import com.example.datingapp.screens.matches.MatchesScreen
import com.example.datingapp.screens.profile.ProfileScreen

@Composable
fun MainScreen(
    onLogoutClick: () -> Unit
){
    var uiState by remember {
        mutableStateOf(MainUiState())
    }

    AppMainScreen(
        selectedTab = uiState.selectedTab,
        onTabClick = {
            tab -> uiState = uiState.copy(currentDestination = when(tab) {
                MainTab.Feed -> MainDestination.Feed
                MainTab.Matches -> MainDestination.Matches
                MainTab.Chat -> MainDestination.Chat
                MainTab.Profile -> MainDestination.Profile
            })
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            when(uiState.currentDestination){
                MainDestination.Feed -> {
                    FeedScreen(
                        onMatchesClick = {
                            uiState = uiState.copy(
                                currentDestination = MainDestination.Matches
                            )
                        }
                    )
                }

                MainDestination.Matches -> {
                    MatchesScreen(
                        onChatClick = {matchId ->
                            uiState = uiState.copy(
                                currentDestination =  MainDestination.Conversation,
                                chatMatchId = matchId
                            )
                        }
                    )
                }

                MainDestination.Chat -> {
                    ChatScreen(
                        onChatClick = { matchId ->
                            uiState = uiState.copy(
                                currentDestination = MainDestination.Conversation,
                                chatMatchId = matchId
                            )
                        }
                    )
                }

                MainDestination.Profile -> {
                    ProfileScreen(
                        onEditProfileClick = {
                            uiState = uiState.copy(
                                currentDestination = MainDestination.ProfileSetup
                            )
                        },
                        onSettingsClick = {
                            uiState = uiState.copy(
                                currentDestination = MainDestination.Settings
                            )
                        }
                    )
                }

                MainDestination.ProfileSetup -> {
                    ProfileSetupScreen(
                        onBackClick = {
                            uiState = uiState.copy(
                                currentDestination = MainDestination.Profile
                            )
                        }
                    )
                }

                MainDestination.Settings -> {
                    SettingsScreen(
                        onBackClick = {
                            uiState = uiState.copy(
                                currentDestination = MainDestination.Profile
                            )
                        },
                        onLogoutClick = onLogoutClick
                    )
                }

                MainDestination.Conversation -> {
                    ConversationScreen(
                        matchId = uiState.chatMatchId,
                        onBackClick = {
                            uiState = uiState.copy(
                                currentDestination = MainDestination.Chat
                            )
                        }
                    )
                }
            }
        }

    }
}