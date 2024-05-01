package com.example.ca.data.model.cosmetic

// класс для хранения данных который в дальнейшем будет заполняться данными с API
data class CosmeticResult(
    val id: Int=0,
    // поле класса которое будет заполнено названием косметики
    val CosmeticName:String="",
    // поле класса которое будет заполнено описанием
    val CosmeticDescription:String="",
    // поле класса которое будет заполнено ценником
    val Price:Int=0,
    // поле класса которое будет заполнено ссылкой на картинку
    val UrlsImage:String="",
    // поле класса которое будет определять новый ли товар
    val IsItNew:Boolean=false,
){
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$CosmeticName",
            "$CosmeticDescription",
            )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}