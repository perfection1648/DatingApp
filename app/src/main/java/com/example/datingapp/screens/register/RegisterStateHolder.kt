package com.example.datingapp.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.FakeAuthRepository

class RegisterStateHolder {
    private val authRepository =  FakeAuthRepository()

    var uiState by mutableStateOf(RegisterUiState())
        private set

    fun onEmailChange(email:String) {
        uiState = uiState.copy(
            email = email,
            errorMessage = null
        )
    }

    fun onPasswordChange(password: String) {
        uiState = uiState.copy(
            password = password,
            errorMessage = null
        )
    }

    fun onRepeatPasswordChange(repeatPassword: String) {
        uiState = uiState.copy(
            repeatPassword = repeatPassword,
            errorMessage = null
        )
    }

    fun onRegisterClick() {
        if (uiState.email.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите email")
            return
        }

        if (uiState.password.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите пароль")
            return
        }

        if (uiState.repeatPassword.isBlank()) {
            uiState = uiState.copy(errorMessage = "Повторите пароль")
            return
        }

        if (uiState.password != uiState.repeatPassword) {
            uiState = uiState.copy(errorMessage = "Пароли не совпадают")
            return
        }

        uiState = uiState.copy(
            isLoading = true,
            errorMessage = null
        )

        val success = authRepository.register(
            email = uiState.email,
            password = uiState.password
        )

        uiState = if (success) {
            uiState.copy(
                isLoading = false,
                isRegistered = true
            )
        } else {
            uiState.copy(
                isLoading =  false,
                errorMessage = "Email уже занят"
            )
        }
    }
}