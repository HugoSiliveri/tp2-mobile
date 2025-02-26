package com.example.tp2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountriesList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCountries)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val countries = listOf("France", "Germany", "Spain", "Italy", "Portugal", "United States of America", "Brazil", "Japan", "China")

        val adapter = CountryAdapter(countries) { country ->
            val intent = Intent(this, CountriesListInfo::class.java)
            intent.putExtra("COUNTRY_NAME", country)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}