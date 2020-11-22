package com.example.perfectweather

import android.content.Context
import android.location.Geocoder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.perfectweather.`interface`.Communicator
import kotlinx.android.synthetic.main.fragment_location.*
import kotlinx.android.synthetic.main.fragment_location.view.*
import java.io.IOException
import java.util.*

class LocationFragment : Fragment() {

    lateinit var  communicator: Communicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_location, container, false)

        communicator = activity as Communicator
        val preferences = this.requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val texts = listOf(view?.firstCity, view?.secondCity, view?.thirdCity, view?.fourthCity, view?.fifthCity)
        val cities = listOf(view?.cityName1, view?.cityName2, view?.cityName3, view?.cityName4, view?.cityName5)
        val citiesText = listOf(preferences.getString("city1", ""), preferences.getString("city2", ""), preferences.getString("city3", ""), preferences.getString("city4", ""), preferences.getString("city5", ""))
        val latitudes = listOf(view?.latText1, view?.latText2, view?.latText3, view?.latText4, view?.latText5)
        val latitudesText = listOf(preferences.getString("lat1", ""), preferences.getString("lat2", ""), preferences.getString("lat3", ""), preferences.getString("lat4", ""), preferences.getString("lat5", ""))
        val longitudes = listOf(view?.lonText1, view?.lonText2, view?.lonText3, view?.lonText4, view?.lonText5)
        val longitudesText = listOf(preferences.getString("lon1", ""), preferences.getString("lon2", ""), preferences.getString("lon3", ""), preferences.getString("lon4", ""), preferences.getString("lon5", ""))

        var i = 0
        while (i <= 4){
            cities[i]?.text = citiesText.get(i)
            latitudes[i]?.text = latitudesText.get(i)
            longitudes[i]?.text = longitudesText.get(i)
            if (cities[i]?.text != "") texts[i]?.visibility = View.VISIBLE
            i++
        }

        view.addBtn.setOnClickListener {
            val index = checkToAdd(view)
            if (index != -1) {
                try {
                    val city = cityAdd.text.toString()
                    val gc = Geocoder(view.context, Locale.getDefault())
                    val addresses = gc.getFromLocationName(city, 2)
                    var address = addresses.get(0)
                    cities[index]?.text = city
                    latitudes[index]?.text = address.latitude.toString()
                    longitudes[index]?.text = address.longitude.toString()
                    texts[index]?.visibility = View.VISIBLE
                }catch (e : IOException){
                    Toast.makeText(view.context, "Такого города нет", Toast.LENGTH_SHORT).show()
                }
            }
        }

        view.deleteBtn.setOnClickListener {
            val city = cityAdd.text.toString()
            var i = 0
            var index = -1
            while (i <= 4) {
                if (city == cities[i]?.text){
                    index = i
                    break
                }
                i++
            }
            if (index != -1) {
                cities[index]?.text = ""
                latitudes[index]?.text = ""
                longitudes[index]?.text = ""
                texts[index]?.visibility = View.GONE
            }
        }

        view.cityName1.setOnClickListener{
            onClick(cityName1, latText1, lonText1)
        }
        view.cityName2.setOnClickListener{
            onClick(cityName2, latText2, lonText2)
        }
        view.cityName3.setOnClickListener{
            onClick(cityName3, latText3, lonText3)
        }
        view.cityName4.setOnClickListener{
            onClick(cityName4, latText4, lonText4)
        }

        return view
    }

    fun checkToAdd(view: View) : Int{
        val texts = listOf(view.firstCity, view.secondCity, view.thirdCity, view.fourthCity, view.fifthCity)
        val cities = listOf(view.cityName1, view.cityName2, view.cityName3, view.cityName4, view.cityName5)

        var counterTo5 = 0
        for (text in texts)
            if (text.visibility == View.VISIBLE) counterTo5++
        if (counterTo5 == 5) return -1

        var i = 0
        while (i <=4){
            if (view.cityAdd.text.toString() == cities[i].text.toString())
                return -1
            i++
        }
        i = 0
        while (i <=4){
            if (texts[i].visibility == View.GONE)
                return i
            i++
        }
        return -1
    }

    private fun onClick(city: TextView, lat : TextView, lon : TextView){
        communicator.passDataCom(city.text.toString(), lat.text.toString(), lon.text.toString(),
            cityName1.text.toString(), cityName2.text.toString(), cityName3.text.toString(), cityName4.text.toString(), cityName5.text.toString(),
            latText1.text.toString(), latText2.text.toString(), latText3.text.toString(), latText4.text.toString(), latText5.text.toString(),
            lonText1.text.toString(), lonText2.text.toString(), lonText3.text.toString(), lonText4.text.toString(), lonText5.text.toString()
        )
    }
}