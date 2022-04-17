package com.example.stataionmapping_win

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.stataionmapping_win.Station.Station
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class MarkerInfoWindowAdapter(private val context: Context) : GoogleMap.InfoWindowAdapter {
    override fun getInfoContents(marker: Marker): View? {
        val station = marker.tag as? Station ?: return null

        // 2. Inflate view and set title, address and rating
        val view = LayoutInflater.from(context).inflate(R.layout.marker_info_contents, null)
        view.findViewById<TextView>(R.id.text_view_title).text = station.name
        view.findViewById<TextView>(R.id.text_view_address).text = station.address
        view.findViewById<TextView>(R.id.text_view_rating).text = "Rating: %.2f".format(station.rating)

        return view
    }
    override fun getInfoWindow(marker: Marker): View? {
        // Return null to indicate that the default window (white bubble) should be used
        return null
    }
}