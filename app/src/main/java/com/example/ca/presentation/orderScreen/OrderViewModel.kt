package com.example.ca.presentation.orderScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca.data.model.order.Order
import com.example.ca.data.model.order.OrderPost
import com.example.ca.data.model.order.OrderResult
import com.example.ca.domain.usecase.order_usecase.GetOrderUseCase
import com.example.ca.domain.usecase.order_usecase.PostOrderUseCase
import com.example.ca.presentation.cosmeticScreen.listCosmetic
import com.example.ca.presentation.userScreen.prefUserToken
import com.example.ca.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val postOrderUseCase: PostOrderUseCase,
    private val getOrderUseCase: GetOrderUseCase,
):ViewModel() {
    private val _OrderUserResponse = MutableLiveData<Resource<List<OrderResult>>>()
    val orderUserResponse:LiveData<Resource<List<OrderResult>>>
        get() = _OrderUserResponse

    init {
        getOrder()
    }


    fun postOrder(body:OrderPost){
        viewModelScope.launch {
            postOrderUseCase.invoke(body = body)
            listCosmetic.clear()
        }
    }

    fun getOrder(){
        viewModelScope.launch {
            var tok = prefUserToken?.getString("UserToken","пусто")
            getOrderUseCase.invoke(tok.toString()).let {
                _OrderUserResponse.value=it
            }
        }
    }
}