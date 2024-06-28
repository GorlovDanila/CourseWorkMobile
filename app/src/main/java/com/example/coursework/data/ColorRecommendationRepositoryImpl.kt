package com.example.coursework.data

import com.example.coursework.data.remote.request.ColorApi
import com.example.coursework.domain.entity.ColorDomain
import com.example.coursework.domain.repository.ColorRecommendationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class ColorRecommendationRepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val api: ColorApi,
) : ColorRecommendationRepository {

    override suspend fun getColorRecommendations(): ColorDomain {
        return ColorDomain(
            colors = mapOf(
                "IndianRed" to "#CD5C5C",
                "Lime" to "#00FF00",
                "DeepPink" to "#FF1494",
            )
        )
//        return withContext(dispatcher) {
//            val requestFile = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
//            val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
//
//            api
//                .uploadFile(
//                   body
//                ).toColorDomain()
//        }
    }
}