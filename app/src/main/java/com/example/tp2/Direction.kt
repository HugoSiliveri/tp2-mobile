package com.example.tp2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class Direction : ComponentActivity(), SensorEventListener {

    private lateinit var textViewDirection: TextView
    private var oldX = 0f
    private var oldY = 0f
    private var currentDirection = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direction)

        textViewDirection = findViewById(R.id.textViewDirection)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        p0?.let {
            val x = it.values[0]
            val y = it.values[1]

            val direction = when {
                x > oldX + 1 -> "Droite"
                x < oldX - 1 -> "Gauche"
                y > oldY + 1 -> "Haut"
                y < oldY - 1 -> "Bas"
                else -> currentDirection
            }

            if (direction != currentDirection) {
                currentDirection = direction
                textViewDirection.text = currentDirection
            }

            oldX = x
            oldY = y
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}
