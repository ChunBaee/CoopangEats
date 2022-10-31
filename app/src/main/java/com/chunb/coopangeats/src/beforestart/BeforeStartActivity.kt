package com.chunb.coopangeats.src.beforestart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.viewpager2.widget.ViewPager2
import com.chunb.coopangeats.config.ApplicationClass
import com.chunb.coopangeats.databinding.ActivityBeforeStartBinding
import com.chunb.coopangeats.src.MainActivity
import com.chunb.coopangeats.src.beforestart.viewmodel.BeforeStartViewModel

class BeforeStartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBeforeStartBinding
    private val viewModel by viewModels<BeforeStartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeforeStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.activity = this

        removeStatusBar()
    }

    /** 상태바 투명하게 & 뷰가 상태바를 덮게 */
    private fun removeStatusBar() {
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
            )
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)

        /** 전체화면으로 확장되므로, 아래 상태바? 만큼 패딩을 줘서 높이 맞추기*/
        fun Context.navigationHeight(): Int {
            val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")

            return if (resourceId > 0) resources.getDimensionPixelSize(resourceId)
            else 0
        }
        binding.layout.setPadding(0,0,0,navigationHeight())
    }

    fun viewPager() : ViewPager2 = binding.beforeStartVpPager

    fun onClickStartBtn() {
        //팝업 안 띄워주기
        ApplicationClass.mPreference.edit().putString("AlreadyStarted", "Y").apply()
        startActivity(Intent(this, MainActivity::class.java))
    }

}