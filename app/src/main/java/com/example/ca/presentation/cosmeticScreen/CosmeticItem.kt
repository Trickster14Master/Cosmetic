package com.example.ca.presentation.cosmeticScreen

import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.presentation.navigation.Route
import com.example.ca.ui.theme.MainColor

@Composable
fun CosmeticItem(item: CosmeticResult,navController: NavController) {

    var count =0


    listCosmetic.forEach{
        if(it==item){
            count=count+1
        }
    }

    var expandedShape by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp),
        onClick = {
            expandedShape = !expandedShape
        },
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp, 200.dp),
                model = item.UrlsImage,
                contentDescription = null,
            )
            Text(text = item.CosmeticName, fontSize = 10.sp, maxLines = if (expandedShape==true){
                Int.MAX_VALUE
            }else{
                1
            })
            Text(text = item.CosmeticDescription, maxLines = if (expandedShape==true){
                Int.MAX_VALUE

            }else{
                1
            },
                fontSize = 10.sp
            )
            Text(
                text = item.Price.toString() +"p",
                modifier=Modifier.align(Alignment.Start),
                fontWeight = FontWeight.Bold,
            )
            if(listCosmetic.contains(item)){
                Card (
                    modifier = Modifier.fillMaxWidth().padding(top = 25.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors =  CardDefaults.cardColors(Color.Gray)
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 9.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            modifier = Modifier.size(20.dp),
                            onClick = {
                                listCosmetic.add(item)
                                navController.navigate(Route.COSMETICS)

                            },
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(containerColor  = Color.Gray),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(Icons.Filled.Add, contentDescription = "g",)
                        }

                        Button(
                            modifier = Modifier.size(20.dp),
                            onClick = {},
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(containerColor  = Color.Gray),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(text = count.toString(),modifier = Modifier.padding(0.dp), )
                        }

                        Button(
                            modifier = Modifier.size(20.dp),
                            onClick = {
                                navController.navigate(Route.COSMETICS)
                                listCosmetic.forEach{
                                    if(it==item) {
                                        var i = listCosmetic.indexOf(it)
                                        listCosmetic.removeAt(i)
                                        return@Button
                                    }
                                }

                            },
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(containerColor  = Color.Gray),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(Icons.Filled.Clear, contentDescription = "g", modifier = Modifier.padding(0.dp))
                        }
                    }
                }
            }else{
                Button(
                    colors = ButtonDefaults.buttonColors(MainColor),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        listCosmetic.add(item)
                        navController.navigate(Route.COSMETICS)
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text(modifier = Modifier
                        .fillMaxWidth(),
                        text = "Добавить в карзину",
                        color = White,
                        fontSize = 9.sp)
                }
            }
        }
    }

}