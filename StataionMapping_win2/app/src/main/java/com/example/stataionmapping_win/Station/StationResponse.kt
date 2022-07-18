package com.example.stataionmapping_win.Station

import android.graphics.Color
import com.google.android.gms.maps.model.LatLng


data class StationResponse (

    val name: String,
    val vicinity: String,
    val rating: Double,
    val lat: Double,
    val lng: Double,
    val color: Float
    )

fun StationResponse.toStation(): Station = Station(
    name = name,
    address = vicinity,
    rating =  rating,
    latLng = LatLng(lat,lng),
    color = color
)
