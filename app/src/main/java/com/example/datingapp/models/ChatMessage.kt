package com.example.datingapp.models

data class ChatMessage(
    val id: String,
    val matchId: String,
    val text: String,
    val isMine: Boolean,
    val createdAt: String
)