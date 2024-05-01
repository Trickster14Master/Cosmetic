package com.example.ca.presentation.cosmeticScreen

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ca.R
import com.example.ca.data.model.brands.BrandsResult
import com.example.ca.data.model.cosmetic.CosmeticResult
import com.example.ca.ui.theme.MainColor
import com.example.ca.ui.theme.SecondaryColor
import com.example.ca.util.Resource


var listCosmetic : MutableList<CosmeticResult> = arrayListOf()
var listID : MutableList<Int> = arrayListOf()

@Composable
fun CosmeticScreen(navController: NavController){
    // создаём экземпляр класса ViewModel который будет предоставлять данные и изменять интерфейс
    val cosmeticViewModel = hiltViewModel<CosmeticViewModel>()
    // тут мы создаём переменную которая будет хранить состояние в зависимости от того что находится в ViewModel
    val stateCosmetic = cosmeticViewModel.cosmeticResponse.observeAsState().value?:Resource.Loading()

    // тоже самое только для брендов
    val brandsViewModel = hiltViewModel<CosmeticViewModel>()
    val stateBrands = brandsViewModel.brandsResponse.observeAsState().value?:Resource.Loading()

    // when позволяет сравнивать внутри себя переданный объект с другим объектом
    when(stateCosmetic){
        // выводим ProductSuccessScreen если state равен Resource.Success
        is Resource.Success->{
            CosmeticScreenSuccess(stateCosmetic.data ?: listOf(), stateBrands.data?: listOf(), cosmeticViewModel)
        }

        is Resource.Error->{
            ErrScreen(stateCosmetic.message?:"Error")
        }
        is Resource.Loading->{
            LoadingScreen()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CosmeticScreenSuccess(cosmetic:List<CosmeticResult>, brands:List<BrandsResult>, viewModel:CosmeticViewModel){

    var searhe by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()){
            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = searhe,
                onValueChange = {newText->
                    searhe=newText

                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    // textColor= Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = Color.White,
                    cursorColor = MainColor,

                    ),
                leadingIcon= {
                    IconButton(onClick = { viewModel.searchCosmetic(searhe)}) {
                        Icon(Icons.Filled.Search, contentDescription = "")
                    }
                },
                label = { Text(text = "Поиск", color = Color.Black, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),

            )

        }
        Row(modifier = Modifier
            .align(Alignment.Start)
            .padding(start = 20.dp)){
            Text(text = "Бренды",fontWeight = FontWeight.Bold, fontSize = 20.sp)

        }

        Row (modifier = Modifier
            .align(Alignment.Start)
            .padding(start = 20.dp, top = 10.dp)){
            Image(
                painter = painterResource(id = R.drawable.dior),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .size(100.dp, 50.dp)
                    .padding()
            )

            Image(
                painter = painterResource(id = R.drawable.kiko),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .size(100.dp, 50.dp)
                    .padding(start = 15.dp, top = 10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.payot),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .size(100.dp, 50.dp)
                    .padding(start = 15.dp, top = 10.dp)
            )

        }

        Row (modifier = Modifier
            .align(Alignment.Start)
            .padding(start = 20.dp, top = 20.dp, bottom = 10.dp)){
           Text(text = "HOT", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = MainColor)
           Text(text = " Новинки", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        }



        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 60.dp,)
        ) {

        }
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    ){
                        items(cosmetic){items->
                            CosmeticItem(item = items)
                        }
            }
        }

    }



















@Composable
fun ErrScreen(error:String){
    Text(text = error)
}

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = MainColor
        )
    }
}