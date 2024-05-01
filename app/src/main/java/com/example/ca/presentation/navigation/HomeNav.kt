package com.example.ca.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.ca.presentation.navigation.elements.ListItemBottomBar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeNav() {
    val navController = rememberNavController()
    androidx.compose.material.Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = Color.Black,
        backgroundColor = Color.White,

        bottomBar = {
            BottomNavigationBar(
                item = ListItemBottomBar,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.routing)
                },
            )
        },

        ) {
        NavigationForHome(navController = navController)
    }
}
