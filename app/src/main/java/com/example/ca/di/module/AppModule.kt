package com.example.ca.di.module

import com.example.ca.data.remoto.StockAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule{
    private const val BASE_URL="http://217.71.129.139:4280/"

    // функция которая будет выводить логи
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    // провайд который даст доступ к OkHttpClient
    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            // передаём функцию для выведения логов
            .addInterceptor(httpLoggingInterceptor)
            .build()

    // провайд для Retrofit
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            // применяем конвертер для json
            .addConverterFactory(GsonConverterFactory.create())
            // используем клинет okHttpClient для запросов к api
            .client(okHttpClient)
            .build()

    // привязываем ранее написанные функции к retrofit клиенту
    @Singleton
    @Provides
    fun providesPostService(retrofit: Retrofit) = retrofit.create(StockAPI::class.java)
}