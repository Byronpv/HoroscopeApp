package com.example.horoscopeapp.data.network.model

import com.google.gson.annotations.SerializedName

data class HoroscopeResponse(
    @SerializedName("current_day") val currentDay: String,
    @SerializedName("compatibility") val compatibility: String,
    @SerializedName("lucky_time") val luckyTime: String,
    @SerializedName("lucky_number") val luckyNumber: String,
    @SerializedName("color") val color: String,
    @SerializedName("mood") val mood: String,
    @SerializedName("description") val description: String
)