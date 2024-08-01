package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.USER
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.GET

interface ProfileApiService {
    @GET("/$API/$V1/$USER")
    suspend fun getProfile(): BaseResponse<ResponseProfileDto>
}