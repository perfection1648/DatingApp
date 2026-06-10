package com.example.datingapp.models

data class DatingProfile(
    val id: String,
    val name: String,
    val age: Int,
    val city: String,
    val about: String,
    val photoUrl: String? = null
)