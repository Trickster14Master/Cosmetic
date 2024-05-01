package com.example.ca

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ca.presentation.authenticationScreen.AuthenticationScreen
import com.example.ca.presentation.cosmeticScreen.CosmeticScreen
import com.example.ca.presentation.navigation.HomeNav
import com.example.ca.presentation.navigation.RootNavigationGraph
import com.example.ca.presentation.registrationScreen.RegistrationScreen
import com.example.ca.presentation.userScreen.prefUserEmail
import com.example.ca.presentation.userScreen.prefUserName
import com.example.ca.presentation.userScreen.prefUserPassword
import com.example.ca.presentation.userScreen.prefUserSurname
import com.example.ca.presentation.userScreen.prefUserToken
import com.example.ca.ui.theme.CATheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefUserName=getSharedPreferences("UserName", Context.MODE_PRIVATE)
        prefUserPassword=getSharedPreferences("UserPassword", Context.MODE_PRIVATE)
        prefUserEmail=getSharedPreferences("UserEmail", Context.MODE_PRIVATE)
        // инициализируем переменные для кэширования токена
        prefUserToken=getSharedPreferences("UserToken", Context.MODE_PRIVATE)
        prefUserSurname=getSharedPreferences("UserSurname", Context.MODE_PRIVATE)

        setContent {
            // получаем нынешнее значение токена
            var userToken=prefUserToken?.getString("UserToken","")

            // если переменная для хранения токена окажется пустой то вызываем экран аунтификации
            if(userToken?.length==0){
                RootNavigationGraph(navController = rememberNavController())
                // если токен уже будет нести в себе значение то сразу обращаемся HomeScreen
            }else{
                HomeNav()
            }
        }
    }
}

