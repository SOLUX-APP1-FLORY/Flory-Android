package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestLetterDto
import com.solux.flory.data.dto.response.ResponseLetterDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.GIFT
import com.solux.flory.data.service.ApiKeyStorage.LETTER
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.Body
import retrofit2.http.POST

interface LetterApiService {
    @POST("/$API/$V1/$GIFT/$LETTER")
    suspend fun postLetter(
        @Body requestLetterDto: RequestLetterDto
    ): BaseResponse<ResponseLetterDto>
}