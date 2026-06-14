package com.example.datingapp.utils

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    return emailRegex.matches(email.trim())
}

fun getPasswordError(password: String): String? {
    if (password.length < 8) return "Пароль должен содержать минимум 8 символов"
    if (!password.any { it.isUpperCase() }) return "Пароль должен содержать заглавную букву"
    if (!password.any { it.isLowerCase() }) return "Пароль должен содержать строчную букву"
    if (!password.any { it.isDigit() }) return "Пароль должен содержать цифру"
    return null
}