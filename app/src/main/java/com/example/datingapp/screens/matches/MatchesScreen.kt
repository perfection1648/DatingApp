package com.example.datingapp.screens.matches

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen

@Composable
fun MatchesScreen(

    onChatClick: () -> Unit
){
    AppScreen {

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Ваши мэтчи")

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Анна, 22")

        Spacer(modifier = Modifier.height(8.dp))

        AppButton(
            text = "Открыть чат",
            onClick = onChatClick
        )
    }
}