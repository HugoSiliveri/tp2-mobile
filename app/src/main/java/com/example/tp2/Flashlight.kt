package com.example.tp2

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.math.sqrt

class Flashlight : ComponentActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private lateinit var cameraManager: CameraManager
    private var cameraId: String? = null
    private var lastShakeTime: Long = 0
    private var isFlashOn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LinearLayout(this))

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList.firstOrNull()

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val x = it.values[0]
            val y = it.values[1]
            val z = it.values[2]

            val acceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            val currentTime = System.currentTimeMillis()

            if (acceleration > 12) {
                if (currentTime - lastShakeTime > 1000) {
                    lastShakeTime = currentTime
                    toggleFlashlight()
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    private fun toggleFlashlight() {
        cameraId?.let {
            try {
                isFlashOn = !isFlashOn
                cameraManager.setTorchMode(it, isFlashOn)
                Toast.makeText(this, "Flash $isFlashOn", Toast.LENGTH_SHORT).show()
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        }
    }
}
