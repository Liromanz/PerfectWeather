package com.example.perfectweather.data


import com.google.gson.annotations.SerializedName

data class Minutely(
    val dt: Int,
    val precipitation: Double
)