package com.chunb.coopangeats.src.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.chunb.coopangeats.R
import com.chunb.coopangeats.databinding.FragmentHomeBinding
import com.chunb.coopangeats.src.MainViewModel
import com.chunb.coopangeats.src.home.homewl.HomeFragmentWL
import com.chunb.coopangeats.src.home.homewol.HomeFragmentWOL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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

        return binding.root
    }

    private fun getLocationPermission() {
        if (!checkHasPermission()) {
            requestPermissions.launch(PERM_LIST)
        } else {
            viewModel.getUserLocation()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fg_home_layout_container, HomeFragmentWL()).commit()
        }
    }

    private fun checkHasPermission(): Boolean {
        var result = false
        for (i in PERM_LIST) {
            result = isPermissionGranted(i)
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
            viewModel.getUserLocation()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fg_home_layout_container, HomeFragmentWL()).commit()
        } else {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fg_home_layout_container, HomeFragmentWOL()).commit()
            showPermissionDialog()
        }
    }

    private fun showPermissionDialog() {
        val builder =
            AlertDialog.Builder(requireContext()).setMessage("위치 서비스를 사용하시려면\n접근권한을 허용해 주세요.")
        builder.setPositiveButton("설정") { _, _ ->
            val intent =
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(Uri.parse("package:${requireContext().packageName}"))
            startActivity(intent)
        }
        builder.setNegativeButton("취소") { _, _ ->
            Log.d("----", "it : FINALLY DENIED")
        }
        builder.create().show()
    }

}