package com.chunb.coopangeats.src.home.homewl

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import com.chunb.coopangeats.databinding.FragmentHomeWithLocationBinding
import com.chunb.coopangeats.src.MainViewModel
import kotlinx.coroutines.*


class HomeFragmentWL : Fragment() {
    private lateinit var binding: FragmentHomeWithLocationBinding
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeWithLocationBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.fragment = this


        coroutineScroll()

        return binding.root
    }

    fun VPCheckTextView(): TextView = binding.fgHomeWlTvEventIndicator

    private fun coroutineScroll() {
        lifecycleScope.launch {
            whenResumed {
                while (isResumed) {
                    delay(1000)
                    binding.fgHomeWlVpEventBanner.currentItem =
                        binding.fgHomeWlVpEventBanner.currentItem + 1
                }
            }
        }
    }
}