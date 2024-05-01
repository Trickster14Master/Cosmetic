package com.example.ca.util

// в данном классе будет определять успешно ли были загружены данные или же была ошибка, загрузка
// и в зависимости от того какие данные прийдут будет вызван определённый класс
sealed class Resource<T>(val data:T?=null, val message:String?=null) {

    class Success<T>(data: T?):Resource<T>(data)
    class Error<T>(message: String, data: T?=null):Resource<T>(data, message)
    class Loading<T>(val isLoading: Boolean=true):Resource<T>(null)

}