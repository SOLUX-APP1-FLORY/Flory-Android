package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.LoginDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestLoginDto
import com.solux.flory.data.dto.response.ResponseLoginDto
import com.solux.flory.data.service.LoginApiService
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginApiService: LoginApiService
) : LoginDataSource {
    override suspend fun postLogin(requestLoginDto: RequestLoginDto): BaseResponse<ResponseLoginDto> {
        return loginApiService.postLogin(requestLoginDto)
    }
}