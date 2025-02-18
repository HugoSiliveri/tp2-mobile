package com.example.tp2

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity

class SensorAvailability : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_list)

        val listViewSensorList = findViewById<ListView>(R.id.listViewSensorList)
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        val sensors = mutableListOf<String>()

        sensors.add("List of unavailable sensors : ")
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) == null) {
            sensors.add(" - Gravity sensor : Can't get gravity")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) {
            sensors.add(" - Accelerometer : Can't get speed")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) == null) {
            sensors.add(" - Ambient temperature sensor : Can't get ambient temperature")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) == null) {
            sensors.add(" - Light sensor : Can't get light")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) == null) {
            sensors.add(" - Linear acceleration sensor : Can't get acceleration")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) == null) {
            sensors.add(" - Gyroscope : Can't get rotation")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null) {
            sensors.add(" - Magnetic field sensor : Can't get magnetic field")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) == null) {
            sensors.add(" - Pressure sensor : Can't get pressure")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            sensors.add(" - Proximity sensor : Can't get proximity")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) == null) {
            sensors.add(" - Relative humidity sensor : Can't get relative humidity")
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null) {
            sensors.add(" - Rotation vector sensor : Can't get rotation vector")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sensors)
        listViewSensorList.adapter = adapter
    }
}