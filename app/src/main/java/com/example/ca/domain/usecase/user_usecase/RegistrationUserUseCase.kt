package com.example.ca.domain.usecase.user_usecase

import com.example.ca.data.model.user.RegistrationUser
import com.example.ca.data.repository.UserRepository
import javax.inject.Inject

class RegistrationUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user:RegistrationUser)=userRepository.registrationUser(user=user)
}