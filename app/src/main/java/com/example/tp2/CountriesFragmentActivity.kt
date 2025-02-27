package com.example.tp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CountriesFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, CountriesFragment())
            .commit()
    }
}
