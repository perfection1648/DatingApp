package com.example.datingapp.repositories.fake

import com.example.datingapp.repositories.AuthRepository

class FakeAuthRepository: AuthRepository {
    private val users = mutableMapOf<String, String>()

    private var currentUserEmail: String? = null

    init {
        users["test@test.com"] = "Test1234"
    }

    override fun login(
        email: String,
        password: String
    ): Boolean {
        val savedPassword = users[email]

        return if (savedPassword == password) {
            currentUserEmail = email
            true
        } else {
            false
        }
    }

    override fun register(
        email: String,
        password: String
    ): Boolean {
        if (email.isBlank() || password.isBlank()) {
            return false
        }

        if (users.contains(email)) {
            return false
        }

        users[email] = password
        currentUserEmail = email

        return true
    }

    override fun logout() {
        currentUserEmail = null
    }

    override fun isLoggedIn(): Boolean {
        return currentUserEmail != null
    }
}