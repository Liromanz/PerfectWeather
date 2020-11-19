package com.example.perfectweather.data


import com.google.gson.annotations.SerializedName

data class OpenWeatherModel(
    val alerts: List<Alert>,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int
)