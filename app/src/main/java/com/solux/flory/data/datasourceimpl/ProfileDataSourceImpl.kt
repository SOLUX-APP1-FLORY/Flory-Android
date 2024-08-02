package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.ProfileDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.data.service.ProfileApiService
import javax.inject.Inject

class ProfileDataSourceImpl @Inject constructor(
    private val profileApiService: ProfileApiService
) : ProfileDataSource {
    override suspend fun getProfile(): BaseResponse<ResponseProfileDto> {
        return profileApiService.getProfile()
    }
}