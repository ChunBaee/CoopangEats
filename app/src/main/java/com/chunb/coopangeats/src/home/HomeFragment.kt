package com.chunb.coopangeats.src.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.chunb.coopangeats.databinding.FragmentHomeBinding
import com.chunb.coopangeats.src.MainViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by activityViewModels<MainViewModel>()

    private var PERM_LIST = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        getLocationPermission()
        getUserLocation()

        return binding.root
    }

    private fun getLocationPermission() {
        if (checkHasPermission().not()) {
            //ActivityCompat.requestPermissions(requireActivity(), PERM_LIST, 1)
            requestPermissions.launch(PERM_LIST)
        } else {
            viewModel.getUserLocation()
            Log.d("----", "getLocationPermission: ACCESSED")
        }
    }

    private fun getUserLocation() {
        viewModel.longitude.observe(requireActivity()) {
            Log.d("----", "getUserLocation: $it, ${viewModel.latitude.value}")
        }
    }

    private fun checkHasPermission(): Boolean {
        var result = false
        for (i in PERM_LIST) {
            result = if (isPermissionGranted(i)) true else return false
        }
        return result
    }

    private fun isPermissionGranted(i: String): Boolean {
        return checkSelfPermission(requireContext(), i) == PackageManager.PERMISSION_GRANTED
    }

    private val requestPermissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (checkHasPermission()) {
            Log.d("----", "ACCESS: ACCESS")
            viewModel.getUserLocation()
        }
        else Log.d("----", "it : FINALLY DENIED")
    }

}