package com.chunb.coopangeats.src

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.lifecycle.*
import com.chunb.coopangeats.src.home.homewl.model.HomeCategoryData
import com.chunb.coopangeats.src.home.homewl.model.HomeEventData
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.async

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val repo = MainRepository(application)

    private val _latitude = MutableLiveData<Double>()
    val latitude : LiveData<Double> = _latitude

    private val _longitude = MutableLiveData<Double>()
    val longitude : LiveData<Double> = _longitude

    private val _userLocationName = MutableLiveData<String>("주소 입력하기")
    val userLocationName : LiveData<String> = _userLocationName

    /** HomeWOL */

    fun getUserLocation() {
        //유저 현재 좌표 가져오기
        val location : Task<Location> = repo.returnUserLocation()
        location.addOnSuccessListener {
            _latitude.value = it.latitude
            _longitude.value = it.longitude
            _userLocationName.value = repo.returnUserAddress(it.latitude, it.longitude)
        }.addOnFailureListener {
            throw it
        }
    }

    fun getDefaultLocationList() : MutableList<String> {
        return repo.getDefaultLocation()
    }

    /** HomeWL */
    fun getHomeEventBanner() : MutableList<HomeEventData> {
        return repo.returnEventBanner()
    }

    fun getHomeCategories() : MutableList<HomeCategoryData> {
        return repo.returnCategoryImages()
    }

}