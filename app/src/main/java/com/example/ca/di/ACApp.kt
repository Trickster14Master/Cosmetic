package com.example.ca.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
// данный класс показывает библиотеке для инъекции и зависимости где взять контекст приложения
class Cosmetic:Application()