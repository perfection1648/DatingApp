package com.example.datingapp.repositories

class FakeAuthRepository: AuthRepository {
    private val users = mutableMapOf<String, String>()

    private var currentUserEmail: String? = null

    init {
        users["test@test.com"] = "123456"
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
        name: String,
        email: String,
        password: String
    ): Boolean {
        if (email.isBlank() || password.isBlank() || name.isBlank()) {
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