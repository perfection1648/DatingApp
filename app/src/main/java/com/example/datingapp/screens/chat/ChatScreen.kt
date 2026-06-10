package com.example.datingapp.screens.chat

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen
import com.example.datingapp.components.AppTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ChatScreen(
){
    var message by remember {
        mutableStateOf("")
    }

    AppScreen {

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Анна: привет")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Вы: Привет, как дела?")

        Spacer(modifier = Modifier.height(24.dp))

        AppTextField(
            value = message,
            onValueChange = {
                message = it
            },
            label = "сообщение"
        )

        Spacer(modifier = Modifier.height((8.dp)))

        AppButton(
            text = "Отправить",
            onClick = {
                println("Сообщение: $message")
                message = ""
            }
        )

    }
}