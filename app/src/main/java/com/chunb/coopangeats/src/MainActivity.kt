package com.chunb.coopangeats.src

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.chunb.coopangeats.R
import com.chunb.coopangeats.databinding.ActivityMainBinding
import com.chunb.coopangeats.src.home.HomeFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNav()
    }

    private fun setBottomNav() {
        //시작시 보여질 Fragment 설정
        supportFragmentManager.beginTransaction().replace(R.id.main_layout_container, HomeFragment()).commitAllowingStateLoss()

        binding.mainNavBottom.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_main_btm_nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_layout_container, HomeFragment()).commit()
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}