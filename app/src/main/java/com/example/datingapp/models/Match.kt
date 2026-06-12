package com.example.datingapp.models

data class Match(
    val id: String,
    val matchProfile: DatingProfile,
    val lastMessage: String? = null,
    val lastMessageTime: String? = null
    )