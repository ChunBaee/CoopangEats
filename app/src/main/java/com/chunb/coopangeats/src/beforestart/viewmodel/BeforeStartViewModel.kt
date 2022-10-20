package com.chunb.coopangeats.src.beforestart.viewmodel

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.chunb.coopangeats.src.beforestart.model.BeforeStartRepository

class BeforeStartViewModel(application: Application) : AndroidViewModel(application) {
    private var repo = BeforeStartRepository(application)

    fun getImageList() : MutableList<Drawable> = repo.setBeforeStartImageList()
}