package com.example.tp2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class CountriesListInfo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries_list_info)

        val countryName = intent.getStringExtra("COUNTRY_NAME") ?: ""
        val country = CountryData.getCountryByName(countryName)

        if (country != null) {
            findViewById<TextView>(R.id.textViewCountry).text = country.name
            findViewById<TextView>(R.id.textCapital).text = "Capital : ${country.capital}"
            findViewById<TextView>(R.id.textPopulation).text = "Population : ${country.population} habitants"
            findViewById<TextView>(R.id.textArea).text = "Area : ${country.area} km²"
            findViewById<ImageView>(R.id.imageFlag).setBackgroundResource(country.flagResId)
        }
    }
}
