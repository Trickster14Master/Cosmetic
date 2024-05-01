package com.example.ca.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ca.presentation.cosmeticScreen.CosmeticScreen
import com.example.ca.presentation.orderScreen.OrderScreen
import com.example.ca.presentation.userScreen.UserScreen

@Composable
fun NavigationForHome (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "cosmetics_route"
    ){
        composable(route=Route.CARD){
            OrderScreen(navController=navController)
        }
        composable(route=Route.COSMETICS){
            CosmeticScreen(navController=navController)
        }
        composable(route=Route.USER){
            UserScreen(navController=navController)
        }
    }
}