package com.example.ca.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ca.presentation.authenticationScreen.AuthenticationScreen
import com.example.ca.presentation.registrationScreen.RegistrationScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION
    ) {
        // composable отвечает за то чтобы перейти на экран если в composable был передан url адрес
        composable(route= Graph.REGISTRATION){
            RegistrationScreen(navController=navController)
        }
        composable(route= Graph.AUTHENTICATION){
            AuthenticationScreen(navController=navController)
        }
        composable(route = Graph.HOME) {
            HomeNav()
        }
    }
}

object Graph {
    const val REGISTRATION = "registration_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}