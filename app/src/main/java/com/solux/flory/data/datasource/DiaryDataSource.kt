package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryWriteDto

interface DiaryDataSource {
    suspend fun postDiary(requestDiaryWriteDto: RequestDiaryWriteDto): BaseResponse<String>
}