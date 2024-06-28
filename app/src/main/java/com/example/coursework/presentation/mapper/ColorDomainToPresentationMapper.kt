package com.example.coursework.presentation.mapper

import com.example.coursework.domain.entity.ColorDomain
import com.example.coursework.presentation.entity.ListItem

internal fun ColorDomain.toColorPres(): List<ListItem.ColorItem> = colors.entries.map { ListItem.ColorItem(it.key, it.value) }

