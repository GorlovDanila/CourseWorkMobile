package com.example.coursework.di

import com.example.coursework.data.ColorRecommendationRepositoryImpl
import com.example.coursework.data.remote.request.ColorApi
import com.example.coursework.domain.repository.ColorRecommendationRepository
import com.example.coursework.domain.usecase.GetColorRecommendationsUseCase
import com.example.coursework.domain.usecase.GetColorRecommendationsUseCaseImpl
import com.example.coursework.presentation.presenter.ColorViewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val colorRecommendationsModule = module {
    single {
        provideColorApi(
            retrofit = get(),
        )
    }
    single {
        provideColorRepository(
            colorApi = get(),
        )
    }
    single {
        provideGetColorRecommendationsUseCase(
            colorRepository = get()
        )
    }
    factory {
        ColorViewModel(
            getColorRecommendationsUseCase = get()
        )
    }
}

private fun provideColorApi(
    retrofit: Retrofit
): ColorApi = retrofit.create(ColorApi::class.java)

private fun provideColorRepository(
    colorApi: ColorApi,
): ColorRecommendationRepository = ColorRecommendationRepositoryImpl(api = colorApi)

private fun provideGetColorRecommendationsUseCase(
    colorRepository: ColorRecommendationRepository,
): GetColorRecommendationsUseCase = GetColorRecommendationsUseCaseImpl(colorRepository)