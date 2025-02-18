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

        val buttonSensorAvailability = findViewById<Button>(R.id.buttonSensorAvailability)
        buttonSensorAvailability.setOnClickListener {
            val intent2 = Intent(this, SensorAvailability::class.java)
            startActivity(intent2)
        }

        val buttonAccelerometer = findViewById<Button>(R.id.buttonAccelerometer)
        buttonAccelerometer.setOnClickListener {
            val intent3 = Intent(this, Accelerometer::class.java)
            startActivity(intent3)
        }
    }
}