package com.example.datingapp.screens.matches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datingapp.components.AppScreen
import androidx.compose.foundation.lazy.grid.items

@Composable
fun MatchesScreen(

    onChatClick: () -> Unit
){
    val stateHolder = remember { MatchesStateHolder() }
    val uiState = stateHolder.uiState

    AppScreen(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 2.dp,
            bottom = 16.dp
        )
    ) {

        Text(
            text = "Ваши мэтчи",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (uiState.isLoading) {
            Text(text = "Загрузка...")
        } else if (uiState.matches.isEmpty()) {
            Text(text = "Мэтчей пока нет \uD83D\uDE14")
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.matches) { match ->
                    MatchCard(
                        name = match.matchProfile.name,
                        age = match.matchProfile.age,
                        onClick = onChatClick
                    )
                }
            }
        }

    }
}