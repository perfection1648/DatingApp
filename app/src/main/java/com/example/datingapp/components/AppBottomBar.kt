package com.example.datingapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.datingapp.navigation.MainTab

@Composable
fun AppBottomBar(
    selectedTab: MainTab,
    onTabClick: (MainTab) -> Unit
){
    NavigationBar {
        NavigationBarItem(
            selected = selectedTab == MainTab.Feed,
            onClick = {
                onTabClick(MainTab.Feed)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Лента"
                )
            },
            label = {
                Text(text = "Лента")
            }
        )

        NavigationBarItem(
            selected = selectedTab == MainTab.Matches,
            onClick = {
                onTabClick(MainTab.Matches)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Мэтчи"
                )
            },
            label = {
                Text(text = "Мэтчи")
            }
        )

        NavigationBarItem(
            selected = selectedTab == MainTab.Chat,
            onClick = {
                onTabClick(MainTab.Chat)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Чат"
                )
            },
            label = {
                Text(text = "Чат")
            }
        )

        NavigationBarItem(
            selected = selectedTab == MainTab.Profile,
            onClick = {
                onTabClick(MainTab.Profile)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Профиль"
                )
            },
            label = {
                Text(text = "Профиль")
            }
        )
    }
}