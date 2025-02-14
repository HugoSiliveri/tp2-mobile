package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSensorList = findViewById<Button>(R.id.buttonSensorList)
        buttonSensorList.setOnClickListener {
            val intent = Intent(this, SensorList::class.java)
            startActivity(intent)
        }
    }
}