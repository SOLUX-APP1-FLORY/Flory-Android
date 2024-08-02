package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.LetterDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestLetterDto
import com.solux.flory.data.dto.response.ResponseLetterDto
import com.solux.flory.data.service.LetterApiService
import javax.inject.Inject

class LetterDataSourceImpl @Inject constructor(
    private val letterApiService: LetterApiService
) : LetterDataSource {
    override suspend fun postLetter(requestLetterDto: RequestLetterDto): BaseResponse<ResponseLetterDto> {
        return letterApiService.postLetter(requestLetterDto)
    }
}