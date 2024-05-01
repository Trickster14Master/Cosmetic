package com.example.ca.util
import retrofit2.Response

// условный парсер котрый разберает пришедшие данные и возвращает тело запроса
abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(api:suspend ()->Response<T>):Resource<T>{
        try {
            val response = api()
            // если response не нулёвый то достаём из недо body
            if(response.isSuccessful){
                val body = response.body()
                body?.let {
                    // если всё прошло успешно то возвращаем значение
                    return Resource.Success(body)
                }?:return errorMassage("Body nuluvoe")
            }else{
                return errorMassage("${response.code()} ${response.message()}")
            }
            // возвращаем ошибку если что то пошло не по плану
        }catch (e:Exception){
            return errorMassage(e.message.toString())
        }
    }
    // отдельная функция которая будет возвращать ошибку
    private fun <T> errorMassage(e:String):Resource.Error<T> =
        Resource.Error(data = null, message = "Api Error ${e}")
}