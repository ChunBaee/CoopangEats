package com.chunb.coopangeats.src

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.lifecycle.*
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.async

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val repo = MainRepository(application)

    private val _latitude = MutableLiveData<Double>()
    val latitude : LiveData<Double> = _latitude

    private val _longitude = MutableLiveData<Double>()
    val longitude : LiveData<Double> = _longitude


    fun getUserLocation() {
        val location : Task<Location> = repo.returnUserLocation()
        location.addOnSuccessListener {
            _latitude.value = it.latitude
            _longitude.value = it.longitude
        }.addOnFailureListener {
            throw it
        }
    }

}