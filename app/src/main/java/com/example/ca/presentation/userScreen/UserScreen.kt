package com.example.ca.presentation.userScreen

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ca.R
import com.example.ca.data.model.user.AuthUser
import com.example.ca.presentation.navigation.Graph
import com.example.ca.ui.theme.GrayMain
import com.example.ca.ui.theme.MainColor
import com.example.ca.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(navController: NavController){
    val context = LocalContext.current
    Column(modifier= Modifier.padding(vertical = 50.dp, horizontal = 20.dp).fillMaxSize()) {
        Box(){
            Row() {
                Icon(painter = painterResource(id =  R.drawable.user_user), contentDescription = "", tint = MainColor, modifier = Modifier.size(50.dp))
                Text(text = " ВЫХОД",  modifier = Modifier.align(Alignment.Bottom))
            }
        }

        Text(text = "СМЕНИТЬ ПОЛЬЗОВАТЕЛЯ",fontWeight = FontWeight.Bold, fontSize = 15.sp,modifier = Modifier.padding(vertical = 20.dp))

        Column(
            modifier= Modifier.fillMaxSize().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            TextField(
                modifier= Modifier.padding(vertical = 3.dp).fillMaxWidth(),
                value = prefUserName?.getString("UserName","София").toString(),
                onValueChange = {
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Имя", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp).fillMaxWidth(),
                value = prefUserSurname?.getString("UserSurname","Константиновна").toString(),
                onValueChange = {
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Фамилия", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp).fillMaxWidth(),
                value = prefUserEmail?.getString("UserEmail","timchenko.2020@stud.nstu.ru").toString(),
                onValueChange = {
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "E-mail", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp).fillMaxWidth(),
                value = prefUserPassword?.getString("UserPassword","!23435").toString(),
                onValueChange = {
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Пароль", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            TextField(
                modifier= Modifier.padding(vertical = 3.dp).fillMaxWidth(),
                value = prefUserPassword?.getString("UserPassword","!23435").toString(),
                onValueChange = {
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor=Color.Black,
                    unfocusedBorderColor  = Color.Transparent,
                    focusedBorderColor= Color.Transparent,
                    containerColor = SecondaryColor,
                    cursorColor = MainColor,

                    ),
                label = { Text(text = "Подтвердить пароль", color = MainColor, fontSize=10.sp, modifier = Modifier.background(
                    Color.Transparent))},
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            Button(
                colors = ButtonDefaults.buttonColors(GrayMain),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    saveUserToken("")
                    Thread.sleep(1000)
                    obnul(context)
                },
                modifier = Modifier.fillMaxWidth().padding(top=30.dp)
            ) {
                Text(text = "Выйти", color = Color.White)
            }
        }
    }
}

fun obnul(context: Context){
    val packageManager: PackageManager = context.packageManager
    val intent: Intent = packageManager.getLaunchIntentForPackage(context.packageName)!!
    val componentName: ComponentName = intent.component!!
    val restartIntent: Intent = Intent.makeRestartActivityTask(componentName)
    context.startActivity(restartIntent)
    Runtime.getRuntime().exit(0)
}
