package com.example.datingapp.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.datingapp.repositories.AppRepositories
import com.example.datingapp.utils.getPasswordError
import com.example.datingapp.utils.isValidEmail

class LoginStateHolder {
    private val authRepository = AppRepositories.authRepository

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(email: String) {
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
    fun onLoginClick() {
        if (uiState.email.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите email")
            return
        }

        if (!isValidEmail(uiState.email)) {
            uiState = uiState.copy(errorMessage = "Ввежите корректный email")
            return
        }

        if (uiState.password.isBlank()) {
            uiState = uiState.copy(errorMessage = "Введите пароль")
            return
        }

        val passwordError = getPasswordError(uiState.password)
        if (passwordError != null) {
            uiState = uiState.copy(errorMessage = passwordError)
            return
        }

        uiState = uiState.copy(
            isLoading = true,
            errorMessage = null
        )

        val success = authRepository.login(
            email = uiState.email,
            password = uiState.password
        )

        uiState = if (success) {
            uiState.copy(
                isLoading = false,
                isLoggedIn = true
            )
        }  else {
            uiState.copy(
                isLoading = false,
                errorMessage = "Неверный email или пароль"
            )
        }
    }
}