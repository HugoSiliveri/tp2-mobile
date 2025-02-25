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
            val intent = Intent(this, SensorAvailability::class.java)
            startActivity(intent)
        }

        val buttonAccelerometer = findViewById<Button>(R.id.buttonAccelerometer)
        buttonAccelerometer.setOnClickListener {
            val intent = Intent(this, Accelerometer::class.java)
            startActivity(intent)
        }

        val buttonDirection = findViewById<Button>(R.id.buttonDirection)
        buttonDirection.setOnClickListener {
            val intent = Intent(this, Direction::class.java)
            startActivity(intent)
        }

        val buttonFlashlight = findViewById<Button>(R.id.buttonFlashlight)
        buttonFlashlight.setOnClickListener {
            val intent = Intent(this, Flashlight::class.java)
            startActivity(intent)
        }

        val buttonProximity = findViewById<Button>(R.id.buttonProximity)
        buttonProximity.setOnClickListener {
            val intent = Intent(this, Proximity::class.java)
            startActivity(intent)
        }

        val buttonGeolocation = findViewById<Button>(R.id.buttonGeolocation)
        buttonGeolocation.setOnClickListener {
            val intent = Intent(this, Geolocation::class.java)
            startActivity(intent)
        }
    }
}