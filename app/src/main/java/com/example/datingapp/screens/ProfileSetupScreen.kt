package com.example.datingapp.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen
import com.example.datingapp.components.AppTextField

@Composable
fun ProfileSetupScreen(
){
    var name by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var about by remember {
        mutableStateOf("")
    }

    AppScreen {
        Text(text = "Настройка профиля")

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = "Имя"
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = age,
            onValueChange = {
                age = it
            },
            label = "Возраст"
        )
        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = about,
            onValueChange = {
                about = it
            },
            label = "О себе",
            singleLine = false
        )

        Spacer(modifier = Modifier.height(16.dp))


    }
}