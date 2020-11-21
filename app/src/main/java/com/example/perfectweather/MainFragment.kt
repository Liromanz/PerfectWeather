package com.example.perfectweather

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.perfectweather.model.OpenWeatherModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat

class MainFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val builder = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val weatherInterface: WeatherInterface =
            retrofit.create<WeatherInterface>(WeatherInterface::class.java)
        val call: Call<OpenWeatherModel> =
            weatherInterface.getOneCallWeather(55.7605, 37.6296, "ru")
        val response = call.execute()
        var imageList : List<ItemOfList> = listOf(ItemOfList())
        if (response.isSuccessful) {
            val body = response.body()!!
            val sdfWeek = SimpleDateFormat("EE")
            imageList = listOf<ItemOfList>(
                ItemOfList(
                    "Сегодня", arrayOf("Утро", "День", "Вечер", "Ночь"),
                    arrayOf(body.daily[0].temp.morn.toString(), body.daily[0].temp.day.toString(),body.daily[0].temp.eve.toString(), body.daily[0].temp.night.toString()),
                    arrayOf(body.daily[0].weather[0].icon, body.current.weather[0].icon, body.current.weather[0].icon, body.daily[0].weather[0].icon),
                    body.current.temp.toString(), body.daily[0].weather[0].icon, body.daily[0].weather[0].main, body.daily[0].temp.min.toString(), body.daily[0].temp.max.toString(), body.daily[0].feelsLike.day.toString(), body.current.windSpeed.toString(), body.current.sunrise.toString(), body.current.sunset.toString(), body.current.visibility.toString(),
                    body.current.pressure.toString(), body.current.humidity.toString(), body.current.clouds.toString(), body.hourly[0].dt.toString(),
                    listOf(body.hourly[0].weather[0].icon,body.hourly[1].weather[0].icon,body.hourly[2].weather[0].icon,body.hourly[3].weather[0].icon,
                        body.hourly[4].weather[0].icon,body.hourly[5].weather[0].icon,body.hourly[6].weather[0].icon,body.hourly[7].weather[0].icon,
                        body.hourly[8].weather[0].icon,body.hourly[9].weather[0].icon,body.hourly[10].weather[0].icon,body.hourly[11].weather[0].icon,
                        body.hourly[12].weather[0].icon,body.hourly[13].weather[0].icon,body.hourly[14].weather[0].icon,body.hourly[15].weather[0].icon,
                        body.hourly[16].weather[0].icon,body.hourly[17].weather[0].icon,body.hourly[18].weather[0].icon,body.hourly[19].weather[0].icon,
                        body.hourly[20].weather[0].icon,body.hourly[21].weather[0].icon,body.hourly[22].weather[0].icon,body.hourly[23].weather[0].icon),
                    listOf(body.hourly[0].temp.toString(),body.hourly[1].temp.toString(),body.hourly[2].temp.toString(),body.hourly[3].temp.toString(),
                        body.hourly[4].temp.toString(),body.hourly[5].temp.toString(),body.hourly[6].temp.toString(),body.hourly[7].temp.toString(),
                        body.hourly[8].temp.toString(),body.hourly[9].temp.toString(),body.hourly[10].temp.toString(),body.hourly[11].temp.toString(),
                        body.hourly[12].temp.toString(),body.hourly[13].temp.toString(),body.hourly[14].temp.toString(),body.hourly[15].temp.toString(),
                        body.hourly[16].temp.toString(),body.hourly[17].temp.toString(),body.hourly[18].temp.toString(),body.hourly[19].temp.toString(),
                        body.hourly[20].temp.toString(),body.hourly[21].temp.toString(),body.hourly[22].temp.toString(),body.hourly[23].temp.toString()),
                    listOf(body.hourly[0].feelsLike.toString(),body.hourly[1].feelsLike.toString(),body.hourly[2].feelsLike.toString(),body.hourly[3].feelsLike.toString(),
                        body.hourly[4].feelsLike.toString(),body.hourly[5].feelsLike.toString(),body.hourly[6].feelsLike.toString(),body.hourly[7].feelsLike.toString(),
                        body.hourly[8].feelsLike.toString(),body.hourly[9].feelsLike.toString(),body.hourly[10].feelsLike.toString(),body.hourly[11].feelsLike.toString(),
                        body.hourly[12].feelsLike.toString(),body.hourly[13].feelsLike.toString(),body.hourly[14].feelsLike.toString(),body.hourly[15].feelsLike.toString(),
                        body.hourly[16].feelsLike.toString(),body.hourly[17].feelsLike.toString(),body.hourly[18].feelsLike.toString(),body.hourly[19].feelsLike.toString(),
                        body.hourly[20].feelsLike.toString(),body.hourly[21].feelsLike.toString(),body.hourly[22].feelsLike.toString(),body.hourly[23].feelsLike.toString())),
                ItemOfList("Завтра", arrayOf("Утро", "День", "Вечер", "Ночь"),
                    arrayOf(body.daily[1].temp.morn.toString(), body.daily[1].temp.day.toString(), body.daily[1].temp.eve.toString(), body.daily[1].temp.night.toString()),
                    arrayOf(body.daily[1].weather[0].icon, body.daily[1].weather[0].icon, body.daily[1].weather[0].icon, body.daily[1].weather[0].icon),
                    body.daily[1].temp.day.toString(), body.daily[1].weather[0].icon, body.daily[1].weather[0].main, body.daily[1].temp.min.toString(), body.daily[1].temp.max.toString(), body.daily[1].feelsLike.day.toString(), body.daily[1].windSpeed.toString(), body.daily[1].sunrise.toString(), body.daily[1].sunset.toString(), "-",
                    body.daily[1].pressure.toString(), body.daily[1].humidity.toString(), body.daily[1].clouds.toString(), body.hourly[24].dt.toString(),
                    listOf(body.hourly[24].weather[0].icon,body.hourly[25].weather[0].icon,body.hourly[26].weather[0].icon,body.hourly[27].weather[0].icon,
                        body.hourly[28].weather[0].icon,body.hourly[29].weather[0].icon,body.hourly[30].weather[0].icon,body.hourly[31].weather[0].icon,
                        body.hourly[32].weather[0].icon,body.hourly[33].weather[0].icon,body.hourly[34].weather[0].icon,body.hourly[35].weather[0].icon,
                        body.hourly[36].weather[0].icon,body.hourly[37].weather[0].icon,body.hourly[38].weather[0].icon,body.hourly[39].weather[0].icon,
                        body.hourly[40].weather[0].icon,body.hourly[41].weather[0].icon,body.hourly[42].weather[0].icon,body.hourly[43].weather[0].icon,
                        body.hourly[44].weather[0].icon,body.hourly[45].weather[0].icon,body.hourly[46].weather[0].icon,body.hourly[47].weather[0].icon),
                    listOf(body.hourly[24].temp.toString(),body.hourly[25].temp.toString(),body.hourly[26].temp.toString(),body.hourly[27].temp.toString(),
                        body.hourly[28].temp.toString(),body.hourly[29].temp.toString(),body.hourly[30].temp.toString(),body.hourly[31].temp.toString(),
                        body.hourly[32].temp.toString(),body.hourly[33].temp.toString(),body.hourly[34].temp.toString(),body.hourly[35].temp.toString(),
                        body.hourly[36].temp.toString(),body.hourly[37].temp.toString(),body.hourly[38].temp.toString(),body.hourly[39].temp.toString(),
                        body.hourly[40].temp.toString(),body.hourly[41].temp.toString(),body.hourly[42].temp.toString(),body.hourly[43].temp.toString(),
                        body.hourly[44].temp.toString(),body.hourly[45].temp.toString(),body.hourly[46].temp.toString(),body.hourly[47].temp.toString()),
                    listOf(body.hourly[24].feelsLike.toString(),body.hourly[25].feelsLike.toString(),body.hourly[26].feelsLike.toString(),body.hourly[27].feelsLike.toString(),
                        body.hourly[28].feelsLike.toString(),body.hourly[29].feelsLike.toString(),body.hourly[30].feelsLike.toString(),body.hourly[31].feelsLike.toString(),
                        body.hourly[32].feelsLike.toString(),body.hourly[33].feelsLike.toString(),body.hourly[34].feelsLike.toString(),body.hourly[35].feelsLike.toString(),
                        body.hourly[36].feelsLike.toString(),body.hourly[37].feelsLike.toString(),body.hourly[38].feelsLike.toString(),body.hourly[39].feelsLike.toString(),
                        body.hourly[40].feelsLike.toString(),body.hourly[41].feelsLike.toString(),body.hourly[42].feelsLike.toString(),body.hourly[43].feelsLike.toString(),
                        body.hourly[44].feelsLike.toString(),body.hourly[45].feelsLike.toString(),body.hourly[46].feelsLike.toString(),body.hourly[47].feelsLike.toString())),
                ItemOfList("Неделя", arrayOf(sdfWeek.format(body.daily[2].dt.toLong() * 1000).toString().toUpperCase(), sdfWeek.format(body.daily[3].dt.toLong() * 1000).toString().toUpperCase(), sdfWeek.format(body.daily[4].dt.toLong() * 1000).toString().toUpperCase(), sdfWeek.format(body.daily[5].dt.toLong()*1000).toString().toUpperCase()),
                    arrayOf(body.daily[2].temp.day.toString(), body.daily[3].temp.day.toString(), body.daily[4].temp.day.toString(), body.daily[5].temp.day.toString()),
                    arrayOf(body.daily[2].weather[0].icon, body.daily[3].weather[0].icon, body.daily[4].weather[0].icon, body.daily[5].weather[0].icon),
                    body.daily[2].temp.day.toString(), body.daily[2].weather[0].icon, body.daily[2].weather[0].main, body.daily[2].temp.min.toString(), body.daily[2].temp.max.toString(), body.daily[2].feelsLike.day.toString(), body.daily[2].windSpeed.toString(), body.daily[2].sunrise.toString(), body.daily[2].sunset.toString(), "-",
                    body.daily[2].pressure.toString(), "", "", "",
                    listOf(""), listOf(""), listOf(""),
                    arrayOf(body.daily[2].dt.toString(), body.daily[2].temp.day.toString(), body.daily[2].weather[0].icon, body.daily[2].weather[0].main, body.daily[2].temp.min.toString(), body.daily[2].temp.max.toString(), body.daily[2].feelsLike.day.toString(), body.daily[2].windSpeed.toString(), body.daily[2].sunrise.toString(), body.daily[2].sunset.toString(),body.daily[2].pressure.toString()),
                    arrayOf(body.daily[3].dt.toString(), body.daily[3].temp.day.toString(), body.daily[3].weather[0].icon, body.daily[3].weather[0].main, body.daily[3].temp.min.toString(), body.daily[3].temp.max.toString(), body.daily[3].feelsLike.day.toString(), body.daily[3].windSpeed.toString(), body.daily[3].sunrise.toString(), body.daily[3].sunset.toString(),body.daily[3].pressure.toString()),
                    arrayOf(body.daily[4].dt.toString(), body.daily[4].temp.day.toString(), body.daily[4].weather[0].icon, body.daily[4].weather[0].main, body.daily[4].temp.min.toString(), body.daily[4].temp.max.toString(), body.daily[4].feelsLike.day.toString(), body.daily[4].windSpeed.toString(), body.daily[4].sunrise.toString(), body.daily[4].sunset.toString(),body.daily[4].pressure.toString()),
                    arrayOf(body.daily[5].dt.toString(), body.daily[5].temp.day.toString(), body.daily[5].weather[0].icon, body.daily[5].weather[0].main, body.daily[5].temp.min.toString(), body.daily[5].temp.max.toString(), body.daily[5].feelsLike.day.toString(), body.daily[5].windSpeed.toString(), body.daily[5].sunrise.toString(), body.daily[5].sunset.toString(),body.daily[5].pressure.toString()),
                    arrayOf(body.daily[6].dt.toString(), body.daily[6].temp.day.toString(), body.daily[6].weather[0].icon, body.daily[6].weather[0].main, body.daily[6].temp.min.toString(), body.daily[6].temp.max.toString(), body.daily[6].feelsLike.day.toString(), body.daily[6].windSpeed.toString(), body.daily[6].sunrise.toString(), body.daily[6].sunset.toString(),body.daily[6].pressure.toString()))
            )
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ItemAdapter(requireContext(), imageList) {//requireActivity.ApplicationContext, если и это, то
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("OBJECT_INTENT", it)
            startActivity(intent)
        }

        return view
    }
}