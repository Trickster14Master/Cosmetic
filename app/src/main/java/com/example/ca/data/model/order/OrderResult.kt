package com.example.ca.data.model.order

import com.example.ca.data.model.cosmetic.CosmeticResult


data class OrderResult(
    val UserToken:String="",
    val Date:String="",
    val Product:List<CosmeticResult>,
    val Price:Int=0,
)