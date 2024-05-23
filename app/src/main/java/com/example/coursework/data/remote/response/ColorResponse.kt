package com.example.coursework.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ColorResponse(
    @SerialName("colors")
    val colors: Map<String, String>
)

//@Serializable
//@JvmInline
//internal value class ColorData(val code: String)