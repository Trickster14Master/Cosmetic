package com.example.ca.presentation.registrationScreen

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ca.R
import com.example.ca.data.model.user.RegistrationUser
import com.example.ca.presentation.navigation.Graph
import com.example.ca.presentation.userScreen.saveUserEmail
import com.example.ca.presentation.userScreen.saveUserName
import com.example.ca.presentation.userScreen.saveUserPassword
import com.example.ca.presentation.userScreen.saveUserSurname
import com.example.ca.ui.theme.GrayMain
import com.example.ca.ui.theme.MainColor
import com.example.ca.ui.theme.SecondaryColor
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController){
    val registrationViewModel= hiltViewModel<RegistrationViewModel>()

    var name by remember {
        mutableStateOf("")
    }

    var surname by remember {
        mutableStateOf("")
    }

    var e_mail by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var password2 by remember {
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
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "РЕГИСТРАЦИЯ", color = Color.Black, fontWeight = FontWeight.Bold)
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { navController.navigate(Graph.AUTHENTICATION) },
                ) {
                    Text(text = "ВХОД", color = Color.Black)
                }
            }

            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = name,
                onValueChange = {newText->
                    name=newText
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Имя", color = MainColor, fontSize=10.sp, modifier = Modifier.background(Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = surname,
                onValueChange = {newText->
                    surname=newText
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Фамилия", color = MainColor, fontSize=10.sp, modifier = Modifier.background(Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = e_mail,
                onValueChange = {newText->
                    e_mail=newText
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "E-mail", color = MainColor, fontSize=10.sp, modifier = Modifier.background(Color.Transparent))},
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
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Пароль", color = MainColor, fontSize=10.sp, modifier = Modifier.background(Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp),
                value = password2,
                onValueChange = {newText->
                    password2=newText
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Подтвердите пароль", color = MainColor, fontSize=10.sp, modifier = Modifier.background(Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            Button(
                colors = ButtonDefaults.buttonColors(GrayMain),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    registrationViewModel.registration(RegistrationUser(e_mail, name,password))
                    saveUserSurname(surname)
                    saveUserSurname(name)
                    saveUserPassword(password)
                    saveUserEmail(e_mail)
                    navController.navigate(Graph.AUTHENTICATION)
                },
                modifier = Modifier.fillMaxWidth().padding(top=30.dp)
            ) {
                Text(text = "РЕГИСТРАЦИЯ", color = Color.White)
            }
        }
    }
}