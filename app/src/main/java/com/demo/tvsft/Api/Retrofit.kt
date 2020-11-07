package com.demo.tvsft.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *      Created on 11/7/2020
 **/


class Retrofit() {
    private val BASE_URL="http://sd2-hiring.herokuapp.com/";
   public val apiService:ApiService;



    init {


        apiService =
                Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(ApiService:: class.java)
    }
}
