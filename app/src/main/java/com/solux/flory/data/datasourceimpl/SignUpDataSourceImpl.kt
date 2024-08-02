package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.SignUpDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.dto.request.RequestUserInfoDto
import com.solux.flory.data.dto.response.ResponseSignUpDto
import com.solux.flory.data.dto.response.ResponseUserInfoDto
import com.solux.flory.data.service.SignUpApiService
import javax.inject.Inject

class
SignUpDataSourceImpl @Inject constructor(
    private val signUpApiService: SignUpApiService
) : SignUpDataSource {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponse<ResponseSignUpDto> {
        return signUpApiService.postSignUp(requestSignUpDto)
    }

    override suspend fun patchUserInfo(
        requestUserInfoDto: RequestUserInfoDto
    ): BaseResponse<ResponseUserInfoDto> {
        return signUpApiService.patchUserInfo(requestUserInfoDto)
    }
}