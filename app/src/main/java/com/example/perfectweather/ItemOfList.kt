package com.example.perfectweather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOfList (
    val infoWeather: String,
    val info1: String,
    val temp1: String,
    val icon1: String,
    val info2: String,
    val temp2: String,
    val icon2: String,
    val info3: String,
    val temp3: String,
    val icon3: String,
    val info4: String,
    val temp4: String,
    val icon4: String,

    val tempNow: String,
    val iconWeather: String,
    val weatherType: String,
    val tempMin: String,
    val tempMax: String,
    val tempFeelsLike: String,
    val wind: String,
    val sunrise: String,
    val sunset: String,
    val visible: String,
    val pressure: String,
    val humidity: String,
    val cloudy: String,

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