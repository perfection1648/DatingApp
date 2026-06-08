package com.example.datingapp.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen
import com.example.datingapp.components.AppTopBar

@Composable
fun ProfileScreen(
){
    AppScreen {
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Мой профиль")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Имя: Александр")
        Text(text = "Возраст: 25")
        Text(text = "Город: Москва")

        Spacer(modifier = Modifier.height(24.dp))

    }
}