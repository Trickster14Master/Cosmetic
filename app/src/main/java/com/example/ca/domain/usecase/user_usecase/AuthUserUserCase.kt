package com.example.ca.domain.usecase.user_usecase

import com.example.ca.data.model.user.AuthUser
import com.example.ca.data.repository.UserRepository
import javax.inject.Inject

class AuthUserUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user:AuthUser)=userRepository.authenticationUser(user=user)
}