package com.example.datingapp.screens.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun RegisterScreen(
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit
){
    val stateHolder = remember { RegisterStateHolder() }
    val uiState = stateHolder.uiState

    LaunchedEffect(uiState.isRegistered) {
        if (uiState.isRegistered) {
            onRegisterClick()
        }
    }
    AppScreen (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Регистрация")

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = uiState.email,
            onValueChange = stateHolder :: onEmailChange,
            label = "Email"
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = uiState.password,
            onValueChange = stateHolder :: onPasswordChange,
            label = "Пароль"
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            value = uiState.repeatPassword,
            onValueChange = stateHolder :: onRepeatPasswordChange,
            label = "Повторите пароль"
        )

        if (uiState.errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = uiState.errorMessage!!)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppButton(
            text = "Зарегистрироваться",
            onClick = stateHolder :: onRegisterClick,
            enabled = !uiState.isLoading
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppTextButton(
            text = "Уже есть аккаунт?Войти",
            onClick = onBackClick
        )
    }
}