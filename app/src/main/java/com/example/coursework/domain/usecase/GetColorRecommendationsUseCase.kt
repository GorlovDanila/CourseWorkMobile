package com.example.coursework.domain.usecase

import com.example.coursework.domain.entity.ColorDomain

interface GetColorRecommendationsUseCase {

    suspend operator fun invoke(): ColorDomain
}