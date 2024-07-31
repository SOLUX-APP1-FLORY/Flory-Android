package com.solux.flory.domain.repository

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto

interface SignUpRepository {
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): Result<BaseResponse<Unit>>
}