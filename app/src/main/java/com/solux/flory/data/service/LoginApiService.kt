package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestLoginDto
import com.solux.flory.data.dto.response.ResponseLoginDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.AUTH
import com.solux.flory.data.service.ApiKeyStorage.LOGIN
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {
    @POST("/$API/$V1/$AUTH/$LOGIN")
    suspend fun postLogin(
        @Body requestLoginDto: RequestLoginDto,
    ): BaseResponse<ResponseLoginDto>
}