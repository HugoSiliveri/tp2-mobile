package com.example.tp2

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity
import kotlin.math.sqrt

class Accelerometer : ComponentActivity(), SensorEventListener {

    private lateinit var layout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = RelativeLayout(this)
        layout.setBackgroundColor(Color.WHITE)
        setContentView(layout)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        p0?.let {
            val x = it.values[0]
            val y = it.values[1]
            val z = it.values[2]

            val acceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()

            when {
                acceleration < 10.0 -> layout.setBackgroundColor(Color.GREEN)
                acceleration in 10.0..15.0 -> layout.setBackgroundColor(Color.BLACK)
                else -> layout.setBackgroundColor(Color.RED)
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}
