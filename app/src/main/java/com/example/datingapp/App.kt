package com.example.datingapp

import androidx.compose.runtime.Composable
import com.example.datingapp.screens.LoginScreen
import com.example.datingapp.ui.theme.DatingAppTheme

@Composable
fun DatingApp(){
    DatingAppTheme {
        LoginScreen()
    }
}
