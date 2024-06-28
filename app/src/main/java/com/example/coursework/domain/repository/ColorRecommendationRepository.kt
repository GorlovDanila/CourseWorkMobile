package com.example.coursework.domain.repository

import com.example.coursework.domain.entity.ColorDomain

interface ColorRecommendationRepository {

    suspend fun getColorRecommendations(): ColorDomain
}