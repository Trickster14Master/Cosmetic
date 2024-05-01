package com.example.ca.domain.usecase.order_usecase

import com.example.ca.data.model.order.OrderPost
import com.example.ca.data.repository.OrderRepository
import javax.inject.Inject

class PostOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend fun invoke(body: OrderPost)=orderRepository.postOrder(body=body)
}