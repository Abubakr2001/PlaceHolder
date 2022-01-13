package com.leo.retrofitrecyclerview.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService() {


    private val logger =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    fun retrofit(): RequestService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
        return retrofit.create(RequestService::class.java)
    }


}