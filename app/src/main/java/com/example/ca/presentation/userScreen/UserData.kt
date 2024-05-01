package com.example.ca.presentation.userScreen

import android.content.SharedPreferences
var prefUserName:SharedPreferences?=null
var prefUserPassword:SharedPreferences?=null
var prefUserEmail:SharedPreferences?=null
var prefUserToken:SharedPreferences?=null
var prefUserSurname:SharedPreferences?=null


fun saveUserToken(res: String?){
    val editor = prefUserToken?.edit()
    editor?.putString("UserToken", res)
    editor?.apply()
}

fun saveUserSurname(res: String?){
    val editor = prefUserSurname?.edit()
    editor?.putString("UserSurname", res)
    editor?.apply()
}


fun saveUserName(res:String){
    val editor = prefUserName?.edit()
    editor?.putString("UserName", res)
    editor?.apply()
}

fun saveUserPassword(res:String){
    val editor = prefUserPassword?.edit()
    editor?.putString("UserPassword", res)
    editor?.apply()
}

fun saveUserEmail(res:String){
    val editor = prefUserEmail?.edit()
    editor?.putString("UserEmail", res)
    editor?.apply()
}