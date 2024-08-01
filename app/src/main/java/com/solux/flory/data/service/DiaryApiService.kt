package com.solux.flory.data.service

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.DIARY
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.Body
import retrofit2.http.POST

interface DiaryApiService {
    @POST("/$API/$V1/$DIARY")
    suspend fun postDiary(
        @Body requestDiaryWriteDto: RequestDiaryWriteDto
    ): BaseResponse<String>
}