package com.example.coursework.data.remote.request

import com.example.coursework.data.remote.response.ColorResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

internal interface ColorApi {

    @Multipart
    @POST("rec/upload")
    suspend fun uploadFile(@Part file: MultipartBody.Part): ColorResponse
}