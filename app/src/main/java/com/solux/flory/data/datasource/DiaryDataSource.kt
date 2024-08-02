package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryModifyDto
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.dto.response.ResponseDiariesDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto
import com.solux.flory.data.dto.response.ResponseDiaryViewDto
import com.solux.flory.data.dto.response.ResponseDiaryWriteDto

interface DiaryDataSource {
    suspend fun postDiary(requestDiaryWriteDto: RequestDiaryWriteDto): BaseResponse<ResponseDiaryWriteDto>
    suspend fun patchDiary(requestDiaryModifyDto: RequestDiaryModifyDto): BaseResponse<ResponseDiaryModifyDto>
    suspend fun getDiaries(year: Int, month: Int, day: Int): BaseResponse<ResponseDiariesDto>
    suspend fun getDiaryView(year: Int, month: Int, day: Int): BaseResponse<ResponseDiaryViewDto>
}