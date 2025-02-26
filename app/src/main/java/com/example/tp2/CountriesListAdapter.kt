package com.example.tp2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countryList: List<String>, private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryName: TextView = view.findViewById(R.id.textViewCountryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.countryName.text = country

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CountriesListInfo::class.java)
            intent.putExtra("COUNTRY_NAME", country)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = countryList.size
}