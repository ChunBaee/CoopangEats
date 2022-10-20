package com.chunb.coopangeats_clone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chunb.coopangeats_clone.config.ApplicationClass
import com.chunb.coopangeats_clone.src.MainActivity
import com.chunb.coopangeats_clone.src.beforestart.BeforeStartActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSleep()
        checkSP()
    }

    private fun initSleep() {
        Thread.sleep(2000)
    }

    private fun checkSP() {
        if(ApplicationClass.mPreference.getString("AlreadyStarted", "") != null) {
            initBeforeStartIntent()
        } else initMainIntent()

    }

    private fun initMainIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initBeforeStartIntent() {
        val intent = Intent(this, BeforeStartActivity::class.java)
        startActivity(intent)
        finish()
    }
}