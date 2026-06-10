package com.example.datingapp.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen
import com.example.datingapp.components.AppTextField

@Composable
fun ProfileSetupScreen(
    onBackClick: () -> Unit
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = onBackClick
            ){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Назад"
                )
            }

            Text(text = "Настройка профиля")
        }

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

        AppButton(
            text = "Сохранить",
            onClick = {
                println("Имя : $name")
                println("Возраст: $age")
                println("О себе: $about")
                onBackClick()
            }
        )


    }
}