package com.example.coursework.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.databinding.ItemAdsBinding
import com.example.coursework.presentation.entity.ListItem

internal class AdsHolder(
    private val binding: ItemAdsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(adsItem: ListItem.AdsItem) {

    }

    companion object {
        fun create(
            parent: ViewGroup,
        ): AdsHolder = AdsHolder(
            binding = ItemAdsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }
}