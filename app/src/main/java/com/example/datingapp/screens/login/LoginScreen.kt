package com.example.datingapp.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen
import com.example.datingapp.components.AppTextButton
import com.example.datingapp.components.AppTextField

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    val stateHolder = remember { LoginStateHolder() }
    val state = stateHolder.uiState

    LaunchedEffect(state.isLoggedIn) {
        if (state.isLoggedIn) {
            onLoginClick()
        }
    }

    AppScreen(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Вход")

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = state.email,
            onValueChange = stateHolder :: onEmailChange,
            label = "email"
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = state.password,
            onValueChange = stateHolder :: onPasswordChange,
            label = "Пароль"
        )
        if(state.errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppButton(
            text = if (state.isLoading) "Входим..." else "Войти",
            onClick = stateHolder :: onLoginClick,
            enabled = !state.isLoading
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppTextButton(
            text = "Создать аккаунт",
            onClick = {
                onRegisterClick()
            },
            enabled = !state.isLoading
        )


    }
}