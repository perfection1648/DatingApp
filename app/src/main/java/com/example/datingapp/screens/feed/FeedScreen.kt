package com.example.datingapp.screens.feed

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
fun FeedScreen(
    onMatchesClick: () -> Unit,
    onProfileClick: () -> Unit
){
    AppScreen {
        AppTopBar(
            title = "Лента",
            actionText = "Профиль",
            onActionClick = onProfileClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Анкета")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Мария, 24")
        Text(text = "Любит путешествия, музыку и кофе")

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(
            text = "лайк",
            onClick = {
                println("лайк")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppButton(
            text = "Пропустить",
            onClick = {
                println("Пропустить")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            text = "Мэтчи",
            onClick = onMatchesClick
        )
    }
}