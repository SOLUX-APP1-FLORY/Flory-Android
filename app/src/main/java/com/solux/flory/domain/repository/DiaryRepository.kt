package com.solux.flory.domain.repository

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseDiariesDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto
import com.solux.flory.domain.entity.DiariesEntity

interface DiaryRepository {
    suspend fun postDiary(flower: String, title: String, content: String): Result<String?>
    suspend fun patchDiary(
        id: Int,
        title: String,
        content: String,
        flower: String
    ): Result<Unit>
    suspend fun getDiaries(year: Int, month: Int, day: Int): Result<DiariesEntity?>
}