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
    val weatherType: String,
    val weatherIcon: String,
    val tempMin: String,
    val tempMax: String,
    val feelsLike: String,
    val wind: String,
    val sunrise: String,
    val sunset: String,
    val visibility: String,
    val pressure: String,
    val humidity: String,
    val cloudy: String,

    val hourIcon1:String,
    val hourTemp1:String,
    val hourFeel1:String,
    val hourIcon2:String,
    val hourTemp2:String,
    val hourFeel2:String,
    val hourIcon3:String,
    val hourTemp3:String,
    val hourFeel3:String,
    val hourIcon4:String,
    val hourTemp4:String,
    val hourFeel4:String,
    val hourIcon5:String,
    val hourTemp5:String,
    val hourFeel5:String,
    val hourIcon6:String,
    val hourTemp6:String,
    val hourFeel6:String,
    val hourIcon7:String,
    val hourTemp7:String,
    val hourFeel7:String,
    val hourIcon8:String,
    val hourTemp8:String,
    val hourFeel8:String,
    val hourIcon9:String,
    val hourTemp9:String,
    val hourFeel9:String,
    val hourIcon10:String,
    val hourTemp10:String,
    val hourFeel10:String,
    val hourIcon11:String,
    val hourTemp11:String,
    val hourFeel11:String,
    val hourIcon12:String,
    val hourTemp12:String,
    val hourFeel12:String,
    val hourIcon13:String,
    val hourTemp13:String,
    val hourFeel13:String,
    val hourIcon14:String,
    val hourTemp14:String,
    val hourFeel14:String,
    val hourIcon15:String,
    val hourTemp15:String,
    val hourFeel15:String,
    val hourIcon16:String,
    val hourTemp16:String,
    val hourFeel16:String,
    val hourIcon17:String,
    val hourTemp17:String,
    val hourFeel17:String,
    val hourIcon18:String,
    val hourTemp18:String,
    val hourFeel18:String,
    val hourIcon19:String,
    val hourTemp19:String,
    val hourFeel19:String,
    val hourIcon20:String,
    val hourTemp20:String,
    val hourFeel20:String,
    val hourIcon21:String,
    val hourTemp21:String,
    val hourFeel22:String,
    val hourIcon23:String,
    val hourTemp23:String,
    val hourFeel23:String,
    val hourIcon24:String,
    val hourTemp24:String,
    val hourFeel24:String

) : Parcelable