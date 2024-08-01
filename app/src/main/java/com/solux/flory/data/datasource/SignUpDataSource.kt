package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.dto.request.RequestUserInfoDto
import com.solux.flory.data.dto.response.ResponseSignUpDto
import com.solux.flory.data.dto.response.ResponseUserInfoDto

interface SignUpDataSource {
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponse<ResponseSignUpDto>
    suspend fun patchUserInfo(userId: Int, requestUserInfoDto: RequestUserInfoDto): BaseResponse<ResponseUserInfoDto>
}