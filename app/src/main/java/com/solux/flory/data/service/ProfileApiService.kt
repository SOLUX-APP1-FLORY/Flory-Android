package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestProfileModifyDto
import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.data.dto.response.ResponseProfileModifyDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.USER
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH

interface ProfileApiService {
    @GET("/$API/$V1/$USER")
    suspend fun getProfile(): BaseResponse<ResponseProfileDto>

    @PATCH("/$API/$V1/$USER")
    suspend fun patchProfile(
        @Body requestProfileModifyDto: RequestProfileModifyDto
    ): BaseResponse<ResponseProfileModifyDto>
}