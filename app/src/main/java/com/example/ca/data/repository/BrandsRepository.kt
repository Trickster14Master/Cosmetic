package com.example.ca.data.repository

import com.example.ca.data.model.brands.BrandsResult
import com.example.ca.data.remoto.RemoteDataSource
import com.example.ca.util.BaseApiResponse
import com.example.ca.util.Resource
import javax.inject.Inject

class BrandsRepository @Inject constructor(private val api:RemoteDataSource):BaseApiResponse() {
    suspend fun getAllBrands():Resource<List<BrandsResult>>{
        return safeApiCall { api.getAllBrands() }
    }
}