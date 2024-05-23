package com.example.coursework.presentation.mapper

import com.example.coursework.domain.entity.ColorDomain
import com.example.coursework.presentation.entity.ColorItem

internal fun ColorDomain.toColorPres(): List<ColorItem> = colors.entries.map { ColorItem(it.key, it.value) }

