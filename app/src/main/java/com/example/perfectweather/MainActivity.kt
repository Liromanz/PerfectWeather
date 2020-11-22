package com.example.perfectweather

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.perfectweather.`interface`.Communicator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var  sharedPreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val navController = Navigation.findNavController(this, R.id.nav_Host_Fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION), 111)
    }

    override fun passDataCom(cityText: String, lat: String, lon: String, city1: String, city2: String, city3: String, city4: String, city5: String, lat1: String, lat2: String, lat3: String, lat4: String, lat5: String, lon1: String, lon2: String, lon3: String, lon4: String, lon5: String) {
        val editor = sharedPreferences.edit()
        editor.putString("city1", city1)
        editor.putString("city2", city2)
        editor.putString("city3", city3)
        editor.putString("city4", city4)
        editor.putString("city5", city5)
        editor.putString("lat1", lat1)
        editor.putString("lat2", lat2)
        editor.putString("lat3", lat3)
        editor.putString("lat4", lat4)
        editor.putString("lat5", lat5)
        editor.putString("lon1", lon1)
        editor.putString("lon2", lon2)
        editor.putString("lon3", lon3)
        editor.putString("lon4", lon4)
        editor.putString("lon5", lon5)
        editor.putString("cityMain", cityText)
        editor.putString("latMain", lat)
        editor.putString("lonMain", lon)
        editor.apply()

        Navigation.findNavController(this, R.id.nav_Host_Fragment).navigate(R.id.action_locationFragment2_to_mainFragment)
        Animatoo.animateFade(this)
    }
}