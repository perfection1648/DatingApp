package com.example.datingapp.models

data class Match(
    val id: String,
    val profile: DatingProfile,
    val lastMessage: String? = null
    )