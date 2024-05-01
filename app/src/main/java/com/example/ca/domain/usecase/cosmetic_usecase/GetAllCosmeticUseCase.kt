package com.example.ca.domain.usecase.cosmetic_usecase

import com.example.ca.data.repository.CosmeticRepository
import javax.inject.Inject
// UseCase который получает всю косметику
class GetAllCosmeticUseCase @Inject constructor(
    // получаем экземпляр класса репозитория благодаря инъекции зависимостей
    private val cosmeticRepository: CosmeticRepository
){
    // функция которая возвращает всю косметику
    suspend fun invoke()=cosmeticRepository.getAllCosmetic()
}

class SearchCosmetic @Inject constructor(
    // получаем экземпляр класса репозитория благодаря инъекции зависимостей
    private val cosmeticRepository: CosmeticRepository
){
    // функция которая возвращает всю косметику
    suspend fun invoke(body:String)=cosmeticRepository.searchCosmetic(body = body)
}