package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.ProfileDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestProfileModifyDto
import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.data.dto.response.ResponseProfileModifyDto
import com.solux.flory.data.service.ProfileApiService
import javax.inject.Inject

class ProfileDataSourceImpl @Inject constructor(
    private val profileApiService: ProfileApiService
) : ProfileDataSource {
    override suspend fun getProfile(): BaseResponse<ResponseProfileDto> {
        return profileApiService.getProfile()
    }

    override suspend fun patchProfile(
        requestProfileModifyDto: RequestProfileModifyDto
    ): BaseResponse<ResponseProfileModifyDto> {
        return profileApiService.patchProfile(requestProfileModifyDto)
    }
}