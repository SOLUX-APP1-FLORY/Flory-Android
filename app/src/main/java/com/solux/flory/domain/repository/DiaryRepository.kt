package com.solux.flory.domain.repository

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto

interface DiaryRepository {
    suspend fun postDiary(flower: String, title: String, content: String): Result<String?>
    suspend fun patchDiary(
        id: Int,
        title: String,
        content: String,
        flower: String
    ): Result<Unit>
}