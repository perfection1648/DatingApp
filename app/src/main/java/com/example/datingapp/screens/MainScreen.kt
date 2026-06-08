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
import com.example.datingapp.navigation.MainTab
@Composable
fun MainScreen(){
    var selectedTab by remember {
        mutableStateOf(MainTab.Feed)
    }

    AppMainScreen(
        selectedTab = selectedTab,
        onTabClick = {
            tab -> selectedTab = tab
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            when(selectedTab){
                MainTab.Feed -> {
                    FeedScreen(
                        onMatchesClick = {
                            selectedTab = MainTab.Matches
                        },
                        onProfileClick = {
                            selectedTab = MainTab.Profile
                        }
                    )
                }

                MainTab.Matches -> {
                    MatchesScreen(
                        onChatClick = {
                            selectedTab = MainTab.Chat
                        }
                    )
                }

                MainTab.Chat -> {
                    ChatScreen()
                }

                MainTab.Profile -> {
                    ProfileScreen()
                }

                MainTab.ProfileSetup -> {
                    ProfileSetupScreen()
                }
            }
        }

    }
}