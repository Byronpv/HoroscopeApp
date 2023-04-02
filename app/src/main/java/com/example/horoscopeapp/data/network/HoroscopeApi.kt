package com.example.horoscopeapp.data.network

import com.example.horoscopeapp.data.network.model.HoroscopeResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface HoroscopeApi {

    @POST(".")
    suspend fun getHoroscopeApi(
        @Query("sign") sign: String,
        @Query("day") day: String
    ): Response<HoroscopeResponse>

}