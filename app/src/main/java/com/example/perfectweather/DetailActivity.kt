package com.example.perfectweather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<ItemOfList>("OBJECT_INTENT")

        val hints = listOf("Совет: в такую погоду одеться можно легче, чем обычно. Не забудьте посмотреть на ветер",
            "Совет: совсем раздеваться не стоит, солнце хоть и выглядывает, но в тени все еще холодно",
            "Совет: стоит запастить чем-то ярким и теплым, что поднимет вам настроение в этот серый день. На всякий случай можно взять зонт",
            "Совет: обязательно возьмите зонт и что-нибудь непромокаемое, дождь - вещь длительная",
            "Совет: в такую погоду лучше оставаться дома и наслаждаться теплыми напитками, но если собрались на прогулку, возьмите дождевик и не стойте под высокими объектами",
            "Совет: одеваться стоит потеплее: свитер и теплые носки не помешают. Обязательно возьмите шапку!",
            "Совет: туман может быть противен своим холодом и видимостью, советуем накинуть куртку или плащ")

        when {
            item!!.weatherType == getString(R.string.weatherClear) -> {weatherGif.setBackgroundResource(R.drawable.sunny); hintText.text = hints[0]}
            item.weatherType == getString(R.string.weatherClouds) -> {weatherGif.setBackgroundResource(R.drawable.clouds_part); hintText.text = hints[1]}
            item.weatherType == getString(R.string.weatherBigClouds) -> {weatherGif.setBackgroundResource(R.drawable.clouds); hintText.text = hints[2]}
            item.weatherType == getString(R.string.weatherRain) -> {weatherGif.setBackgroundResource(R.drawable.rain); hintText.text = hints[3]}
            item.weatherType == getString(R.string.weatherThunder) -> {weatherGif.setBackgroundResource(R.drawable.thunder); hintText.text = hints[4]}
            item.weatherType == getString(R.string.weatherSnow) -> {weatherGif.setBackgroundResource(R.drawable.snow); hintText.text = hints[5]}
            item.weatherType == getString(R.string.weatherMist) -> {weatherGif.setBackgroundResource(R.drawable.mist); hintText.text = hints[6]}
        }

        val sdfSun = SimpleDateFormat("kk:mm")
        val sdfHour = SimpleDateFormat("kk")

        tempNowText.text = item!!.tempNow + '°'
        Picasso.get().load("http://openweathermap.org/img/wn/${item.iconWeather}@2x.png").fit().into(iconWeatherType)
        weatherTypeText.text = item.weatherType
        tempMinMaxText.text = "${item.tempMin} °/${item.tempMax}°"
        tempFeelsLikeText.text = item.tempFeelsLike + '°'
        windText.text = item.wind
        sunriseTime.text = sdfSun.format(item.sunrise.toLong()*1000)
        sunsetTime.text = sdfSun.format(item.sunset.toLong()*1000)
        visibleMeter.text = item.visible
        humidityPercent.text = item.humidity + '%'
        pressureMeter.text = item.pressure
        cloudyPercent.text = item.cloudy+ '%'

        val hoursTexts = listOf(hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9, hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18, hour19, hour20, hour21, hour22, hour23, hour24)

        val tempTexts = listOf(tempNormal2, tempNormal3, tempNormal4, tempNormal5, tempNormal6, tempNormal7, tempNormal8, tempNormal9, tempNormal10, tempNormal11, tempNormal12, tempNormal13, tempNormal14, tempNormal15, tempNormal16, tempNormal17, tempNormal18, tempNormal19, tempNormal20, tempNormal21, tempNormal23, tempNormal23, tempNormal24)
        val feelTexts = listOf(tempFeels2, tempFeels3, tempFeels4, tempFeels5, tempFeels6, tempFeels7, tempFeels8, tempFeels9, tempFeels10, tempFeels11, tempFeels12, tempFeels13, tempFeels14, tempFeels15, tempFeels16, tempFeels17, tempFeels18, tempFeels19, tempFeels20, tempFeels21, tempFeels22, tempFeels23, tempFeels24)
        val iconTexts = listOf(icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12, icon13, icon14, icon15, icon16, icon17, icon18, icon19, icon20, icon21, icon22, icon23, icon24)

        var i = 1
        var hour = sdfHour.format(item.hour.toLong()*1000).toInt()
        hour1.text = "${hour}:00"
        tempNormal1.text = item.hourTempList[0] + '°'
        tempFeels1.text = item.hourFeelList[0] + '°'
        Picasso.get().load("http://openweathermap.org/img/wn/${item.hourIconList[0]}@2x.png").fit().into(icon1)
        while (i<23){
            if (hour == 25) hour = 0 else hour += 1
            hoursTexts[i].text = "${hour}:00"
            tempTexts[i].text = item.hourTempList[0] + '°'
            feelTexts[i].text = item.hourFeelList[0] + '°'
            Picasso.get().load("http://openweathermap.org/img/wn/${item.hourIconList[0]}@2x.png").fit().into(iconTexts[i])
            i++
        }
    }
}