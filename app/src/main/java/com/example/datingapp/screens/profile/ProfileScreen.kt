package com.example.datingapp.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datingapp.components.BaseScreen

@Composable
fun ProfileScreen(
    onEditProfileClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val stateHolder = remember { ProfileStateHolder() }
    val uiState = stateHolder.uiState

    BaseScreen {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Мой профиль",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Row {
                IconButton(onClick = onEditProfileClick) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Редактировать профиль"
                    )
                }
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Настройки"
                    )
                }
            }
        }

        when {
            uiState.isLoading -> {
                Text(
                    text = "Загрузка...",
                    modifier = Modifier.padding(16.dp)
                )
            }

            uiState.profile != null -> {
                val profile = uiState.profile

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Фото",
                            color = Color.Gray,
                            fontSize = 18.sp
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "${profile.name}, ${profile.age}",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = profile.city,
                        fontSize = 18.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = profile.about,
                        fontSize = 15.sp,
                        color = Color.DarkGray,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            else -> {
                Text(
                    text = "Профиль не заполнен",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}