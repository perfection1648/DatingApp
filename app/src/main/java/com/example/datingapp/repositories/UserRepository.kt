package com.example.datingapp.repositories

import com.example.datingapp.models.UserProfile

interface UserRepository {

    fun getCurrentUserProfile(): UserProfile?

    fun saveCurrentUserProfile(profile: UserProfile)

    fun hasCurrentUserProfile(): Boolean

    fun clearCurrentUserProfile()
}