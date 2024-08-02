package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseProfileDto

interface ProfileDataSource {
    suspend fun getProfile(): BaseResponse<ResponseProfileDto>
}