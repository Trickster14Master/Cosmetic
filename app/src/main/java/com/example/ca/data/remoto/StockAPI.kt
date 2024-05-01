package com.example.ca.data.remoto

import com.example.ca.data.model.brands.BrandsResult
import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.data.model.order.OrderPost
import com.example.ca.data.model.order.OrderResult
import com.example.ca.data.model.user.AuthUser
import com.example.ca.data.model.user.RegistrationUser
import com.example.ca.data.model.user.ResponseRegistrationUser
import com.example.ca.data.model.user.UserToken
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
// для того что бы написать запросы к API нужно написать интерфейс, так как библиотека Retrofit работает только с интерфейсами
interface StockAPI {
    // сначала указываем с помощью анатации тип операции, после указываем относительный url
    @GET("BrandsAPI/BrandsAPI/")
    // после чего пишем suspend (асинхронную функцию) функцию, и указываем тот тип данных который вернёт вызов функции
    suspend fun getAllBrands():Response<List<BrandsResult>>

    // сначала указываем с помощью анатации тип операции, после указываем относительный url
    @POST("PostOrder/PostOrder/")
    // после чего пишем suspend (асинхронную хункцию) функцию, и казываем тот тип данных который вернёт вызов функции,
    // и с помощью аннотации @Body указываем ту модель которую отправим на API при вызове функции
    suspend fun postOrder(@Body orderPost: OrderPost):Response<OrderPost>

    @GET("CosmeticAPI/CosmeticAPI/")
    suspend fun getAllCosmetic():Response<List<CosmeticResult>>

    @GET("CosmeticAPI/CosmeticAPI/")
    suspend fun searchCosmetic(@Query("search") searchCosmetic:String):Response<List<CosmeticResult>>

    @GET("OrderAPI/OrderAPI/")
    suspend fun getAllOrder(@Query("search") userToken:String):Response<List<OrderResult>>

    @POST("Cosmetic/auth/users/")
    suspend fun registrationUser(@Body registrationUser: RegistrationUser):Response<ResponseRegistrationUser>

    @POST("auth/token/login/")
    suspend fun authUser(@Body authUser: AuthUser):Response<UserToken>
}