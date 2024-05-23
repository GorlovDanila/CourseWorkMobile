package com.example.coursework.domain.repository

import com.example.coursework.domain.entity.ColorDomain
import java.io.File

interface ColorRecommendationRepository {

    suspend fun getColorRecommendations(file: File): ColorDomain
}