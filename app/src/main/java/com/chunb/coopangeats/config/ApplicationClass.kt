package com.chunb.coopangeats_clone.config

import android.app.Application
import android.content.SharedPreferences
import retrofit2.Retrofit

class ApplicationClass : Application() {

    companion object {
        lateinit var mPreference : SharedPreferences
        lateinit var mRetrofit : Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        mPreference = applicationContext.getSharedPreferences("CoopangEats", MODE_PRIVATE)
        initRetrofit()
    }

    private fun initRetrofit() {
        //추후 Retrofit 추가할 것
   }
}