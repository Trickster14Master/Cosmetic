package com.example.ca.presentation.orderScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.presentation.cosmeticScreen.listCosmetic
import com.example.ca.presentation.navigation.Route

@Composable
fun OrderItem(item:CosmeticResult, navController: NavController) {

    var count =0

    listCosmetic.forEach{
        if(it==item){
            count=count+1
        }
    }

    Row {
        AsyncImage(
            model = item.UrlsImage,
            contentDescription = "im4",
            modifier = Modifier
                .size(150.dp, 200.dp),
        )
        Column(modifier=Modifier.padding(start = 10.dp, top=50.dp )) {
            Text(item.CosmeticName,fontSize = 10.sp)
            Text(item.CosmeticDescription, fontSize = 10.sp)
            Text(item.Price.toString(),modifier=Modifier.padding(vertical = 10.dp), fontWeight = FontWeight.Bold)
            Card (
                shape = RoundedCornerShape(10.dp),
            ){
                Row {
                    Button(
                        modifier = Modifier.size(20.dp),
                        onClick = {
                            listCosmetic.add(item)
                            navController.navigate(Route.CARD)
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
                            navController.navigate(Route.CARD)
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
        }
    }
}