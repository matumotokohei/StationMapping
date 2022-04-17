package com.example.stataionmapping_win.Station


import android.content.Context
import com.example.stataionmapping_win.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader


class StationReader(private val context: Context) {

     private val gson = Gson()
     private val inputStream: InputStream
          get() = context.resources.openRawResource(R.raw.station)

     fun  read(): List<Station> {
          val itemType = object : TypeToken<List<StationResponse>>() {}.type
          val reader = InputStreamReader(inputStream)
          return gson.fromJson<List<StationResponse>>(reader, itemType).map {
               it.toStation()
          }
     }







}
