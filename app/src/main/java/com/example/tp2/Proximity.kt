package com.example.tp2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity

class Proximity : ComponentActivity(), SensorEventListener {

    private lateinit var imageView: ImageView
    private lateinit var proximitySensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity)

        imageView = findViewById(R.id.imageView)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!!

        sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_PROXIMITY) {
            val threshold = proximitySensor.maximumRange * 0.5
            if (event.values[0] < threshold) {
                imageView.setImageResource(R.drawable.near)
            } else {
                imageView.setImageResource(R.drawable.far)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}
