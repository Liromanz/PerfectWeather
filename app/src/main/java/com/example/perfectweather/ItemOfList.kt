package com.example.perfectweather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOfList (
    val infoWeather: String = "",
    val infoPreview: Array<String> = arrayOf("","","",""),
    val tempPreview: Array<String> = arrayOf("","","",""),
    val iconPreview: Array<String> = arrayOf("","","",""),

    val tempNow: String = "",
    val iconWeather: String = "",
    var weatherType: String = "",
    val tempMin: String = "",
    val tempMax: String = "",
    val tempFeelsLike: String = "",
    val wind: String = "",
    val sunrise: String = "",
    val sunset: String = "",
    val visible: String = "",
    val pressure: String = "",
    val humidity: String = "",
    val cloudy: String = "",

    var hour:String = "",
    val hourIconList: List<String> = listOf(""),
    val hourTempList: List<String> = listOf(""),
    val hourFeelList: List<String> = listOf(""),

    val day2WeatherList: Array<String> = arrayOf("", "", "", "", "", "", "", "", "", "", ""),
    val day3WeatherList: Array<String> = arrayOf("", "", "", "", "", "", "", "", "", "", ""),
    val day4WeatherList: Array<String> = arrayOf("", "", "", "", "", "", "", "", "", "", ""),
    val day5WeatherList: Array<String> = arrayOf("", "", "", "", "", "", "", "", "", "", ""),
    val day6WeatherList: Array<String> = arrayOf("", "", "", "", "", "", "", "", "", "", "")

) : Parcelable