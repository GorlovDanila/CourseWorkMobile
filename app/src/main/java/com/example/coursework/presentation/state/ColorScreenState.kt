package com.example.coursework.presentation.state

import com.example.coursework.presentation.entity.ListItem

internal sealed interface ColorScreenState {
    data object Loading: ColorScreenState
    data class Content(val colors: List<ListItem>): ColorScreenState
    data object Empty: ColorScreenState
}