package com.example.coursework.data.remote.mapper

import com.example.coursework.data.remote.response.ColorResponse
import com.example.coursework.domain.entity.ColorDomain

internal fun ColorResponse.toColorDomain() = ColorDomain(
    colors = colors
)
