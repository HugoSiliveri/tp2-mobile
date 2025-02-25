package com.example.tp2

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import android.Manifest
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig

class Geolocation : ComponentActivity() {

    private lateinit var mapView: MapView
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geolocation)

        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID

        mapView = findViewById(R.id.mapView)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.setMultiTouchControls(true)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                fetchLocation()
            } else {
                Toast.makeText(this, "Permission refusée", Toast.LENGTH_SHORT).show()
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            fetchLocation()
        }
    }

    private fun fetchLocation() {
        try {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val userGeoPoint = GeoPoint(location.latitude, location.longitude)
                    mapView.controller.setZoom(15.0)
                    mapView.controller.setCenter(userGeoPoint)

                    val marker = Marker(mapView)
                    marker.position = userGeoPoint
                    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    mapView.overlays.add(marker)
                    mapView.invalidate()
                } else {
                    Toast.makeText(this, "Impossible de récupérer la localisation", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: SecurityException) {
            Toast.makeText(this, "Erreur de sécurité: permission manquante", Toast.LENGTH_SHORT).show()
        }
    }
}
