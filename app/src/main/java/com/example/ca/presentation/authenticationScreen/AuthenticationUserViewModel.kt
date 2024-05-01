package com.example.ca.presentation.authenticationScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca.data.model.user.AuthUser
import com.example.ca.data.model.user.UserToken
import com.example.ca.domain.usecase.user_usecase.AuthUserUserCase
import com.example.ca.presentation.userScreen.saveUserToken
import com.example.ca.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationUserViewModel @Inject constructor(
    private val authUserUserCase: AuthUserUserCase
): ViewModel()  {
    private val _userToken = MutableLiveData<Resource<UserToken>>()
    val userToken: LiveData<Resource<UserToken>>
        get() = _userToken

    fun authUser(user: AuthUser){
        viewModelScope.launch {
            authUserUserCase.invoke(user = user).let {
                Log.d("User", it.data?.auth_token ?: "gecnj")
                saveUserToken(it.data!!.auth_token )
            }
        }
    }

}