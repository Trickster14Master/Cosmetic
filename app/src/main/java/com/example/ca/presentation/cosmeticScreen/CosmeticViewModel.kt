package com.example.ca.presentation.cosmeticScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca.data.model.brands.BrandsResult
import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.domain.usecase.brands_usecase.GetAllBrandsUseCase
import com.example.ca.domain.usecase.cosmetic_usecase.GetAllCosmeticUseCase
import com.example.ca.domain.usecase.cosmetic_usecase.SearchCosmetic
import com.example.ca.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CosmeticViewModel @Inject constructor(
    // получаем зависимости от UseCase
    private val getAllCosmeticUseCase: GetAllCosmeticUseCase,
    private val getAllBrandsUseCase: GetAllBrandsUseCase,
    private val searchCosmetic: SearchCosmetic
):ViewModel(){
    // переменная _productResponse будет хранить данные внутри ViewModel, а productResponse будет предоставлять данные уже на экране
    private val _cosmeticResponse = MutableLiveData<Resource<List<CosmeticResult>>>()
    val cosmeticResponse:LiveData<Resource<List<CosmeticResult>>>
        get() = _cosmeticResponse

    private val _brandsResponse = MutableLiveData<Resource<List<BrandsResult>>>()
    val brandsResponse:LiveData<Resource<List<BrandsResult>>>
        get() = _brandsResponse


    // тут указывается какая функция будет вызвана при инициализации ViewModel
    init {
        getCosmetic()
        getBrands()
    }

    // функция по получению всех напитков
    fun getCosmetic(){
        // с помощью viewModelScope создаём отдельный поток
        viewModelScope.launch {
            // вызываем функцию из UseCase
            getAllCosmeticUseCase.invoke().let {
                // присваиваем пришедшее значение в переменную
                _cosmeticResponse.value=it
            }
        }
    }

    fun getBrands(){
        viewModelScope.launch {
            getAllBrandsUseCase.invoke().let{
                _brandsResponse.value=it
            }
        }
    }

    fun searchCosmetic(body:String){
        viewModelScope.launch {
            searchCosmetic.invoke(body).let{
                _cosmeticResponse.value=it
            }
        }
    }


}