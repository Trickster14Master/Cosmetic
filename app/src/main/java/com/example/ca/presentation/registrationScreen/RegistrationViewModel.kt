package com.example.ca.presentation.registrationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca.data.model.user.RegistrationUser
import com.example.ca.domain.usecase.user_usecase.RegistrationUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationUserUseCase: RegistrationUserUseCase
): ViewModel(){

    fun registration(user: RegistrationUser){
        viewModelScope.launch{
            registrationUserUseCase.invoke(user = user).let {
            }
        }
    }
}