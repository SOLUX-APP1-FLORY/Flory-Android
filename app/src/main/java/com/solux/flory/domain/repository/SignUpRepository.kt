package com.solux.flory.domain.repository

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.dto.request.RequestUserInfoDto
import com.solux.flory.data.dto.response.ResponseSignUpDto
import com.solux.flory.data.dto.response.ResponseUserInfoDto

interface SignUpRepository {
    suspend fun postSignUp(
        requestSignUpDto: RequestSignUpDto
    ): Result<BaseResponse<ResponseSignUpDto>>

    suspend fun patchUserInfo(
        requestUserInfoDto: RequestUserInfoDto
    ): Result<BaseResponse<ResponseUserInfoDto>>
}