package com.example.datingapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.datingapp.components.AppButton
import com.example.datingapp.components.AppScreen
@Composable
fun SplashScreen(
    onContinueClick: () -> Unit
){
    AppScreen(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dating App",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
            )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Найди людей рядом с собой",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
            )

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(
            text = "Продолжить",
            onClick = onContinueClick
        )
    }
}

