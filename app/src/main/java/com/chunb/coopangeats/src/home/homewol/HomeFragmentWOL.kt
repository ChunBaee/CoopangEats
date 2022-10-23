package com.chunb.coopangeats.src.home.homewol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.chunb.coopangeats.databinding.FragmentHomeWithoutLocationBinding
import com.chunb.coopangeats.src.MainViewModel

class HomeFragmentWOL : Fragment() {
    private lateinit var binding : FragmentHomeWithoutLocationBinding
    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeWithoutLocationBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        return binding.root
    }
}