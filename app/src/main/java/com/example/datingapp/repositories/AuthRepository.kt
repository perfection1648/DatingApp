package com.example.datingapp.repositories

interface AuthRepository {
    fun login(
        email: String,
        password: String
    ): Boolean

    fun register(
        email: String,
        password: String
    ): Boolean

    fun logout()

    fun isLoggedIn(): Boolean
}