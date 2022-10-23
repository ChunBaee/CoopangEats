package com.chunb.coopangeats.src.home.homewl

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.chunb.coopangeats.databinding.FragmentHomeWithLocationBinding
import com.chunb.coopangeats.src.MainViewModel


class HomeFragmentWL : Fragment() {
    private lateinit var binding: FragmentHomeWithLocationBinding
    private val viewModel by activityViewModels<MainViewModel>()

    private var vpThread: Thread? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeWithLocationBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.fragment = this

        setVPAutoMaticScroll()

        return binding.root
    }

    fun VPCheckTextView(): TextView = binding.fgHomeWlTvEventIndicator

    private fun setVPAutoMaticScroll() {
        vpThread = Thread {
            while (true) {
                try {
                    Thread.sleep(5000)
                    Log.d("----", "setVPAutoMaticScroll: upup")
                    binding.fgHomeWlVpEventBanner.currentItem =
                        binding.fgHomeWlVpEventBanner.currentItem + 1
                } catch (e: InterruptedException) {
                    Log.d("----", "setVPAutoMaticScroll: interrupted")
                    return@Thread
                }
            }
        }
        vpThread!!.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        vpThread!!.interrupt()
    }
}