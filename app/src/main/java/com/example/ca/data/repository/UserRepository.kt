package com.example.ca.data.repository
import com.example.ca.data.model.user.AuthUser
import com.example.ca.data.model.user.RegistrationUser
import com.example.ca.data.model.user.ResponseRegistrationUser
import com.example.ca.data.model.user.UserToken
import com.example.ca.data.remoto.RemoteDataSource
import com.example.ca.data.remoto.StockAPI
import com.example.ca.util.BaseApiResponse
import com.example.ca.util.Resource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: RemoteDataSource
): BaseApiResponse() {
    suspend fun registrationUser(user: RegistrationUser): Resource<ResponseRegistrationUser> {
        return safeApiCall { userService.registrationUser(user) }
    }

    suspend fun authenticationUser(user: AuthUser):Resource<UserToken>{
        return safeApiCall { userService.authenticationUser(user) }
    }

}