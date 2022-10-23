package com.chunb.coopangeats.src

import android.content.Context
import android.location.Geocoder
import android.location.Location
import com.chunb.coopangeats.R
import com.chunb.coopangeats.src.home.homewl.model.HomeEventData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import java.util.*

class MainRepository(context: Context) {
    private val mContext = context
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    /** HomeWOL */
    fun returnUserLocation(): Task<Location> {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext)
        return fusedLocationClient.lastLocation
    }

    fun returnUserAddress(lat: Double, lng: Double): String {
        val geoCoder = Geocoder(mContext, Locale.KOREA)
        lateinit var currentAddress: String
        val task = geoCoder.getFromLocation(lat, lng, 1)
        if (task != null) {
            currentAddress = task[0].getAddressLine(0).substring(5)
        }
        return currentAddress
    }

    fun getDefaultLocation(): MutableList<String> {
        return mutableListOf(
            "서울시 강남구",
            "서울시 송파구",
            "서울시 서초구",
            "서울시 관악구",
            "서울시 동작구",
            "서울시 강동구",
            "서울시 마포구",
            "서울시 광진구",
            "서울시 용산구",
            "서울시 성동구",
            "서울시 강서구",
            "서울시 양천구",
            "서울시 영등포구",
            "서울시 구로구",
            "서울시 금천구",
            "서울시 서대문구",
            "서울시 은평구",
            "서울시 중구",
            "서울시 중랑구",
            "서울시 강북구",
            "서울시 성북구",
            "서울시 도봉구",
            "서울시 노원구"
        )
    }


    /** HomeWL */

    fun returnEventBanner() : MutableList<HomeEventData> {
        return mutableListOf(HomeEventData(1, mContext.getDrawable(R.drawable.img_home_wl_event_1)),
            HomeEventData(2, mContext.getDrawable(R.drawable.img_home_wl_event_2)),
            HomeEventData(3, mContext.getDrawable(R.drawable.img_home_wl_event_3)),
            HomeEventData(4, mContext.getDrawable(R.drawable.img_home_wl_event_4)),
            HomeEventData(5, mContext.getDrawable(R.drawable.img_home_wl_event_5)))
    }

}