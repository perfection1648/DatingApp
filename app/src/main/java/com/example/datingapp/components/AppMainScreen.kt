package com.example.datingapp.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.datingapp.navigation.MainTab

@Composable
fun AppMainScreen(
    selectedTab: MainTab,
    onTabClick: (MainTab) -> Unit,
    content: @Composable (PaddingValues) -> Unit
    ){
    Scaffold(
        bottomBar = {
            AppBottomBar(
                selectedTab = selectedTab,
                onTabClick = onTabClick
            )
        }
    )  { innerPadding ->
        content(innerPadding)
    }
}