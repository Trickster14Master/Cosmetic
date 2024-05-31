package com.example.ca.presentation.orderScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ca.presentation.cosmeticScreen.listCosmetic
import com.example.ca.presentation.cosmeticScreen.listID
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.data.model.order.OrderPost
import com.example.ca.presentation.navigation.Route
import com.example.ca.presentation.userScreen.prefUserToken
import com.example.ca.ui.theme.MainColor
import com.example.ca.util.Resource


@Composable
fun OrderScreen(navController: NavController){
    val orderViewModel= hiltViewModel<OrderViewModel>()
    val userOrder = orderViewModel.orderUserResponse.observeAsState().value?: Resource.Loading()

    var prise=0
    var uniqueListCosmetic: MutableList<CosmeticResult> = arrayListOf()
    uniqueListCosmetic.addAll(listCosmetic.distinct())
    for(i in listCosmetic){
        listID.add(i.id)
        prise=prise+i.Price
    }

    Column {
        Box(Modifier.weight(1f)){
            Text("Товары в корзине", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp))

            LazyColumn(
                modifier = Modifier.padding(top = 33.dp)
            ){
                this.items(uniqueListCosmetic) { item->
                    OrderItem(item = item, navController)
                }
                item{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Итого", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(text = prise.toString()+"р",fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }
                item {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                        Card(
                            modifier=Modifier.padding(end = 20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MainColor,
                            ),
                            onClick = {
                                orderViewModel.postOrder(OrderPost(prefUserToken?.getString("UserToken","пусто").toString(), prise, listID))
                                navController.navigate(Route.OrderNotification)
                                listID.clear()
                                listCosmetic.clear()
                            }
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                                text = "К ОФОРМЛЕНИЮ",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }




        Box(Modifier.weight(1f)){
            Column {
                Text("Оформленные заказы", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp))

                LazyColumn(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                ){
                    items(userOrder.data?: listOf()) { item->
                        CompletedOrderItem(item = item)
                    }
                }
            }
        }
    }
}