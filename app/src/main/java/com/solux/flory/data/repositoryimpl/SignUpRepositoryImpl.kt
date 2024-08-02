package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.SignUpDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.dto.request.RequestUserInfoDto
import com.solux.flory.data.dto.response.ResponseSignUpDto
import com.solux.flory.data.dto.response.ResponseUserInfoDto
import com.solux.flory.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpDataSource: SignUpDataSource
) : SignUpRepository {
    override suspend fun postSignUp(
        requestSignUpDto: RequestSignUpDto
    ): Result<BaseResponse<ResponseSignUpDto>> {
        return runCatching {
            signUpDataSource.postSignUp(requestSignUpDto)
        }
    }

    override suspend fun patchUserInfo(
        requestUserInfoDto: RequestUserInfoDto
    ): Result<BaseResponse<ResponseUserInfoDto>> {
        return runCatching {
            signUpDataSource.patchUserInfo(requestUserInfoDto)
        }
    }

}