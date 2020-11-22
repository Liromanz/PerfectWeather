package com.example.perfectweather

import android.location.Geocoder
import android.os.Bundle
import android.util.Log
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
import kotlin.concurrent.thread

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

        val texts = listOf(view?.firstCity, view?.secondCity, view?.thirdCity, view?.fourthCity, view?.fifthCity)
        val cities = listOf(view?.cityName1, view?.cityName2, view?.cityName3, view?.cityName4, view?.cityName5)
        val latitudes = listOf(view?.latText1, view?.latText2, view?.latText3, view?.latText4, view?.latText5)
        val longitudes = listOf(view?.lonText1, view?.lonText2, view?.lonText3, view?.lonText4, view?.lonText5)

        view.addBtn.setOnClickListener {
            val i = checkToAdd(view)
            if (i != -1) {
                try {
                    val city = cityAdd.text.toString()
                    val gc = Geocoder(view.context, Locale.getDefault())
                    val addresses = gc.getFromLocationName(city, 2)
                    var address = addresses.get(0)
                    cities[i]?.text = city
                    latitudes[i]?.text = address.latitude.toString()
                    longitudes[i]?.text = address.longitude.toString()
                    texts[i]?.visibility = View.VISIBLE
                }catch (e : IOException){
                    android.widget.Toast.makeText(view.context, "Такого города нет", Toast.LENGTH_SHORT).show()
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
        communicator.passDataCom(city.text.toString(), lat.text.toString(), lon.text.toString())
    }
}