package com.chunb.coopangeats_clone.src.beforestart

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.chunb.coopangeats_clone.databinding.ActivityBeforeStartBinding
import com.chunb.coopangeats_clone.src.beforestart.viewmodel.BeforeStartViewModel

class BeforeStartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBeforeStartBinding
    private val viewModel by viewModels<BeforeStartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeforeStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel

        removeStatusBar()
    }

    /** 상태바 투명하게 & 뷰가 상태바를 덮게 */
    private fun removeStatusBar() {
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}