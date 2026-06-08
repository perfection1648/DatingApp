package com.example.datingapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    AppScreen (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Регистрация")

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = "Email"
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = "Пароль"
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppButton(
            text = "Зарегистрироваться",
            onClick = onRegisterClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppTextButton(
            text = "Уже есть аккаунт?Войти",
            onClick = onBackClick
        )



    }
}