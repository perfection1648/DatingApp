package com.example.datingapp.screens.ProfileSetup

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
    val stateHolder = remember { ProfileSetupStateHolder() }
    val uiState = stateHolder.uiState

    LaunchedEffect(uiState.isProfileSaved) {
        if (uiState.isProfileSaved) {
            onBackClick()
        }
    }
    AppScreen(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 4.dp,
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = onBackClick
            ){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Назад"
                )
            }

            Text(text = "Настройка профиля")
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = uiState.name,
            onValueChange = stateHolder :: onNameChange,
            label = "Имя"
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = uiState.age,
            onValueChange = stateHolder :: onAgeChange,
            label = "Возраст"
        )
        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = uiState.city,
            onValueChange = stateHolder :: onCityChange,
            label = "Город",
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = uiState.about,
            onValueChange = stateHolder :: onAboutChange,
            label = "О себе",
            singleLine = false
        )

        if (uiState.errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = uiState.errorMessage!!)
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            text = "Сохранить",
            onClick = stateHolder :: onSaveClick,
            enabled = !uiState.isLoading
        )


    }
}