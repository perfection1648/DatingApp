package com.example.datingapp.screens.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ChatScreen(
    onChatClick: (String) -> Unit
){
    val stateHolder = remember { ChatListStateHolder()}
    val uiState = stateHolder.uiState

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Чат",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 4.dp,
                bottom = 12.dp
            )
        )

        when {
            uiState.isLoading -> {
                Text(
                    text = "Загрузка...",
                    modifier = Modifier.padding(16.dp)
                )
            }

            uiState.matches.isEmpty() -> {
                Text(
                    text = "Нет аквтивных чатов",
                    modifier = Modifier.padding(16.dp)
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ){
                    items(uiState.matches) {
                        match -> ChatListItem(
                            name = match.matchProfile.name,
                            age = match.matchProfile.age.toString(),
                            city = match.matchProfile.city,
                            lastMessage = match.lastMessage,
                            lastMessageTime = match.lastMessageTime,
                            onClick = {onChatClick(match.id)}
                        )
                    }
                }
            }
        }
    }
}