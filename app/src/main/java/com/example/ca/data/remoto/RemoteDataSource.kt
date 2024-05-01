package com.example.ca.data.remoto

import com.example.ca.data.model.order.OrderPost
import com.example.ca.data.model.user.AuthUser
import com.example.ca.data.model.user.RegistrationUser
import com.example.ca.data.model.user.UserToken
import retrofit2.http.Body
import javax.inject.Inject

// в данном классе находятся функции для вызова запросов к API
// с помощью @Inject constructor() мы получаем экземпляр интерфейса с запросами к API
class RemoteDataSource @Inject constructor( private val productService:StockAPI){
    // асинхронная функция вызывающая запрос к API
    suspend fun getAllBrands()=productService.getAllBrands()
    suspend fun getAllCosmetic()=productService.getAllCosmetic()
    suspend fun getAllOrder(userToken: String)=productService.getAllOrder(userToken)
    suspend fun postOrder(body: OrderPost)=productService.postOrder(body)
    suspend fun registrationUser(body:RegistrationUser)=productService.registrationUser(body)
    suspend fun authenticationUser(body:AuthUser)=productService.authUser(body)
    suspend fun searchCosmetic(body:String)=productService.searchCosmetic(body)
}