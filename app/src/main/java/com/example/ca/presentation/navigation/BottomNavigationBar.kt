package com.example.ca.presentation.navigation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ca.presentation.navigation.elements.BottomNavItem
import com.example.ca.ui.theme.MainColor


@Composable
fun BottomNavigationBar(
    item:List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier= Modifier,
    onItemClick:(BottomNavItem)->Unit
){
    val backStackEntry=navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ){
        item.forEach{item->
            val selected = item.routing==backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {onItemClick(item)},
                selectedContentColor = MainColor,
                unselectedContentColor = Color.Black,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ){
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    }
}