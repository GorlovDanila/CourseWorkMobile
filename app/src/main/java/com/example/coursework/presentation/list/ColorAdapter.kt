package com.example.coursework.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.presentation.entity.ListItem

internal class ColorAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<ListItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> ColorHolder.create(parent)
            1 -> AdsHolder.create(parent)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val currentItem = data[position]) {
            is ListItem.ColorItem -> (holder as ColorHolder).onBind(currentItem)
            is ListItem.AdsItem -> (holder as AdsHolder).onBind(currentItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is ListItem.ColorItem -> 0
            is ListItem.AdsItem -> 1
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
