package com.example.tp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountriesFragment : Fragment() {

    private var onCountrySelected: ((String) -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCountries)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val countries = listOf("France", "Germany", "Spain", "Italy", "Portugal", "United States of America", "Brazil", "Japan", "China")

        val adapter = CountryAdapter(countries) { country ->
            onCountrySelected?.invoke(country)
        }
        recyclerView.adapter = adapter
    }
}