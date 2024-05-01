package com.example.ca.domain.usecase.brands_usecase

import com.example.ca.data.repository.BrandsRepository
import javax.inject.Inject

class GetAllBrandsUseCase @Inject constructor(
    private val brandsRepository: BrandsRepository
) {
    suspend fun invoke()=brandsRepository.getAllBrands()
}