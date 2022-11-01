package com.chunb.coopangeats.src.home.homewl

import android.os.Bundle
import android.util.LayoutDirection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import com.chunb.coopangeats.R
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

        binding.chiptest.layoutDirection = View.LAYOUT_DIRECTION_RTL

        return binding.root
    }


    fun VPCheckTextView(): TextView = binding.fgHomeWlTvEventIndicator
    fun ToolbannerTargetView() : View = binding.fgHomeWlViewCenterBannerDivider
    fun ToolbannerView() : ConstraintLayout = binding.fgHomeWlLayoutToolbanner
    fun StickyView() : ConstraintLayout = binding.fgHomeWlLayoutStickyStore
    fun StickyStandard() : View = binding.fgHomeWlLayoutStickyStandard

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

    fun onStickyAuthStoreClick(view : View) {
        val removeAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.fg_home_wl_sticky_authed_store_remove)
        val makeAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.fg_home_wl_sticky_cheetha_blue_open)
        binding.fgHomeWlInnerLayoutAuthed.startAnimation(removeAnim)
        removeAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.fgHomeWlInnerLayoutAuthed.visibility = View.GONE
                binding.fgHomeWlInnerLayoutCheethaBlue.startAnimation(makeAnim)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
        makeAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.fgHomeWlInnerLayoutCheethaBlue.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }
}