package com.example.stataionmapping_win

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stataionmapping_win.Station.Station
import com.example.stataionmapping_win.Station.StationReader

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.stataionmapping_win.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val station: List<Station> by lazy {
        StationReader(this).read()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync{googleMap -> addMarkers(googleMap)}
    }


    override fun onMapReady(googleMap: GoogleMap) {

    }

    private fun addMarkers(googleMap: GoogleMap) {
        station.forEach { station ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(station.name)
                    .position(station.latLng)
                    .snippet(station.rating.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(station.color))
            )
        }
    }
}