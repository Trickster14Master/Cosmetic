package com.example.ca.presentation.orderScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.ca.data.model.order.OrderResult

@Composable
fun OrderListOrderUser(order:List<OrderResult>) {
    LazyColumn(){
        items(order){orderItems ->
            CompletedOrderItem(orderItems)
        }
    }
}