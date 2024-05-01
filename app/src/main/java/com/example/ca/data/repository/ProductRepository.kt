package com.example.ca.data.repository

import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.data.remoto.RemoteDataSource
import com.example.ca.util.BaseApiResponse
import com.example.ca.util.Resource
import javax.inject.Inject

class CosmeticRepository @Inject constructor(private val api : RemoteDataSource):BaseApiResponse() {
    suspend fun getAllCosmetic():Resource<List<CosmeticResult>>{
        return safeApiCall { api.getAllCosmetic() }
    }

    suspend fun searchCosmetic(body:String):Resource<List<CosmeticResult>>{
        return safeApiCall { api.searchCosmetic(body = body) }
    }

}