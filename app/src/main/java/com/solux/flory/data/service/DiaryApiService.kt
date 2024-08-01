package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryModifyDto
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.DIARY
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface DiaryApiService {
    @POST("/$API/$V1/$DIARY")
    suspend fun postDiary(
        @Body requestDiaryWriteDto: RequestDiaryWriteDto
    ): BaseResponse<String>

    @PATCH("/$API/$V1/$DIARY")
    suspend fun patchDiary(
        @Body requestDiaryModifyDto: RequestDiaryModifyDto
    ): BaseResponse<ResponseDiaryModifyDto>
}