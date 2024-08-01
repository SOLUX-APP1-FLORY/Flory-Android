package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryModifyDto
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto

interface DiaryDataSource {
    suspend fun postDiary(requestDiaryWriteDto: RequestDiaryWriteDto): BaseResponse<String>
    suspend fun patchDiary(requestDiaryModifyDto: RequestDiaryModifyDto): BaseResponse<ResponseDiaryModifyDto>
}