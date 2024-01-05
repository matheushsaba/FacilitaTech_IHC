//package com.example.facilitatech
//
//import android.Manifest
//import android.content.pm.PackageManager
//import android.location.Location
//import android.os.Bundle
//import android.widget.TextView
//import androidx.activity.ComponentActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//
//class GeopositionActivity : ComponentActivity() {
//
//    private lateinit var textViewLatitude: TextView
//    private lateinit var textViewLongitude: TextView
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_geoposition_values)
//
//        textViewLatitude = findViewById(R.id.tv_latitude)
//        textViewLongitude = findViewById(R.id.tv_longitude)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//        checkLocationPermission()
//    }
//
//    private fun checkLocationPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
//            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(this,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
//                REQUEST_LOCATION_PERMISSION)
//        } else {
//            getLastLocation()
//        }
//    }
//
//    private fun getLastLocation() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // Permission is not granted, return early
//            return
//        }
//        fusedLocationClient.lastLocation
//            .addOnSuccessListener { location : Location? ->
//                location?.let {
//                    textViewLatitude.text = String.format("%.0f", location.latitude)
//                    textViewLongitude.text = String.format("%.0f", location.longitude)
//                }
//            }
//    }
//
//    companion object {
//        private const val REQUEST_LOCATION_PERMISSION = 1
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            REQUEST_LOCATION_PERMISSION -> {
//                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                    getLastLocation()
//                }
//                return
//            }
//        }
//    }
//}