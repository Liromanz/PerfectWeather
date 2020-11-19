package com.example.perfectweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.core.os.BuildCompat
import com.example.perfectweather.model.OpenWeatherModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val builder = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val weatherInterface: WeatherInterface = retrofit.create<WeatherInterface>(WeatherInterface::class.java)
        val call : Call<OpenWeatherModel> = weatherInterface.getOneCallWeather(55.7605,37.6296)

        val response = call.execute()
        if (response.isSuccessful) {
            cityText.text = response.body()!!.current.toString()
        }
    }
}