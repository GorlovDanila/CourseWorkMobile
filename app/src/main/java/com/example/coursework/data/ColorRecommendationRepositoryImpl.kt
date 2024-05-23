package com.example.coursework.data

import com.example.coursework.data.remote.mapper.toColorDomain
import com.example.coursework.data.remote.request.ColorApi
import com.example.coursework.domain.entity.ColorDomain
import com.example.coursework.domain.repository.ColorRecommendationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

internal class ColorRecommendationRepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val api: ColorApi,
) : ColorRecommendationRepository {

    override suspend fun getColorRecommendations(file: File): ColorDomain {
        return withContext(dispatcher) {
            val requestFile = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
            val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

            api
                .uploadFile(
                   body
                ).toColorDomain()
        }
    }
}