package com.example.coursework.domain.usecase

import com.example.coursework.domain.entity.ColorDomain
import com.example.coursework.domain.repository.ColorRecommendationRepository

internal class GetColorRecommendationsUseCaseImpl(
    private val repository: ColorRecommendationRepository,
) : GetColorRecommendationsUseCase {

    override suspend fun invoke(): ColorDomain = repository.getColorRecommendations()
}
