package com.example.coursework.presentation.entity

internal sealed class ListItem {
    data class ColorItem(val name: String, val code: String) : ListItem()
    data class AdsItem(val title: String) : ListItem()
}