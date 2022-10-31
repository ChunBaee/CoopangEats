package com.chunb.coopangeats.src.home.homewl.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chunb.coopangeats.databinding.ItemRvHomeWlCategoriesBinding
import com.chunb.coopangeats.src.home.homewl.model.HomeCategoryData

class HomeCategoryAdapter(list : MutableList<HomeCategoryData>) : RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder>() {
    private val mList = list

    inner class HomeCategoryViewHolder (val binding : ItemRvHomeWlCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : HomeCategoryData) {
            binding.data = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        return HomeCategoryViewHolder(ItemRvHomeWlCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int = mList.size
}