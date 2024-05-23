package com.example.coursework.presentation.state

import com.example.coursework.presentation.entity.ColorItem

internal sealed interface ColorScreenState {
    data object Loading: ColorScreenState
    data class Content(val colors: List<ColorItem>): ColorScreenState
    data object Empty: ColorScreenState
}