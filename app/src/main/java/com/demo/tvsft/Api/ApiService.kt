package com.demo.tvsft.Api

import OutputModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/users?offset={ofset}&limit=10")
    suspend fun GetUserList(@Path("ofset") offset:Int): Response<OutputModel>

}