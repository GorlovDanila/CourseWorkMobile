package com.example.coursework.domain.usecase

import com.example.coursework.domain.entity.ColorDomain
import java.io.File

interface GetColorRecommendationsUseCase {

    suspend operator fun invoke(file: File): ColorDomain
}