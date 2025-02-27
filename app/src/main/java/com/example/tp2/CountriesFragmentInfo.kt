package com.example.tp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class CountriesFragmentInfo: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_countries_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryName = arguments?.getString("COUNTRY_NAME") ?: ""
        val country = CountryData.getCountryByName(countryName)

        if (country != null) {
            view.findViewById<TextView>(R.id.textViewCountry).text = country.name
            view.findViewById<TextView>(R.id.textCapital).text = "Capital : ${country.capital}"
            view.findViewById<TextView>(R.id.textPopulation).text = "Population : ${country.population} habitants"
            view.findViewById<TextView>(R.id.textArea).text = "Area : ${country.area} km²"
            view.findViewById<ImageView>(R.id.imageFlag).setBackgroundResource(country.flagResId)
        }
    }
}