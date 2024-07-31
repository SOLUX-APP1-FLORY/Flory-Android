package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.SignUpDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.service.SignUpApiService
import javax.inject.Inject

class
SignUpDataSourceImpl @Inject constructor(
    private val signUpApiService: SignUpApiService
) : SignUpDataSource {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponse<Unit> {
        return signUpApiService.postSignUp(requestSignUpDto)
    }
}