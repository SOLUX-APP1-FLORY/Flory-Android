package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto

interface SignUpDataSource {
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): BaseResponse<Unit>
}