package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.SignUpDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpDataSource: SignUpDataSource
) : SignUpRepository {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): Result<BaseResponse<Unit>> {
        return runCatching {
            signUpDataSource.postSignUp(requestSignUpDto)
        }
    }
}