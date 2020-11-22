package com.example.perfectweather

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.perfectweather.enums.DayInfo
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

        val sdfSun = SimpleDateFormat("kk:mm")
        val sdfHour = SimpleDateFormat("kk")

        tempNowText.text = item!!.tempNow + '°'
        Picasso.get().load("http://openweathermap.org/img/wn/${item.iconWeather}@2x.png").fit().into(iconWeatherType)
        weatherTypeText.text = translateWeather(item.weatherType)
        tempMinMaxText.text = "${item.tempMin}° /${item.tempMax}°"
        tempFeelsLikeText.text = item.tempFeelsLike + '°'
        windText.text = item.wind
        sunriseTime.text = sdfSun.format(item.sunrise.toLong()*1000)
        sunsetTime.text = sdfSun.format(item.sunset.toLong()*1000)
        visibleMeter.text = item.visible
        humidityPercent.text = item.humidity + '%'
        pressureMeter.text = item.pressure
        cloudyPercent.text = item.cloudy+ '%'

        val hoursTexts = listOf(hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9, hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18, hour19, hour20, hour21, hour22, hour23, hour24)

        val tempTexts = listOf(tempNormal2, tempNormal3, tempNormal4, tempNormal5, tempNormal6, tempNormal7, tempNormal8, tempNormal9, tempNormal10, tempNormal11, tempNormal12, tempNormal13, tempNormal14, tempNormal15, tempNormal16, tempNormal17, tempNormal18, tempNormal19, tempNormal20, tempNormal21, tempNormal22, tempNormal23, tempNormal24)
        val feelTexts = listOf(tempFeels2, tempFeels3, tempFeels4, tempFeels5, tempFeels6, tempFeels7, tempFeels8, tempFeels9, tempFeels10, tempFeels11, tempFeels12, tempFeels13, tempFeels14, tempFeels15, tempFeels16, tempFeels17, tempFeels18, tempFeels19, tempFeels20, tempFeels21, tempFeels22, tempFeels23, tempFeels24)
        val iconTexts = listOf(icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12, icon13, icon14, icon15, icon16, icon17, icon18, icon19, icon20, icon21, icon22, icon23, icon24)

        if (item.hour != "") {
            weekSelector.visibility = View.GONE
            hourlyInterface.visibility = View.VISIBLE
            tableToHide.visibility = View.VISIBLE
            tableToHide2.visibility = View.VISIBLE
            var i = 0
            var hour = sdfHour.format(item.hour.toLong() * 1000).toInt()
            hour1.text = "${hour}:00"
            tempNormal1.text = item.hourTempList[0] + '°'
            tempFeels1.text = item.hourFeelList[0] + '°'
            Picasso.get().load("http://openweathermap.org/img/wn/${item.hourIconList[0]}@2x.png")
                .fit().into(icon1)
            while (i < 23) {
                if (hour == 24) hour = 1 else hour += 1
                hoursTexts[i].text = "${hour}:00"
                tempTexts[i].text = item.hourTempList[i] + '°'
                feelTexts[i].text = item.hourFeelList[i] + '°'
                Picasso.get()
                    .load("http://openweathermap.org/img/wn/${item.hourIconList[i]}@2x.png")
                    .resize(25, 25).centerCrop().into(iconTexts[i])
                i++
            }
        }else{
            weekSelector.visibility = View.VISIBLE
            hourlyInterface.visibility = View.GONE
            tableToHide.visibility = View.GONE
            tableToHide2.visibility = View.GONE
            val sdfWeek = SimpleDateFormat("EEEE")
            firstDayButton.text = sdfWeek.format(item.day2WeatherList[DayInfo.DAYOFWEEKDAY.ordinal].toLong() * 1000).toString().toUpperCase()
            secondDayButton.text = sdfWeek.format(item.day3WeatherList[DayInfo.DAYOFWEEKDAY.ordinal].toLong() * 1000).toString().toUpperCase()
            thirdDayButton.text = sdfWeek.format(item.day4WeatherList[DayInfo.DAYOFWEEKDAY.ordinal].toLong() * 1000).toString().toUpperCase()
            fourthDayButton.text = sdfWeek.format(item.day5WeatherList[DayInfo.DAYOFWEEKDAY.ordinal].toLong() * 1000).toString().toUpperCase()
            fifthDayButton.text = sdfWeek.format(item.day6WeatherList[DayInfo.DAYOFWEEKDAY.ordinal].toLong() * 1000).toString().toUpperCase()
        }

        firstDayButton.setOnClickListener {
            setDayWeather(item.day2WeatherList)
        }
        secondDayButton.setOnClickListener {
            setDayWeather(item.day3WeatherList)
        }
        thirdDayButton.setOnClickListener {
            setDayWeather(item.day4WeatherList)
        }
        fourthDayButton.setOnClickListener {
            setDayWeather(item.day5WeatherList)
        }
        fifthDayButton.setOnClickListener {
            setDayWeather(item.day6WeatherList)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Animatoo.animateZoom(this)
    }
    
    private fun setDayWeather(dayArray: Array<String>){
        val sdfSun = SimpleDateFormat("kk:mm")
        tempNowText.text = dayArray[DayInfo.DAYTEMPDAY.ordinal] + '°'
        Picasso.get().load("http://openweathermap.org/img/wn/${dayArray[DayInfo.ICONDAY.ordinal]}@2x.png").fit().into(iconWeatherType)
        weatherTypeText.text = translateWeather(dayArray[DayInfo.TYPEDAY.ordinal])
        tempMinMaxText.text = "${dayArray[DayInfo.MINTEMPDAY.ordinal]}° /${dayArray[DayInfo.MAXTEMPDAY.ordinal]}°"
        tempFeelsLikeText.text = dayArray[DayInfo.FEELSLIKEDAY.ordinal] + '°'
        windText.text = dayArray[DayInfo.WINDDAY.ordinal]
        sunriseTime.text = sdfSun.format(dayArray[DayInfo.SUNRISEDAY.ordinal].toLong()*1000)
        sunsetTime.text = sdfSun.format(dayArray[DayInfo.SUNSETDAY.ordinal].toLong()*1000)
        pressureMeter.text = dayArray[DayInfo.PRESSUREDAY.ordinal]
    }
    
    private fun translateWeather(engWeather: String): String{
        var toTranslate = engWeather

        val hints = listOf("Совет: в такую погоду одеться можно легче, но совсем раздеваться не стоит, в тени все еще холодно. Не забудьте посмотреть на ветер",
            "Совет: стоит запастить чем-то ярким и теплым, что поднимет вам настроение в этот серый день. На всякий случай можно взять зонт",
            "Совет: обязательно возьмите зонт и что-нибудь непромокаемое, дождь - вещь длительная",
            "Совет: в такую погоду лучше оставаться дома и наслаждаться теплыми напитками, но если собрались на прогулку, возьмите дождевик и не стойте под высокими объектами",
            "Совет: одеваться стоит потеплее: свитер и теплые носки не помешают. Обязательно возьмите шапку!",
            "Совет: туман может быть противен своим холодом и видимостью, советуем накинуть куртку или плащ")
        when (toTranslate) {
            "Clear" -> toTranslate = getString(R.string.weatherClear)
            "Clouds" -> toTranslate = getString(R.string.weatherBigClouds)
            "Rain", "Drizzle" -> toTranslate = getString(R.string.weatherRain)
            "Thunderstorm" -> toTranslate = getString(R.string.weatherThunder)
            "Snow" -> toTranslate = getString(R.string.weatherSnow)
            "Mist", "Smoke", "Haze", "Dust", "Fog", "Sand", "Ash", "Squall", "Tornado" -> toTranslate = getString(R.string.weatherMist)
        }
        when (toTranslate) {
            getString(R.string.weatherClear) -> {weatherGif.setImageResource(R.drawable.sunny); hintText.text = hints[0]}
            getString(R.string.weatherBigClouds) -> {weatherGif.setImageResource(R.drawable.clouds); hintText.text = hints[1]}
            getString(R.string.weatherRain) -> {weatherGif.setImageResource(R.drawable.rain); hintText.text = hints[2]}
            getString(R.string.weatherThunder) -> {weatherGif.setImageResource(R.drawable.thunder); hintText.text = hints[3]}
            getString(R.string.weatherSnow) -> {weatherGif.setImageResource(R.drawable.snow); hintText.text = hints[4]}
            getString(R.string.weatherMist) -> {weatherGif.setImageResource(R.drawable.mist); hintText.text = hints[5]}
        }
        return toTranslate
    }
}