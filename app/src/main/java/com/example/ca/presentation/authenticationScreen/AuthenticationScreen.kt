package com.example.ca.presentation.authenticationScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ca.R
import com.example.ca.data.model.user.AuthUser
import com.example.ca.presentation.navigation.Graph
import com.example.ca.presentation.userScreen.saveUserName
import com.example.ca.presentation.userScreen.saveUserPassword
import com.example.ca.ui.theme.GrayMain
import com.example.ca.ui.theme.MainColor
import com.example.ca.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationScreen(navController: NavController) {
    val authenticationUserViewModel= hiltViewModel<AuthenticationUserViewModel>()

    var name by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 40.dp).background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.mainimage),
                contentDescription = "Andy Rubin",
                modifier = Modifier.size(80.dp)
            )
            Row(){
                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { navController.navigate(Graph.REGISTRATION) },
                ) {
                    Text(text = "РЕГИСТРАЦИЯ", color = Color.Black)
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "ВХОД", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }
            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = name,
                onValueChange = {newText->
                    name=newText
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Логен", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = password,
                onValueChange = {newText->
                    password=newText
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    // textColor= Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Пароль", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            Button(
                colors = ButtonDefaults.buttonColors(GrayMain),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    authenticationUserViewModel.authUser(AuthUser(password, name))
                    Thread.sleep(3000)
                    saveUserName(name)
                    saveUserPassword(password)
                    navController.navigate(Graph.HOME)
                     },
                modifier = Modifier.fillMaxWidth().padding(top=30.dp)
            ) {
                Text(text = "ВХОД", color = Color.White)
            }
        }
    }
}