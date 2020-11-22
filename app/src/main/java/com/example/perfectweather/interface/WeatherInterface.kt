package com.example.perfectweather.`interface`

import com.example.perfectweather.BuildConfig
import com.example.perfectweather.model.OpenWeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_URL = "https://api.openweathermap.org/data/2.5/"

interface WeatherInterface {

    @GET("onecall?")
    fun getOneCallWeather(
        @Query("lat") latitude : Double,
        @Query("lon") longtude : Double,
        @Query("lang") language: String = "en",
        @Query("exclude") exclude : String = "minutely",
        @Query("units") tempType : String = "metric",
        @Query("appid") key : String = BuildConfig.API_KEY
        ) : Call<OpenWeatherModel>
}