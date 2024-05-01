package com.example.ca.presentation.orderScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ca.data.model.order.OrderResult

@Composable
fun CompletedOrderItem(item:OrderResult){
    Text(text = "Дата заказа: " + item.Date.substring(0,10),fontWeight = FontWeight.Bold,)
    Text(text = "Сумма заказа: " + item.Price.toString()+"p",fontWeight = FontWeight.Bold,)
    val cosm = item.Product
    LazyRow {
        items(cosm){itemOrder->
            Column(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp, 200.dp),
                    model = itemOrder.UrlsImage,
                    contentDescription = "asd"
                )
                Text(text = itemOrder.CosmeticName, fontSize = 10.sp,)
            }
        }
    }
}