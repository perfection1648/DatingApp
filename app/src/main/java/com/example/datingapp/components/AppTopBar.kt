package com.example.datingapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    actionText: String? = null,
    onActionClick: (() -> Unit)? = null
){
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(text = title)
        },
        navigationIcon = {
          if (onBackClick != null){
              TextButton(
                  onClick = onBackClick
              ){
                  Text(text = "Назад")
              }
          }
        },
        actions = {
            if (actionText != null && onActionClick != null){
                TextButton(
                    onClick = onActionClick
                ) {
                    Text(text = actionText)
                }
            }
        }

    )
}
