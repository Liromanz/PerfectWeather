package com.example.perfectweather

import com.example.perfectweather.model.OpenWeatherModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_URL = "https://api.openweathermap.org/data/2.5/"

interface WeatherInterface {

    @GET("onecall?")
    fun getOneCallWeather(
        @Query("lat") latitude : Double,
        @Query("lon") longtude : Double,
        @Query("exclude") exclude : String = "minutely",
        @Query("units") tempType : String = "metric",
        @Query("appid") key : String = BuildConfig.API_KEY
        ) : Call<OpenWeatherModel>
}