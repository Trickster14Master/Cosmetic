package com.example.ca.data.model.order

data class OrderPost(
    val UserToken:String,
    val Price:Int,
    val Product: List<Int>,
)