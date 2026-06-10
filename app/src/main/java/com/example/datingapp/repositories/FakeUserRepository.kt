package com.example.datingapp.repositories

import com.example.datingapp.models.UserProfile

class FakeUserRepository : UserRepository {

    private var currentUserProfile: UserProfile? = null

    override fun getCurrentUserProfile(): UserProfile? {
       return currentUserProfile
    }

    override fun saveCurrentUserProfile(profile: UserProfile) {
        currentUserProfile = profile
    }

    override fun hasCurrentUserProfile(): Boolean {
        return currentUserProfile != null
    }

    override fun clearCurrentUserProfile() {
        currentUserProfile = null
    }
}