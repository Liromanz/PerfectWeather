package com.example.perfectweather.model


import com.google.gson.annotations.SerializedName

data class Minutely(
    val dt: Int,
    val precipitation: Int
)