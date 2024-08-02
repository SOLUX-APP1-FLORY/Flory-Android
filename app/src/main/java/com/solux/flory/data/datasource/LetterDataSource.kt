package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestLetterDto
import com.solux.flory.data.dto.response.ResponseLetterDto

interface LetterDataSource {
    suspend fun postLetter(requestLetterDto: RequestLetterDto): BaseResponse<ResponseLetterDto>
}