package com.example.datingapp.screens.feed

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwipeOverlay(offsetX: Float) {
    val likeAlpha = (offsetX / 300f).coerceIn(0f,1f)
    val skipAlpha = (-offsetX / 300f).coerceIn(0f,1f)

    Box(modifier = Modifier.fillMaxSize()){
        if (likeAlpha > 0.1f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .border(
                        width = 4.dp,
                        color = Color.Green.copy(alpha = likeAlpha),
                        shape = RoundedCornerShape(24.dp)
                    )
            )
            Text(
                text = "❤\uFE0F",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green.copy(alpha = likeAlpha),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(40.dp)
            )
        }

        if (skipAlpha > 0.1f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .border(
                        width = 4.dp,
                        color = Color.Red.copy(alpha = skipAlpha),
                        shape = RoundedCornerShape(24.dp)
                    )
            )
            Text(
                text = "✕",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red.copy(alpha = skipAlpha),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(40.dp)
            )
        }
    }
}