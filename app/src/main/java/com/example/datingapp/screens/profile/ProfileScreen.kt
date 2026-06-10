package com.example.datingapp.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppScreen
import androidx.compose.foundation.layout.PaddingValues
@Composable
fun ProfileScreen(
    onEditProfileClick: () ->Unit,
    onSettingsClick: () -> Unit
){
    AppScreen {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Мой профиль",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )

                TextButton(
                    onClick = onEditProfileClick,
                    modifier = Modifier.height(36.dp),
                    contentPadding = PaddingValues(
                        horizontal = 8.dp,
                        vertical = 0.dp
                    )
                ){
                    Text(text = "Ред.")
                }
            }
            IconButton(
                onClick = onSettingsClick
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Настройки"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Имя: Александр")
        Text(text = "Возраст: 25")
        Text(text = "Город: Москва")

        Spacer(modifier = Modifier.height(24.dp))

    }
}