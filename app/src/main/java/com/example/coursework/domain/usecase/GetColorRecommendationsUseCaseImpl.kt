package com.example.coursework.domain.usecase

import com.example.coursework.domain.entity.ColorDomain
import com.example.coursework.domain.repository.ColorRecommendationRepository
import java.io.File

internal class GetColorRecommendationsUseCaseImpl(
    private val repository: ColorRecommendationRepository,
) : GetColorRecommendationsUseCase {

    override suspend fun invoke(file: File): ColorDomain = repository.getColorRecommendations(file)
}
