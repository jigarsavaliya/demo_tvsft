package com.demo.tvsft.Api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *      Created on 11/7/2020
 **/


class Retrofit {
    private val BASE_URL = "http://sd2-hiring.herokuapp.com/";
    val apiService: ApiService;

    init {

        val clientBuilder = OkHttpClient.Builder()
            .addNetworkInterceptor(Interceptor {
                val original: Request = it.request();
                try {
                    val builder: Request.Builder = original.newBuilder()

                    val request: Request = builder.build()

                    return@Interceptor it.proceed(request)
                } catch (e: Throwable) {

                    return@Interceptor it.proceed(original.newBuilder().build());
                }
            })
        apiService= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
            .create(ApiService::class.java)
    }

}
