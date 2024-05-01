package com.example.ca.presentation.navigation.elements

import com.example.ca.R
import com.example.ca.presentation.navigation.Route

val ListItemBottomBar=listOf(
    BottomNavItem(name = "Корзина", routing = Route.CARD, icon = R.drawable.shoppingcart),
    BottomNavItem(name = "Косметика", routing = Route.COSMETICS, icon = R.drawable.mainimage),
    BottomNavItem(name = "Пользователь", routing = Route.USER, icon = R.drawable.user)
)
