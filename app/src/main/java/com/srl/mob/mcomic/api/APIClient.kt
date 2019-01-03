package com.srl.mob.mcomic.api

import com.srl.mob.mcomic.model.SingletonHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit singleton provider
 */
class APIClient private constructor(){

    companion object : SingletonHelper<Retrofit,String>({
        val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
        val authInterceptor=AuthInterceptor()
                val client = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(authInterceptor).build()
        Retrofit.Builder().baseUrl(it).addConverterFactory(GsonConverterFactory.create()).client(client).build()
    })
}