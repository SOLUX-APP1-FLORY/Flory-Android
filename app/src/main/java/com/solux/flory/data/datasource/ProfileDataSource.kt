package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestProfileModifyDto
import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.data.dto.response.ResponseProfileModifyDto

interface ProfileDataSource {
    suspend fun getProfile(): BaseResponse<ResponseProfileDto>
    suspend fun patchProfile(requestProfileModifyDto: RequestProfileModifyDto): BaseResponse<ResponseProfileModifyDto>
}