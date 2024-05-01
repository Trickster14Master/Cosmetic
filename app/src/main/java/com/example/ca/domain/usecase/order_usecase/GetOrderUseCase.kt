package com.example.ca.domain.usecase.order_usecase

import com.example.ca.data.repository.OrderRepository
import javax.inject.Inject

class GetOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
){
    suspend fun invoke(userToken:String)=orderRepository.getOrder(userToken=userToken)
}