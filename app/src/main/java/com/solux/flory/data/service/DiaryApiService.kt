package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryModifyDto
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.dto.response.ResponseDiariesDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.DIARIES
import com.solux.flory.data.service.ApiKeyStorage.DIARY
import com.solux.flory.data.service.ApiKeyStorage.MAIN
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface DiaryApiService {
    @POST("/$API/$V1/$DIARY")
    suspend fun postDiary(
        @Body requestDiaryWriteDto: RequestDiaryWriteDto
    ): BaseResponse<String>

    @PATCH("/$API/$V1/$DIARY")
    suspend fun patchDiary(
        @Body requestDiaryModifyDto: RequestDiaryModifyDto
    ): BaseResponse<ResponseDiaryModifyDto>

    @GET("/$API/$V1/$MAIN/$DIARIES")
    suspend fun getDiaries(
        @Query("year") year: Int,
        @Query("month") month: Int,
        @Query("day") day: Int,
    ): BaseResponse<ResponseDiariesDto?>
}