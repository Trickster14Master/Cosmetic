package com.example.ca.data.repository

import com.example.ca.data.model.order.OrderPost
import com.example.ca.data.model.order.OrderResult
import com.example.ca.data.model.user.UserToken
import com.example.ca.data.remoto.RemoteDataSource
import com.example.ca.util.BaseApiResponse
import com.example.ca.util.Resource
import javax.inject.Inject

// Repository как правило пределяеться откуда брать данные, тобишь брать данные с удалённой базы данных или же с локальной
class OrderRepository @Inject constructor(
    private val api: RemoteDataSource
):BaseApiResponse() {
    suspend fun postOrder(body: OrderPost):Resource<OrderPost>{
        return safeApiCall { api.postOrder(body=body) }
    }

    suspend fun getOrder(userToken: String):Resource<List<OrderResult>>{
        return safeApiCall { api.getAllOrder(userToken=userToken) }
    }

}