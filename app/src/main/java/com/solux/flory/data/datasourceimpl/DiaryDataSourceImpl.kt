package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.DiaryDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryModifyDto
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.dto.response.ResponseDiariesDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto
import com.solux.flory.data.dto.response.ResponseDiaryViewDto
import com.solux.flory.data.dto.response.ResponseDiaryWriteDto
import com.solux.flory.data.service.DiaryApiService
import javax.inject.Inject

class DiaryDataSourceImpl @Inject constructor(
    private val diaryApiService: DiaryApiService
) : DiaryDataSource {
    override suspend fun postDiary(requestDiaryWriteDto: RequestDiaryWriteDto): BaseResponse<ResponseDiaryWriteDto> {
        return diaryApiService.postDiary(requestDiaryWriteDto)
    }

    override suspend fun patchDiary(requestDiaryModifyDto: RequestDiaryModifyDto): BaseResponse<ResponseDiaryModifyDto> {
        return diaryApiService.patchDiary(requestDiaryModifyDto)
    }

    override suspend fun getDiaries(year: Int, month: Int, day: Int): BaseResponse<ResponseDiariesDto> {
        return diaryApiService.getDiaries(year, month, day)
    }

    override suspend fun getDiaryView(
        year: Int,
        month: Int,
        day: Int
    ): BaseResponse<ResponseDiaryViewDto> {
        return diaryApiService.getDiaryView(year, month, day)
    }
}