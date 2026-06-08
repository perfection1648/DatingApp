package com.example.datingapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Основная кнопка приложения.
 *
 * Используется для главных действий на экране:
 * вход, сохранение, подтверждение, отправка формы.
 */
@Composable
fun AppButton(
    text : String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled
    ){
        Text(text = text)
    }
}

/**
 * Второстепенная текстовая кнопка приложения.
 *
 * Используется для дополнительных действий:
 * переход к регистрации, восстановление пароля, отмена.
 */
@Composable
fun AppTextButton(
    text : String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text)
    }

}

