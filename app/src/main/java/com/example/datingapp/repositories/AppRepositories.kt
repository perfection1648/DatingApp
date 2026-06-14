package com.example.datingapp.repositories

import com.example.datingapp.repositories.fake.FakeAuthRepository
import com.example.datingapp.repositories.fake.FakeChatRepository
import com.example.datingapp.repositories.fake.FakeDatingRepository
import com.example.datingapp.repositories.fake.FakeUserRepository

object AppRepositories {
    val userRepository: UserRepository = FakeUserRepository()
    val authRepository: AuthRepository = FakeAuthRepository()
    val datingRepository: DatingRepository = FakeDatingRepository()
    val chatRepository: ChatRepository = FakeChatRepository()
}

