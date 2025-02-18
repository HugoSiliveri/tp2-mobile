package com.example.tp2

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity

class SensorList : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_list)

        val listViewSensorList = findViewById<ListView>(R.id.listViewSensorList)
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        val sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL)
        val sensors = mutableListOf<String>()

        for (sensor in sensorList) {
            sensors.add("• ${sensor.name}")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sensors)
        listViewSensorList.adapter = adapter


    }
}