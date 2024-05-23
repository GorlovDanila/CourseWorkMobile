package com.example.coursework.presentation.list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.databinding.ItemColorBinding
import com.example.coursework.presentation.entity.ColorItem

internal class ColorHolder(
    private val binding: ItemColorBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(colorItem: ColorItem) {
        with(binding) {
            tvColorName.text = colorItem.name
            vColor.setBackgroundColor(Color.parseColor(colorItem.code))
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
        ): ColorHolder = ColorHolder(
            binding = ItemColorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }
}