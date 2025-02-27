package com.example.tp2

data class Country(
    val name: String,
    val capital: String,
    val population: Int,
    val area: Double,
    val flagResId: Int
)

object CountriesData {
    val countries = listOf(
        Country("France", "Paris", 68373433, 672051.0,R.drawable.france),
        Country("Germany", "Berlin", 84708010, 	357588.0, R.drawable.germany),
        Country("Spain", "Madrid", 48946035, 505911.0, R.drawable.spain),
        Country("Italy", "Rome", 58851000, 301336.0, R.drawable.italy),
        Country("Portugal", "Lisbonne", 10639726, 92256.0, R.drawable.portugal),
        Country("United States of America", "Washington DC", 340110988, 9833517.0, R.drawable.usa),
        Country("Brazil", "Brasilia", 212583750, 8547404.0, R.drawable.brazil),
        Country("Japan", "Tokyo", 123887000, 377975.0, R.drawable.japan),
        Country("China", "Pékin", 1425671352, 9596960.0, R.drawable.china)
    )

    fun getCountryByName(name: String): Country? {
        return countries.find { it.name == name }
    }
}
