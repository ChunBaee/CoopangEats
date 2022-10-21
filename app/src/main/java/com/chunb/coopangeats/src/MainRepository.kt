package com.chunb.coopangeats.src

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*

class MainRepository(context: Context) {
    private val mContext = context
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    fun returnUserLocation(): Task<Location> {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext)
        return fusedLocationClient.lastLocation
    }

    fun returnUserAddress(lat : Double, lng : Double) : String {
        val geoCoder = Geocoder(mContext, Locale.KOREA)
        lateinit var currentAddress : String
        val task = geoCoder.getFromLocation(lat, lng, 1)
        if(task != null) {
            currentAddress = task[0].getAddressLine(0).substring(5)
        }
        return currentAddress
    }

}