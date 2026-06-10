package com.example.datingapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.datingapp.navigation.Screen
import com.example.datingapp.screens.LoginScreen
import com.example.datingapp.screens.MainScreen
import com.example.datingapp.screens.RegisterScreen
import com.example.datingapp.screens.SplashScreen
import com.example.datingapp.ui.theme.DatingAppTheme

@Composable
fun DatingApp() {
    DatingAppTheme {
        var currentScreen by remember { mutableStateOf(Screen.Splash) }

        when (currentScreen) {
            Screen.Splash -> {
                SplashScreen(
                    onContinueClick = { currentScreen = Screen.Login }
                )
            }
            Screen.Login -> {
                LoginScreen(
                    onLoginClick = { currentScreen = Screen.Main },
                    onRegisterClick = { currentScreen = Screen.Register }
                )
            }
            Screen.Register -> {
                RegisterScreen(
                    onRegisterClick = { currentScreen = Screen.Main},
                    onBackClick = { currentScreen = Screen.Login }
                )
            }
            Screen.Main -> {
                MainScreen()
            }

        }
    }
}